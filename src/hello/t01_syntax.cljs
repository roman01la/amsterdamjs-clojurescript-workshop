(ns hello.t01-syntax)

;; ## Syntax
;;

;; Clojure code is made of S-expressions (symbolic expressions),
;; symbols enclosed with parentheses.

(+ 1 2) ;; <- `1 + 2` in JavaScript

;; In Lisps everything is an expression,
;; there's no statements in the language (like `delete` in JavaScript).
;; The result of evaluation of the last expression is returned automatically
(do
  (+ 1 2)   ;; <- evaluated but skipped
  (+ 1 3))  ;; <- returned

;; When representing source code in Clojure,
;; the first element of an S-expression is a function name

(inc 1)

;; or a special form (syntax)

(if true "true" "false")

;; or a macro

(defn f [x] x)

;; and all remaining elements are arguments.

;; This is called “prefix notation” or “Polish notation”.


;; ## Naming
;;

;; Idiomatic Clojure/Lisp naming is to use kebab case:
;; user-name my-fancy-function

;; Predicate functions are suffixed with `?` character:

(even? 2)


;; ## Variables
;;

;; There's two types of vars in Clojure: global and local.


;; ### Global vars
;;

;; A global var is declared globally in current namespace,
;; no matter where in code it is defined.

(def x 1) ;; #'hello.01-syntax/x

;; What you see in the result of evaluation is a fully qualified name of the var.
;; The part before slash (hello.01-syntax) is the name of the namespace
;; where that var is defined.


;; ### Local bindings
;;

;; Local variables are called local bindings in Clojure.
;; You can bind values to symbols and use refer to their values in the scope of the binding.

(let [x 1
      y 2
      x (+ x 1)]
  (+ x y)
  (* x x))


;; ## Function definition
;;

(defn add [a b c]
  (+ a b c))

(add 3 4 5)

;; In fact `defn` is a macro, which expands into... `def` ✨

(def add
  (fn [a b c] (+ a b c)))

;; macros are user defined syntax constructs
;; Clojure itself is built out of many macros

;; We can verify that `defn` is a macro by forcing it to expand

(macroexpand '(defn add [a b c]
                (+ a b c)))

;; Here's a simplified implementation of `defn` macro
;; When `defn` is called it returns another Lisp form in a form of data.
;; In the body of the macro the form looks like a template
;; where missing spots are being replaced with the arguments.

(defmacro -defn [name args body]
  `(def ~name (fn ~args ~body)))


;; ### Anonymous functions (lambdas)
;;

;; `fn` form stands for anonymous function.
;; Because Clojure is a functional language and its standard library
;; provides many higher-order functions,
;; you'll often find yourself writing anonymous functions.
;; For this purpose Clojure has a shorthand notation for lambdas (anonymous functions).

;; Let's map a list of numbers into a list of same numbers + 10.
;; `map` is a higher-order function which takes mapping function
;; and a collection of values and produces a new collection of values
;; transformed using provided function.

(map (fn [v] (+ v 10)) [0 1 2 3])

;; This form can be written down much more concise using shorthand syntax

(map #(+ % 10) [0 1 2 3])

;; Shorthand syntax is function body prepended with # character.
;; Arguments doesn't have names, instead they are aliased with % character.
;; If there are more than one argument it is possible to refer them with indexed alias
;; such as %1, %2 and so on (index starts from 1).

(reduce #(* %1 %2) (range 1 10))

;; Nesting lambdas is not allowed.
