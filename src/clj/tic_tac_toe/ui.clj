(ns tic_tac_toe.ui)

(defn string-row [subvector]
  (clojure.string/join " | " subvector))

(defn show-board [board]
  (print (string-row (subvec board 0 3)))
  (println)
  (print (string-row (subvec board 3 6)))
  (println)
  (print (string-row (subvec board 6 9))))
