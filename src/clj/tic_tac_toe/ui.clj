(ns tic_tac_toe.ui
  (:require [tic_tac_toe.board :refer [is-valid-position?]]
            [tic_tac_toe.prompts :refer [pick-position-prompt]]))

(defn print-row [row]
  (println row))

(defn row-as-string [subvector]
  (clojure.string/join " | " subvector))

(defn show-board [board-rows]
  (mapv print-row (mapv row-as-string board-rows)))

(defn print-prompt [prompt]
  (println prompt))

(defn get-user-input []
  (read-line))

(defn get-user-move [board]
  (print-prompt pick-position-prompt)
  (let [input (get-user-input)]
    (if (is-valid-position? input board)
      input
      (recur board))))

(defn print-final-result [winner-sign]
  (cond
    (nil? winner-sign) (println "It's a tie!")
    :else (println (str winner-sign " has won!"))))
