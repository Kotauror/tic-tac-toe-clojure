(ns tic_tac_toe.ui-spec
  (:require [speclj.core :refer :all]
            [tic_tac_toe.ui :refer [show-board]]))


(describe "show-board"
  (it "shows a board"
    (should=
      "1 2 3\n4 X 6\n7 8 9"
      (with-out-str (show-board [1 2 3 4 "X" 6 7 8 9])))))
