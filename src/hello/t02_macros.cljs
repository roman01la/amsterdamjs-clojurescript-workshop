(ns hello.t02-macros)

;; ## Fighting parens
;;

;; Sometimes it can be hard to read and understand code because of many nested expressions.
;; Clojure provides a set of macros, called threading macros, to solve this problem.
;; ->> or threading macro is also known as pipeline operator in other languages.

;; Macro ->> is called thread-last, because it inserts the first expression
;; as an argument in the next expression in the very last position.

;; Let's see how it transforms the code step by step.
;; This is how you write it down:

(->> (/ 9 3) (* 10 2) (+ 3))

;; The first expression goes into the last position in arguments list of the second expression
(->> (* 10 2 (/ 9 3)) (+ 3))

;; Repeat the same
(->> (+ 3 (* 10 2 (/ 9 3))))

;; And here's the final expression in the form that we saw it first
(+ 3 (* 10 2 (/ 9 3)))

;; We can verify expansion
(macroexpand '(->> (/ 9 3) (* 10 2) (+ 3)))

;; Threading macros become useful when building pipelines of transformations.
;; For example ->> macro suits for building collection transformations pipeline.
(->> (range 10)
     (filter odd?)
     (map inc)
     (reduce * 1))

;; or -> (thread-first) to pipe a value through multiple transformations
(-> {:fname "John" :age 31}
    (assoc :lname "Doe")
    (update :age inc))
