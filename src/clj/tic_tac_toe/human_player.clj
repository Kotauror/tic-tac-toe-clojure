(ns tic_tac_toe.human_player
  (:require [tic_tac_toe.ui :refer [get-user-move]]
            [tic_tac_toe.prompts :refer [pick-position-prompt]]))

(defn pick-position [board]
  (get-user-move board))
