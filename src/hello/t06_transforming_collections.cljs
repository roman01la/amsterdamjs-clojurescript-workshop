(ns hello.t06-transforming-collections)

;; Clojure provides a rich set of functions to manipulate collections.

;; map/filter/reduce

(map inc [1 2 3]) ;; [1, 2, 3].map(n => n + 1)
(filter odd? [1 2 3]) ;; [1, 2, 3].filter(n => n % 2)
(reduce + 0 [1 2 3]) ;; [1, 2, 3].reduce((sum, n) => n + sum, 0)


;; ### Creating collections
;;

;; These functions can create infinite sequences of values.
;; Normally an infinite sequence won't evaluate immediately,
;; because collections in Clojure are lazy.

(range 5 10)
(repeat 10 1)


;; ### Transforming collection types
;;

(into [] (list 1 2 3)) ;; [1 2 3]

(into {} [[:a 1] [:b 2]]) ;; {:a 1, :b 2}

(into #{} [1 2 3 4 4]) ;; #{1 2 3 4}


;; ### Exercise
;;

;; Create a sequence of values from `1` to `100`,
;; `filter` out `odd` values
;; and `reduce` collection to a `product` of all its values.
;; Hint: use threa-last macro.
