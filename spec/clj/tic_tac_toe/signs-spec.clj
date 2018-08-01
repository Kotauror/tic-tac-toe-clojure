(ns tic_tac_toe.signs-spec
  (:require [speclj.core :refer :all]
            [tic_tac_toe.signs :refer [player-one-sign
                                       player-two-sign
                                       switch-signs]]))

(describe "switch-signs"
  (it "switches between signs - from player one to player two"
    (should= player-two-sign
    (switch-signs player-one-sign)))
  (it "switches between signs - from player two to player one"
    (should= player-one-sign
    (switch-signs player-two-sign))))


