(ns tic_tac_toe.game
  (:require [tic_tac_toe.board :refer [get-rows
                                       get-winner-sign
                                       is-over?
                                       create-board
                                       put-sign-on-board]]
            [tic_tac_toe.signs :refer [player-one-sign
                                       player-two-sign
                                       switch-signs]]
            [tic_tac_toe.human_player :refer [pick-position]]
            [tic_tac_toe.ui :refer [print-final-result
                                    print-prompt
                                    show-board]]
            [tic_tac_toe.prompts :refer [hello-prompt]]))

(defn play-turn [board active-sign]
  (show-board (get-rows board))
  (cond 
    (is-over? board) (print-final-result (get-winner-sign board))
    :else (do
      (as-> board v
      (pick-position v)
      (put-sign-on-board board v active-sign)
      (play-turn v (switch-signs active-sign))))))

(defn run-game []
  (print-prompt hello-prompt)
  (play-turn (create-board) player-one-sign))

