(ns tic_tac_toe.human_player
  (:require [tic_tac_toe.ui :refer [print-prompt
                                    get-user-input]]))

(defn pick-position [board]
  (print-prompt "pick position")
  (get-user-input))
  
