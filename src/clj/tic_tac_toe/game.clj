(ns tic_tac_toe.game
  (:require [tic_tac_toe.board :refer [get-rows
                                       get-winner-sign
                                       get-current-mark
                                       get-opponent-mark
                                       is-over?
                                       create-board
                                       put-sign-on-board]]
            [tic_tac_toe.signs :refer [player-one-sign
                                       player-two-sign
                                       switch-signs]]
            [tic_tac_toe.human_player :refer [pick-position]]
            [tic_tac_toe.ui :refer [print-final-result
                                    print-prompt
                                    show-board
                                    inform-of-move]]
            [tic_tac_toe.prompts :refer [hello-prompt]]))

(defn play-turn [board]
  (show-board (get-rows board))
  (cond 
    (is-over? board) (print-final-result (get-winner-sign board))
    :else (do
      (let [picked-position (pick-position board)
            current-player (get-current-mark board)]
        (inform-of-move current-player picked-position)
        (recur (put-sign-on-board board picked-position current-player))))))

(defn run-game []
  (print-prompt hello-prompt)
  (play-turn (create-board)))

