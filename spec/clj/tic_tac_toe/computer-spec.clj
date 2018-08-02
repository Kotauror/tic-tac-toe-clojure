(ns tic_tac_toe.computer-spec
  (:require [speclj.core :refer :all]
            [tic_tac_toe.signs :refer [player-one-sign
                                       player-two-sign]]
            [tic_tac_toe.computer :refer [
                                          score-moves
                                          minimax]]))

(describe "score-moves"
  (it "creates a hash-map with scores for moves - win/lose positions"
    (should= {1 9, 4 (- 8), 7 (- 8)}
    (score-moves [1 "X" "X" 4 "O" "O" 7 "X" "O"] "X" "O" 0)))
  (it "creates a hash-map with scores for moves - tie positions"
    (should= {3 0, 4 0, 9 9}
    (score-moves ["X" "O" 3 4 "X" "O" "O" "X" 9] "X" "O" 0))))

(describe "minimax"
  (it "X takes winning position"
    (should= 6
     (minimax ["X" "O" "X" 4 "O" 6 "O" "X" "X"])))
  (it "O takes winning position"
    (should= 6
     (minimax ["X" "X" 3 "O" "O" 6 "X" 8 9])))
  (it "X prevents O from winning"
    (should= 6
      (minimax ["X" "X" "O" 4 5 6 7 8 "O"])))
  (it "O prevents X from winning"
    (should= 6
      (minimax ["O" "O" "X" 4 5 6 7 8 "X"]))))
