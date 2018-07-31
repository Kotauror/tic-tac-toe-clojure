(ns tic_tac_toe.human_player-spec
  (:require [speclj.core :refer :all]
            [tic_tac_toe.human_player :refer [pick-position]]))

(describe "pick-position"
  (it "picks valid position"
    (should= "1"
      (with-in-str "1"
        (pick-position [1 2 3 4 5 6 7 8 9])))))
