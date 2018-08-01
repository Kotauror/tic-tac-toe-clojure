(ns tic_tac_toe.computer-spec
  (:require [speclj.core :refer :all]
            [tic_tac_toe.signs :refer [player-one-sign
                                       player-two-sign]]
            [tic_tac_toe.computer :refer [
                                          ;calculate-score
                                          score-moves
                                          minimax]]))

;(describe "calculate-score"
;  (it "calculates score for terminal board - active player"
;    (should= 6
;    (calculate-score ["X" "X" "X" 4 5 "Y" 7 8 9] 4 "X" "Y")))
;  (it "calculates score for terminal board - passive player"
;    (should= -6
;    (calculate-score ["Y" "Y" "Y" 4 5 "Y" 7 8 9] 4 "X" "Y"))))

(describe "score-moves"
  (it "creates a hash-map with scores for moves"
    (should= {1 10, 4 7, 7 4}
    (score-moves [1 "X" "X" 4 "O" "O" 7 "X" "O"] "X" "Y" 0))))

;(describe "minimax"
;  (it "should return top-left corner as the initial position")
 ;   (should= 1
  ;  (minimax [1 2 3 4 5 6 7 8 9] 0 player-one-sign player-two-sign)))
