(ns hello.t08-js-interop)

;; ClojureScript provides a simple access to host platform
;; (Browser or Node.js) via `js` namespace

;; `js` namespace maps to `window` object when running in a browser

;; ### Calling functions
;;

(js/setTimeout #(js/console.log "Hello!") 1000)
;; setTimeout(() => alert("Hello!"), 1000)


;; ### Calling methods
;;

(.setItem js/localStorage "key" "value")
;; localStorage.setItem("key", "value")

(js/localStorage.getItem "key")
;; localStorage.getItem("key")


;; ### JS Object and Array
;;

#js {:a 1 :b 2}

#js [1 2 3]


;; ### get/set JS object properties
;;

(def obj #js {})

(set! obj.key #js {:value "my-value"})
(.-key obj)

;; or nested properties

(.. obj -key -value)
(set! (.. obj -key -value) "new-value")


;; ### Converting between Clojure's and JavaScript's data
;;

(clj->js {:a 1 :b [2]})

(js->clj #js {:a 1 :b #js [2]})
