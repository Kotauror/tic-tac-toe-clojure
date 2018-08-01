(ns tic_tac_toe.computer-spec
  (:require [speclj.core :refer :all]
            [tic_tac_toe.signs :refer [player-one-sign
                                       player-two-sign]]
            [tic_tac_toe.computer :refer [calculate-score
                                          minimax]]))

(describe "calculate-score"
  (it "calculates score for terminal board - active player"
    (should= 6
    (calculate-score ["X" "X" "X" 4 5 "Y" 7 8 9] 4 "X" "Y")))
  (it "calculates score for terminal board - passive player"
    (should= -6
    (calculate-score ["Y" "Y" "Y" 4 5 "Y" 7 8 9] 4 "X" "Y"))))

(describe "minimax"
  (it "should return top-left corner as the initial position")
    (should= 1
    (minimax [1 2 3 4 5 6 7 8 9] 0 player-one-sign player-two-sign)))
