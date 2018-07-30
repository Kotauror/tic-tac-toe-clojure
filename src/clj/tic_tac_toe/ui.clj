(ns tic_tac_toe.ui)

(defn print-row [row]
  (println row))

(defn row-as-string [subvector]
  (clojure.string/join " | " subvector))

(defn show-board [board-rows]
  (mapv print-row (mapv row-as-string board-rows)))
