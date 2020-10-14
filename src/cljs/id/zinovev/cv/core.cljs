(ns id.zinovev.cv.core
  (:require
   [reagent.core :as reagent]
   [id.zinovev.cv.views :as views]
   [id.zinovev.cv.config :as config]))


(defn dev-setup []
  (when config/debug?
    (println "dev mode")))

(defn ^:dev/after-load mount-root []
  (reagent/render [views/main-panel]
                  (.getElementById js/document "app")))

(defn init []
  (dev-setup)
  (mount-root))
