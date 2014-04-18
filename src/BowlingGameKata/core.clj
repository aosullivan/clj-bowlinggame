(ns BowlingGameKata.core
  (:use [clojure.test]))


(defn score-1 [rolls] 
  (loop [rolls rolls
         score 0]
    (if (seq rolls)
      (cond 
        (= 10 ( + (first rolls) (second rolls)))
		      (recur (drop 2 rolls)
		             (+ score 10 (nth rolls 2)))  ;two recur functions - the values get bound to rolls and score respectively
      :else
	      (recur (drop 2 rolls)
	             (+ score (first rolls) (second rolls))))
      score)))


(run-tests)

(defn score [rolls] 
  (loop [rolls rolls
         scoretotal 0]
    (if (> (count rolls) 0)
      (recur (rest rolls)
             (+ (first rolls) scoretotal)) 
      scoretotal )))

(deftest gutter-game
  (is (= (score [0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0] ) 0 )))
  
(deftest all-ones
  (is (= (score [1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1] ) 20 )))


(deftest one-five-game
  (is (= (score [1 5 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1] ) 24 )))

(deftest spare-game
  (is (= (score [5 5 3 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0] ) 16 )))



;(defn score [rolls] 
;  (loop [rolls rolls
;         score 0]
;    (if (seq rolls)
;      (recur (rest rolls)
;             (+ score (first rolls)))
;      score)))

