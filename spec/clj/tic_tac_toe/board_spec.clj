(ns tic_tac_toe.board-spec
  (:require [speclj.core :refer :all]
            [tic_tac_toe.board :refer [create-board
                                       put-sign-on-board
                                       get-available-moves
                                       get-rows
                                       get-columns
                                       get-diagonals
                                       get-win-paths
                                       win-in-path?
                                       winner?
                                       is-over?]]))

(describe "create-board"
  (it "creates 3x3 board"
    (should= 
      [1 2 3 4 5 6 7 8 9]
      (create-board))))

(describe "put-sign-on-board"
  (it "puts sign on a specified place in board"
    (should= [1 2 "X" 4 5 6 7 8 9]
    (put-sign-on-board (create-board) "3" "X"))))

(describe "get-available-moves"
  (it "returns vector with non-taken numbers on board"
    (should= [1 2 3 4 9]
    (get-available-moves [1 2 3 4 "X" "Y" "X" "Y" 9]))))

(describe "is-over?"
  (it "returns true if the game is won (win in row), false otherwise"
    (should= true
      (is-over? "X" ["X" "X" "X" 4 5 6 7 8 9])))

  (it "returns true if the game is won (win in diagonal), false otherwise"
    (should= true
      (is-over? "X" ["X" 2 3 4 "X" 6 7 8 "X"])))

  (it "returns true if the game is won (win in column), false otherwise"
    (should= true
      (is-over? "X" ["X" 2 3 "X" 5 6 "X" 8 9]))))

(describe "win-in-path?"
  (it "returns true when there is a win in path"
    (should= true
      (win-in-path? ["X" "X" "X"] "X")))
  (it "returns false when there is no win in path"
    (should= false
      (win-in-path? ["X" 2 "X"] "X"))))

(describe "winner?"
  (it "tells if the sign is a winner"
    (should= true
      (winner? "X" ["X" "X" "X" 4 5 6 7 8 9])))
  (it "tells if the sign is not a winner"
    (should= false
      (winner? "X" ["X" 2 "X" 4 5 6 7 8 9]))))

(describe "get-rows"
  (it "returns rows in the board"
    (should= [[1 2 "X"] [4 5 6] [7 8 9]]
    (get-rows [1 2 "X" 4 5 6 7 8 9]))))

(describe "get-columns"
  (it "returns colums in the board"
    (should= [[1 4 7] [2 "X" 8] [3 6 9]]
    (get-columns [1 2 3 4 "X" 6 7 8 9]))))

(describe "get-diagonals"
  (it "returns diagonals"
    (should= [["X" 5 9] [3 5 7]]
    (get-diagonals ["X" 2 3 4 5 6 7 8 9]))))

(describe "get-win-paths"
  (it "returns win paths"
    (should=[[1 2 3]
                     [4 5 6]
                     [7 8 9]
                     [1 4 7]
                     [2 5 8]
                     [3 6 9]
                     [1 5 9]
                     [3 5 7]]
    (get-win-paths [1 2 3 4 5 6 7 8 9]))))
