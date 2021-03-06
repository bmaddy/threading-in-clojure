(defprotocol IAccount
  (balance [this])
  (withdraw [this val])
  (deposit [this val]))
(deftype Account [^:volatile-mutable checking]
  IAccount
  (balance [this] (println (str "Balance: $" (. this checking))))
  (withdraw [this val] ( if (<= val checking)
                            (set! checking (- checking val))
                            (println "Insufficient funds!\n")))
  (deposit [this val] (set! checking (+ checking val))))
(def your-name (Account. 5))

(balance your-name) ; Balance: $5

(withdraw your-name 1)
(balance your-name) ; Balance: $6

(deposit your-name 100)
(balance your-name) ; Balance: $106
