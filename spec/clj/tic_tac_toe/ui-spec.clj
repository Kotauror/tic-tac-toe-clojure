(ns tic_tac_toe.ui-spec
  (:require [speclj.core :refer :all]
            [tic_tac_toe.ui :refer [get-user-move
                                    show-board
                                    print-prompt
                                    get-user-input]]))


(describe "show-board"
  (it "shows a board"
    (should=
      "1 | 2 | 3\n4 | X | 6\n7 | 8 | 9\n"
      (with-out-str (show-board [[1 2 3] [4 "X" 6] [7 8 9]])))))

(describe "print-message" 
  (it "prints a given message with a new line"
    (should=
      "test message\n"
      (with-out-str (print-prompt "test message")))))

(describe "get-user-input" 
  (it "reads the user input"
    (should= "hello test"
      (with-in-str "hello test"
        (get-user-input)))))

(describe "get-user-move"
  (it "returns user move when input is valid"
    (should= "1"
      (with-in-str "1"
        (get-user-move [1 2 3 4 5 6 7 8 9]))))
  (it "returns valid input of user"
    (should= "2"
      (with-in-str "1\n2"
        (get-user-move ["X" 2 3 4 5 6 7 8 9])))))

