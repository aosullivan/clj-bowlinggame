(ns BowlingGameKata.core
  (:use [clojure.test]))


(defn score [rolls] 
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

(deftest gutter-game
  (is (= (score [0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0] ) 0 )))
  
(deftest all-ones
  (is (= (score [1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1] ) 20 )))

(deftest spare-game
  (is (= (score [5 5 3 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0] ) 16 )))


(loop [x 1]  
  (print (clojure.string/join ["value of x: " x "\n"]))
  (if (< x 5) (recur (inc x))))


;(defn score [rolls] 
;  (loop [rolls rolls
;         score 0]
;    (if (seq rolls)
;      (recur (rest rolls)
;             (+ score (first rolls)))
;      score)))

(run-tests)