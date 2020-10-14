(ns id.zinovev.cv.views
  (:require [reagent.core :as r]
            [clojure.string :as str]
            [id.zinovev.cv.data :refer [data]]))

(defn parse-number [s]
  (cond
    (re-find #"^\d+\.\d+$" s) (js/parseFloat s)
    (re-find #"^\d+$" s)      (js/parseInt s)
    :else                   s))

(defn parse-query-string [s]
  (->> (str/split s #"&")
       (map #(str/split % #"="))
       (map (fn [[k v]]
              (when-not (str/blank? k)
                [(keyword k) (-> v
                                 js/decodeURIComponent
                                 parse-number)])))
       (remove nil?)
       (into {})))

(defn get-query-params
  ([{:keys [query-string]}] (parse-query-string query-string))
  ([]
   (->> js/window.location str (re-find #"\?(.+)")
        second
        parse-query-string)))

(defn Header []
  [:div.row {:style {:position "relative"}}
   [:div {:style {:position "absolute"
                  :top "20px"
                  :right "20px"}}
    [:a.paper-btn.btn-success {:href "https://github.com/zombiqwerty/cv/raw/master/ZinovevP_CV.pdf"
                               :target "_blank"}
     "Download PDF"]]
   [:div.col-3.col
    [:img {:src (get-in data [:header :avatarUrl])}]]
   [:div.col-9.col
    [:div.row
     [:h1 {:style {:margin 0}} (get-in data [:header :hero :name])]]
    [:div.row
     [:h4 {:style {:margin 0}} (get-in data [:header :hero :jobTitle])]]
    [:div.row
     [:span (get-in data [:header :hero :description])]]]])

(defn SidebarContent [label value]
  [:div {:style {:margin "0 0 1em"}}
   [:div [:label label]]
   [:div [:span [:strong value]]]])

(defn SidebarContentLink [label value link]
  [:div {:style {:margin "0 0 1em"}}
   [:div [:label label]]
   [:div [:a {:href link} [:strong value]]]])

(defn HeadingTitle [title]
  [:h3 {:style {:margin "0.5em 0 0.25em"}} title])

(defn Sidebar []
  (let [contact-path [:body :sidebar :contact]
        education-path [:body :content :education]
        technologies-path [:body :sidebar :technologies]
        types (some-> (get-query-params) :type (str/split #",") (#(map keyword %)))
        render-tool (fn [idx tool]
                      ^{:key idx}
                      [:span {:style {:margin "3px"} :className (rand-nth ["badge" "badge secondary" "badge success"])}
                       tool])]
    [:div
     [:div
      [HeadingTitle "Skills"]
      (into [:div]
            (->> (get-in data [:body :sidebar :skills])
                 (map (fn [skill]
                        [:span {:style {:margin "3px"}
                                :className (rand-nth ["badge" "badge secondary" "badge success"])} skill]))))]
     [:div
      [HeadingTitle "Tool Belt"]
      (into [:div]
            (if (and (not (empty? types)) (some (set types) (keys (get-in data (conj technologies-path)))))
              (map (fn [type]
                     (some->> (get-in data (conj technologies-path type :values))
                              (map-indexed render-tool))) types)
              (some->> (get-in data technologies-path)
                       keys
                       (sort-by #(get-in data (conj technologies-path % :sort)))
                       (map (fn [type]
                              (map-indexed render-tool (get-in data (conj technologies-path type :values))))))))]
     [:div
      [HeadingTitle "Languages"]
      (into [:div]
            (->> (get-in data [:body :sidebar :languages])
                 (map (fn [lang-map]
                        [:div {:style {:margin "0 0 10px"}}
                         [:span (get lang-map :language)
                          [:div {:style {:padding "5px 10px 3px"
                                         :color "white"
                                         :backgroundColor "#86a361"
                                         :width (str (* 100 (/ (get lang-map :expertise) 5)) "%")}}
                           (str (get lang-map :expertise) " / 5")]]]))))]
     [:div
      [HeadingTitle "Formal Education"]
      [SidebarContent "Faculty" (get-in data (conj education-path :degree))]
      [SidebarContent "University" (get-in data (conj education-path :school))]
      [SidebarContent "Year" (get-in data (conj education-path :year))]]
     (let [tg (get-in data (conj contact-path :telegram))
           email (get-in data (conj contact-path :email))
           linkedin (get-in data (conj contact-path :linkedIn))
           github (get-in data (conj contact-path :github))
           inst (get-in data (conj contact-path :instagram))]
       [:div
       [HeadingTitle "Contacts"]
       [SidebarContent "Phone" (get-in data (conj contact-path :phone))]
       [SidebarContent "Address" (get-in data (conj contact-path :address))]
       
        [SidebarContentLink "Email" email (str "mailto:" email)]
       [SidebarContentLink "Telegram" tg (str "https://t.me/" tg)]
        [SidebarContentLink "Linkedin" linkedin linkedin]
        [SidebarContentLink "Github" github github]
        [SidebarContentLink "Instagram" inst inst]])]))

(defn ExperienceTable [data]
  [:table {:style {:backgroundColor "#e49696"
                   :margin "0 0 0.75em"}}
   [:thead
    [:tr
     [:th "#"]
     [:th [:h4 {:style {:margin 0}} (:year data)]]]]
   (let [jobTitle (:jobTitle data)
         company (:company data)
         description (:description data)
         experiences (:experiences data)
         tasks (:tasks data)
         images (:images data)]
     [:tbody
      (when jobTitle
        [:tr
         [:td "Job Title"]
         [:td jobTitle]])
      (when company
        [:tr
         [:td "Company"]
         [:td company]])
      (when description
        [:tr
         [:td "Responsibility"]
         [:td description]])
      (when tasks
        [:tr
         [:td "Tasks"]
         [:td (into [:ol]
                    (map (fn [task] [:li task]) tasks))]])
      (when experiences
        [:tr
         [:td "Experiences"]
         [:td (if (> (count experiences) 1)
                (into [:ol]
                      (map (fn [e] [:li e]) experiences))
                [:span (first experiences)])]])])])

(defn Content []
  [:div
   [HeadingTitle "Experiences"]
   (into [:div]
         (->> (get-in data [:body :content :experience])
              (map ExperienceTable)))])

(defn Body []
  [:div.row
   [:div.col-4.col [Sidebar]]
   [:div.col-8.col [Content]]])

(defn main-panel []
  [:div
   [:div#paper
    [Header]
    [Body]]
   
   [:div {:style {:display "flex"
                  :justify-content "flex-end"
                  :margin "20px"}}
    [:div
     [:a {:href "https://github.com/codxse/my-cv"
          :target "_blank"
          :style {:color "#ccc"
                  :background "none"}}
      "Template has been forked from CODXSE's public Github repository"]]]])
