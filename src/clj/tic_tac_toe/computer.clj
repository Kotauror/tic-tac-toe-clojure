(ns tic_tac_toe.computer
  (:require [tic_tac_toe.board :refer [winner?
                                       put-sign-on-board
                                       is-tie?]]))

(defn calculate-score [board level active-sign passive-sign]
  (cond 
    (winner? active-sign board) (- 10 level)
    (winner? passive-sign board) (- (- 10 level)) 
    (is-tie? board) 0 ))

(defn minimax [board level active-sign passive-sign])
