(ns tic_tac_toe.board-spec
  (:require [speclj.core :refer :all]
            [tic_tac_toe.board :refer [create-board
                                       put-sign-on-board]]))

(describe "create-board"
  (it "creates 3x3 board"
    (should= 
      [1 2 3 4 5 6 7 8 9]
      (create-board))))

(describe "put-sign-on-board"
  (it "puts sign on a specified place in board"
    (should= [1 2 "X" 4 5 6 7 8 9]
    (put-sign-on-board (create-board) "3" "X"))))
