(ns hello.t09-modules)

;; A namespace is a unit of modularity in Clojure

(comment
 (require '[clojure.string :as cstr]))
;; import * as cstr from "clojure/string"

(comment
 (require '[clojure.string :refer [join]]))
;; import { join } from "clojure/string"
