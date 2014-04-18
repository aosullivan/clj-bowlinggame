# clj-bowlinggame

A Clojure library designed to ... well, that part is up to you.

## Usage

1. Gutter game (defn score [rolls] 0)
2. No bonuses (defn score [rolls] (apply + rolls))
3. Refactor to loop
(defn score [rolls] 
  (loop [rolls rolls
         scoretotal 0]
    (if (> (count rolls) 0)
      (recur (rest rolls)
             (+ (first rolls) scoretotal)) 
      scoretotal )))
      
4. 

## License


Distributed under the Eclipse Public License, the same as Clojure.
