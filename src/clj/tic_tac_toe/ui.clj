(ns tic_tac_toe.ui
  (:require [clojure.math.numeric-tower :as math]))

(defn string-row [subvector]
  (clojure.string/join " " subvector))

(defn show-board [board]
  (print (string-row (subvec board 0 3)))
  (println)
  (print (string-row (subvec board 3 6)))
  (println)
  (print (string-row (subvec board 6 9))))
