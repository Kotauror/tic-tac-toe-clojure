(ns tic_tac_toe.game
  (:require [tic_tac_toe.board :refer [get-rows
                                       get-winner-sign
                                       get-current-mark
                                       get-opponent-mark
                                       is-over?
                                       create-board
                                       put-sign-on-board]]
            [tic_tac_toe.signs :refer [player-one-sign
                                       player-two-sign]]
            [tic_tac_toe.human_player :refer [pick-position]]
            [tic_tac_toe.computer :refer [minimax]]
            [tic_tac_toe.ui :refer [print-final-result
                                    print-prompt
                                    show-board
                                    inform-of-move]]
            [tic_tac_toe.prompts :refer [hello-prompt]]))

(declare play-turn)

(defn process-move [picked-position board level]
  (let [current-player (get-current-mark board)]
  (inform-of-move current-player picked-position)
  (play-turn (put-sign-on-board board picked-position current-player) (inc level))))

(defn human-move [board level]
  (process-move (pick-position board) board level))

(defn computer-move [board level]
  (process-move (str (minimax board)) board level))

(defn play-move [board level]
  (if (= (mod level 2) 0) 
    (human-move board level)
    (computer-move board level)))

(defn play-turn [board level]
  (show-board (get-rows board))
  (if (is-over? board) 
    (print-final-result (get-winner-sign board))
    (play-move board level)))

(defn run-game []
  (print-prompt hello-prompt)
  (play-turn (create-board) 0))
