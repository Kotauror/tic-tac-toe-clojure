(ns tic_tac_toe.board-spec
  (:require [speclj.core :refer :all]
            [tic_tac_toe.board :refer [create-board]]))

(describe "create-board"
  (it "creates 3x3 board"
    (should= 
      ["1" "2" "3" "4" "5" "6" "7" "8" "9"]
      (create-board))))
