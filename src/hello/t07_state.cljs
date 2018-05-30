(ns hello.t07-state)

;; Clojure separates concepts of state and identity.
;; A single identity can have different states over time,
;; but states themselves doesn't change, because they are immutable values.

;; Let's describe a user as a hash map.

(def user
  {:first-name "John"
   :last-name "Doe"
   :age 31})

;; Now if we want to update user's age, we have to perform the actual update
;; and get a new value back

(update user :age inc)

;; Since values are immutable, the result of an update should be stored somewhere
;; in order to not loose it

;; In other words we want an identity that is represented by
;; one of those values at a single point in time

;; Atom is a special reference type (identity) that holds immutable value (state)

(def user (atom {:first-name "John"
                 :last-name "Doe"
                 :age 31}))

;; We can read current state of the atom by dereferencing it (taking a value by reference)
@user

;; Updating state of the atom is done in a functional manner
(swap! user #(update % :age inc))

;; Or setting a new value directly
(reset! user {:first-name "John"
              :last-name "Doe"
              :age 32})

;; Now a new value is stored in the atom
@user


;; ### Watching state changes over time
;;

;; Because values are immutable, we can observe different states of an identity over time.

(add-watch user :logger (fn [key ref old-state new-state]
                          (js/alert (str new-state))))

;; Try to update `user` again and see what happens :)
