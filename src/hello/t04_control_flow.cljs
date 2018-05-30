(ns hello.t04-control-flow)

;; ## Falsy & Truthy values
;;

;; In Clojure `false` and `nil` are the only falsy values,
;; everything else evaluates to logical `true`.

(some? nil)
(some? 0)
(some? "")


;; ## Comparison operators
;;

(= 1 1)
(not= 1 2)

(> 3 2 1)

;; ...


;; ## Conditionals
;;


(if (zero? 1)
  "zero!"
  "not zero")
;; if (1 === 0) {
;;   return "zero!";
;; } else {
;;   return "not zero";
;; }

(when (empty? "string")
  "string is empty")
;; if (isEmpty("string")) {
;;   return "string is empty";
;; }

(case 2
  1 "uno"
  2 "dos"
  "else")
;; switch (2) {
;;   case 1:
;;     return "uno";
;;   case 2:
;;     return "dos";
;;   default:
;;     return "else";
;; }

(cond
  (zero? 1) "zero!"
  (pos? 2)  "positive!"
  :else     "else")
;; if (1 === 0) {
;;   return "zero!";
;; } else if (2 > 0) {
;;   return "positive!";
;; } else {
;;   return "else";
;; }
