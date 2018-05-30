(ns hello.timer
  (:require [reagent.core :as r]
            [goog.dom :as gdom]))

(defn app []
  [:div
   "Render timer app here..."])

(r/render [app] (gdom/getElement "app-root"))
