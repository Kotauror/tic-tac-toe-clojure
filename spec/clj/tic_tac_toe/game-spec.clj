(ns tic_tac_toe.game-spec
  (:require [speclj.core :refer :all]
            [tic_tac_toe.board :refer [create-board]]
            [tic_tac_toe.game :refer [run-game
                                      play-turn]]))

(describe "run-game"
  (with-stubs)
  (it "calls play turn with a board"
    (with-redefs [
      play-turn (stub :play-turn-stub)
      create-board (stub :create-board-stub {:return :board})]

      (run-game)

    ( should-have-invoked
        :play-turn-stub
        {:with
          [:board]}))))

