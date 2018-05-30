(ns hello.t10-ui
  (:require [reagent.core :as r]
            [goog.dom :as gdom]))

;; In most ClojureScript wrappers for React components are described
;; with a special syntax called Hiccup,
;; where elements are built out of Clojure's data structures

[:button                          ;; tag/component-name
 {:on-click #(js/alert "Click!")} ;; attributes/props (optional)
 "press"]                         ;; children

;; <button onClick={() => alert("Click!")}>press</button>

;; In Hiccup a tag can also define HTML class and id attributes
[:div#id.class1.class2]


;; Components
;;

;; Reagent (http://reagent-project.github.io/) component
;; is a function that receives props as arguments and returns Hiccup

(defn button [on-click text]
  [:button {:on-click on-click} text])

(defn input-field [{:keys [label value on-change]}]
  [:div
   [:label label]
   [:input {:value value
            :on-change on-change}]])

;; This is how to render a component into the DOM
(r/render [button #(js/alert "hello!") "alert"] (gdom/getElement "button-target"))

;; Components can be combined together to form more complex ones
(defn subscribe-form []
  [:form
   [input-field {:label "email"
                 :value ""
                 :on-change identity}]
   [button identity "Subscribe"]])


;; State in Reagent is constructed with Atom-like type
;; when `email` is updated, component will be re-rendered automatically

(def email (r/atom ""))

(defn ajax-subscribe-form []
  [:div.form
   [input-field {:label "email"
                 :value @email
                 :on-change #(reset! email (.. % -target -value))}]
   [button #(js/alert @email) "Subscribe"]])

(r/render [ajax-subscribe-form] (gdom/getElement "form-target"))

;; Local state in components is also supported.
;; Such stateful component is created as a function that returns rendering function
;; which closes over its state and re-renders every time local state is updated
(defn ajax-subscribe-form-with-state []
  (let [email (r/atom "")]
    (fn []
      [:div.form
       [input-field {:label "email"
                     :value @email
                     :on-change #(reset! email (.. % -target -value))}]
       [button #(js/alert @email) "Subscribe"]])))

(r/render [ajax-subscribe-form-with-state] (gdom/getElement "form-local-target"))
