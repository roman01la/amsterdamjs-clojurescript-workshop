(defproject amsterdamjs.workshop "0.1.0-SNAPSHOT"
  :dependencies [[org.clojure/clojure "1.9.0"]
                 [org.clojure/clojurescript "1.10.238"]
                 [reagent "0.8.1"]
                 [com.bhauman/figwheel-main "0.1.4"]
                 [nightlight "RELEASE"]
                 [com.cemerick/piggieback "0.2.2"]]

  :source-paths ["src" "resources"]

  :aliases {"server" ["run" "-m" "figwheel.main" "-b" "dev" "-r"]
            "ide"    ["run" "-m" "nightlight.core" "--url" "http://localhost:3000"]}

  :repl-options {:nrepl-middleware [cemerick.piggieback/wrap-cljs-repl]})
