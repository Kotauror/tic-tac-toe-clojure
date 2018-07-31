(ns tic_tac_toe.human_player-spec
  (:require [speclj.core :refer :all]
            [tic_tac_toe.human_player :refer [pick-position]]))

(describe "pick-position"
  (it "returns position on valid input"
    (should= "1"
      (with-in-str "1"
        (pick-position [1 2 3 4 5 6 7 8 9]))))
  (it "returns valid input of the user"
    (should= "2"
        (with-in-str "1\n2"
          (pick-position ["X" 2 3 4 5 6 7 8 9])))))

