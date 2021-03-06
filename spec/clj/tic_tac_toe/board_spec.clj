(ns tic_tac_toe.board-spec
  (:require [speclj.core :refer :all]
            [tic_tac_toe.signs :refer [player-one-sign
                                       player-two-sign]]
            [tic_tac_toe.board :refer [create-board
                                       put-sign-on-board
                                       has-free-places?
                                       get-permitted-moves
                                       get-rows
                                       get-columns
                                       get-free-places
                                       get-diagonals
                                       get-win-paths
                                       get-winner-sign
                                       win-in-path?
                                       winner?
                                       is-tie?
                                       is-over?
                                       get-current-mark
                                       get-opponent-mark
                                       is-valid-position?]]))

(describe "create-board"
  (it "creates 3x3 board"
    (should= 
      [1 2 3 4 5 6 7 8 9]
      (create-board))))

(describe "put-sign-on-board"
  (it "puts sign on a specified place in board"
    (should= [1 2 "X" 4 5 6 7 8 9]
    (put-sign-on-board (create-board) "3" "X"))))

(describe "has-free-places?"
  (it "returns true if board has free places"
    (should= true 
    (has-free-places? ["X" "X" "X" "X" "X" "O" "O" 8 "X"])))
  (it "returns false when board has no free places"
    (should= false
    (has-free-places? ["X" "X" "X" "X" "X" "O" "X" "O" "X"]))))

(describe "get-permitted-moves"
  (it "returns vector with non-taken numbers on board"
    (should= ["1" "2" "3" "4" "9"]
    (get-permitted-moves [1 2 3 4 "X" "Y" "X" "Y" 9]))))

(describe "get-free-places"
  (it "returns vectr with places in board vector"
    (should= [1 2 3 4 9]
    (get-free-places [1 2 3 4 "X" "X" "X" "X" 9]))))

(describe "is-over?"
  (it "returns true if the game is over (X win in row)"
    (should= true
      (is-over? ["X" "X" "X" 4 5 6 7 8 9])))
  (it "returns true if the game is over (X win in diagonal)"
    (should= true
      (is-over? ["X" 2 3 4 "X" 6 7 8 "X"])))
  (it "returns true if the game is over (X win in column)"
    (should= true
      (is-over? ["X" 2 3 "X" 5 6 "X" 8 9])))
  (it "returns true if the game is over (O win in column)"
    (should= true
      (is-over? ["O" 2 3 "O" 5 6 "O" 8 9])))
  (it "returns true if the game is over (tie)"
    (should= true
      (is-over? ["X" "O" "X" "O" "O" "X" "X" "X" "O"])))
  (it "returns false if the game is not over"
    (should= false
      (is-over? ["X" 2 3 4 5 6 7 8 "X"]))))

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

(describe "is-tie?"
  (it "returns true on tie"
    (should= true
    (is-tie? ["X" "O" "X" "O" "O" "X" "X" "X" "O"])))
  (it "returns false on tie - game won for X"
    (should= false
    (is-tie? ["X" "X" "X" 4 5 "O" "O" 8 9])))
  (it "returns false on tie - game won for O"
    (should= false
    (is-tie? ["O" "O" "O" 4 5 "X" "X" 8 9]))))

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

(describe "is-valid-position?"
  (it "returns true when position can be taken"
    (should= true 
    (is-valid-position? "1" [1 2 3 4 5 6 7 8 9])))
  (it "returns false when position is taken"
    (should= false
    (is-valid-position? "1" ["X" 2 3 4 5 6 7 8 9])))
  (it "returns false when position is outside the scope of board"
    (should= false
    (is-valid-position? "10" ["X" 2 3 4 5 6 7 8 9]))))

(describe "get-winner-sign"
  (it "returns winner sign when there is one"
    (should= "X"
    (get-winner-sign ["X" "X" "X" 4 5 6 7 8 9])))
  (it "returns nil when there is no winner sign"
    (should= nil
    (get-winner-sign ["X" "X" 3 4 5 6 7 8 9]))))

(describe "get-current-mark"
  (it "returns the current mark at the beginning of the game"
    (should= "X"
    (get-current-mark [1 2 3 4 5 6 7 8 9])))
  (it "returns the current mark for X in the middle of game"
    (should= "X"
    (get-current-mark ["X" "O" 3 4 5 6 7 8 9])))
  (it "returns the current mark for O in the middle of game"
    (should= "O"
    (get-current-mark ["X" 2 3 4 5 6 7 8 9]))))

(describe "get-opponent-mark"
  (it "returns the opponent mark at the beginning of the game"
    (should= "O"
    (get-opponent-mark [1 2 3 4 5 6 7 8 9])))
  (it "returns the opponent mark for O in the middle of the game"
    (should= "O"
    (get-opponent-mark ["X" "O" 3 4 5 6 7 8 9])))
  (it "returns the opponent mark for X in the middle of the game"
    (should= "X"
    (get-opponent-mark ["X" "O" "X" 4 5 6 7 8 9]))))
