(ns tic_tac_toe.game
  (:require [tic_tac_toe.board :refer [create-board]]))

(defn play-turn [board])

(defn run-game []
 (play-turn (create-board)))

