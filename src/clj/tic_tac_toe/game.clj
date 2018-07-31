(ns tic_tac_toe.game
  (:require [tic_tac_toe.board :refer [get-rows
                                       is-over?
                                       create-board
                                       put-sign-on-board]]
            [tic_tac_toe.human_player :refer [pick-position]]
            [tic_tac_toe.ui :refer [print-prompt
                                    show-board]]
            [tic_tac_toe.prompts :refer [hello-prompt]]))

(defn play-turn [board]
  (show-board (get-rows board))
  (cond 
    (is-over? board) (println "Over")
    :else (do 
      (recur (put-sign-on-board board (pick-position board) "X")))))

(defn run-game []
  (print-prompt hello-prompt)
  (play-turn (create-board)))

