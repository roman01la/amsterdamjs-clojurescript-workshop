(ns hello.t03-data-types)

;; ## Primitive data types
;;

;; Clojure(Script) is relying on primitive data types provided by host platform
;; - Java's in JVM Clojure
;; - JavaScript's in ClojureScript


;; Boolean
;;

true
false


;; Nil
;;
;; nil means nothing :)

nil


;; Number
;;

1
3.5


;; String
;;

"Hello!"

"multiline
string"


;; Keyword
;;

;; Keywords are symbolic identifiers that evaluate to themselves.
;; Keywords are often used as keys in maps.
;; Because keywords implement IFn protocol, they can be used as getters on maps.

(:user-name {:user-name "rich hickey"})


;; Symbol
;;

;; Symbols are identifiers that are normally used to refer to something else.
;; They can be used in program to refer to function parameters,
;; let bindings, class names and global vars.

'this-is-a-symbol

;; You may wonder why symbols are prefixed with ' character.
;; The reason is that because symbols are used to refer to values in the code,
;; normally evaluating a symbol would trigger runtime to find the value,
;; which is being referenced by the symbol.

;; In case when we want a symbol itself, as a value, we have to quote it,
;; so the compiler knows that this symbol should be treated as data,
;; rather than a reference to a value in memory.

(def user-name "clojure")

(string? user-name)

(symbol? 'user-name)
