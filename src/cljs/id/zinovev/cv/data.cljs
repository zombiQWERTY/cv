(ns id.zinovev.cv.data)

(def data
  {:header {:avatarUrl "https://i.ibb.co/CJdm21m/1-Wa-ITHi-St-Z0.jpg"
            :hero {:name "Paul Zinovev"
                   :jobTitle "Full-stack javascript & clojure developer"
                   :description "Currently working as clojure developer at one of the best health-it companies in Russia. Creating and developing interfaces that uses is the health-it sector around the world"}}
   :body {:sidebar {:contact {:email "p.zinovev@pm.me"
                              :phone "+79207666430"
                              :telegram "zombiqwerty"
                              :address "Saint Petersburg, Russia"
                              :linkedIn "https://www.linkedin.com/in/zombiqwerty"
                              :github "https://github.com/zombiqwerty"
                              :instagram "https://www.instagram.com/zombiqwerty"}
                    :skills ["Website Development"
                             "Software Automation"
                             "Software Architecture"
                             "Software Abstraction"
                             "Functional Programming"
                             "Object Oriented Programming"
                             "Clean Code Architecture"]
                    :technologies {:common {:sort 100
                                            :values ["Bash"
                                                     "Consul"
                                                     "Docker"
                                                     "PostgreSQL"
                                                     "MongoDB"
                                                     "Redis"
                                                     "Nginx"
                                                     "VMWare"
                                                     "MacOS"
                                                     "Linux"
                                                     "Ansible"
                                                     "FHIR"]}
                                   :js {:sort 1
                                        :values ["NodeJS"
                                                 "NestJS"
                                                 "ReactJS"
                                                 "REDUX"
                                                 "JavaScript"
                                                 "Typescript"
                                                 "NPM"
                                                 "Webpack"
                                                 "XML/HTML"
                                                 "CSS"
                                                 "RamdaJS"]}
                                   :go {:sort 2
                                        :values ["Go" "Gokit"]}
                                   :clojure {:sort 3
                                             :values ["Clojure"
                                                      "ClojureScript"
                                                      "Reagent"
                                                      "Re-frame"
                                                      "Kee-frame"
                                                      "Leiningen"
                                                      "Deps.edn"
                                                      "Shadow-cljs"]}}
                    :languages [{:language "Russian" :expertise 5}
                                {:language "English" :expertise 3}]
                    :interest ["Programming"
                               "Startup"
                               "Automation"
                               "UI/UX"
                               "Software Architecture"
                               "Books"
                               "Cars"]}
          :content {:experience [{:jobTitle "Full-stack developer - Health-IT projects around the world"
                                  :company "Health Samurai"
                                  :year "May 2020 – Present"
                                  :description "(NDA exists) Using clojure and clojurescript reagent, re-frame, kee-frame, Working with multinational team to improve the app experience."
                                  :tasks ["Developing and maintaining apps interface"
                                          "Implement new business-valued features"
                                          "Refactoring Apps to maintainable architecture"
                                          "Fixing bugs"]}
                                 {:jobTitle "Tech Lead, the only developer - SAAS Platform for QA engineers and developers (DoQA)"
                                  :company "IT Test"
                                  :year "Aug 2019 – Jun 2020"
                                  :description "Product consists of the best parts of TestRail, Yandex.Tank, Testpad and etc. Working on back-end part. Whole application is based on microservices multi-tenancy architecture. Most of services are written on Go, and a couple on Python. For internal service communication uses GRPC. On top layer there are Docker, Kubernetes, Istio, Google Cloud."
                                  :tasks ["Developing and maintaining DoQA App"
                                          "Create coding standard"
                                          "Implement layered clean architecture that scale"
                                          "Server/cloud administration"
                                          "CI/CD development"]
                                  :images [{:imgUrl "https://i.ibb.co/kQgChG0/doqa-1920-1024-2.jpg"
                                            :title "DoQA App home"}
                                           {:imgUrl "https://i.ibb.co/1KLvKrT/screen-1.jpg"
                                            :title "DoQA App"}
                                           {:imgUrl "https://i.ibb.co/0JrqqCy/screen-2.jpg"
                                            :title "DoQA App"}
                                           {:imgUrl "https://i.ibb.co/j3gfqCj/screen-3.jpg"
                                            :title "DoQA App"}
                                           {:imgUrl "https://i.ibb.co/bsB109c/screen-4.jpg"
                                            :title "DoQA App"}]}
                                 {:jobTitle "Front-end Engineer - sblogistica.ru"
                                  :company "AGIMA"
                                  :year "Apr 2020 - Jun 2020"
                                  :description "(NDA exists) Using React js, styled components, REDUX and any other tools, my responsibility is to creating and implementing UI design; bug fixing; maintaining UI components library, create complex logic among App."
                                  :experiences ["Developing and maintaining Sblogistica internal platform interface."]}
                                 {:jobTitle "Front-end Engineer - eldorado.ru"
                                  :company "AGIMA"
                                  :year "Jun 2019 – Dec 2020"
                                  :description "One of the biggest online and offline tech-stores in Russia"
                                  :experiences ["Creating and maintaining UI for the App"]}
                                 {:jobTitle "Mobile Developer (ionic) - Streamity"
                                  :company "IT Test"
                                  :year "Apr 2019 – May 2019"
                                  :description "Mostly working as mobile front-end developer. Using ionic, cordova, capacitor, ReactJS, REDUX, typescript"
                                  :experiences ["Prototyping Streamity wallet App"
                                                "Creating and maintaining full architecture and UI for the App"]}
                                 {:jobTitle "Backend Developer - Jinga phones"
                                  :company "IT Test"
                                  :year "Feb 2019 – Apr 2019"
                                  :description "Product for mobile phone factories. Using nodeJS, nestJS, postgreSQL, Ansible, CI/CD"
                                  :experiences ["Maintaining legacy App"
                                                "Refactoring old architecture in prior to maintainability"
                                                "Integrating new features"]}
                                 {:jobTitle "Many other apps"
                                  :company "Freelance and other Russian companies"
                                  :year "Sept 2016 – Feb 2019"
                                  :description "Learning IT technologies, working on boring and amazing projects, but too much for resume."}]
                    :education {:degree "Information systems in industry. The Faculty of Information Security"
                                :school "Tula State University (TSU)"
                                :year "09/2015 - 07/2020"}}}})
