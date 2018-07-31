(ns tic_tac_toe.ui
  (:require [tic_tac_toe.prompts :refer [pick-position-prompt]]))

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
  (get-user-input))
