(ns tic_tac_toe.game-spec
  (:require [speclj.core :refer :all]
            [tic_tac_toe.ui :refer [show-board
                                    print-prompt]]
            [tic_tac_toe.board :refer [get-rows
                                       create-board]]
            [tic_tac_toe.game :refer [run-game
                                      play-turn]]))

(describe "run-game"
  (with-stubs)
  (it "calls play turn with a board"
    (with-redefs [
      print-prompt (stub :print-prompt-stub)
      play-turn (stub :play-turn-stub)
      create-board (stub :create-board-stub {:return :board})]

      (run-game)

      (should-have-invoked
          :play-turn-stub
          {:with
            [:board]})

      (should-have-invoked
          :print-prompt-stub))))

(describe "play-turn"
  (with-stubs)
  (it "shows the board"
    (with-redefs [
      get-rows (stub :get-rows-stub {:return :rows})
      show-board (stub :show-board-stub)]

      (play-turn [1 2 3 4 5 6 7 8 9])

      (should-have-invoked
        :show-board-stub
        {:with
          [:rows]}))))

