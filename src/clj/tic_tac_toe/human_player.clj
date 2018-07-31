(ns tic_tac_toe.human_player
  (:require [tic_tac_toe.ui :refer [print-prompt
                                    get-user-input]]
            [tic_tac_toe.prompts :refer [pick-position-prompt]]))

(defn pick-position [board]
  (print-prompt pick-position-prompt)
  (get-user-input))
  
