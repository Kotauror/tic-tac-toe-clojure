(ns tic_tac_toe.game-spec
  (:require [speclj.core :refer :all]
            [tic_tac_toe.human_player :refer [pick-position]]
            [tic_tac_toe.ui :refer [show-board
                                    print-prompt
                                    print-final-result]]
            [tic_tac_toe.board :refer [get-rows
                                       get-winner-sign
                                       is-over?
                                       create-board]]
            [tic_tac_toe.game :refer [run-game
                                      play-turn]]))

(describe "run-game"
  (with-stubs)
  (it "calls right functions"
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
  (it "prints the output if the game is over"
    (with-redefs [
      is-over? (stub :is-over-stub {:return true})
      pick-position (stub :pick-position-stub)
      get-rows (stub :get-rows-stub {:return :rows})
      show-board (stub :show-board-stub)
      get-winner-sign (stub :get-winner-sign-stub {:return :sign})
      print-final-result (stub :print-final-result-stub)]

      (play-turn [1 2 3 4 5 6 7 8 9])

      (should-have-invoked
        :show-board-stub
        {:with
          [:rows]})

      (should-have-invoked
        :is-over-stub
        {:with 
        [[1 2 3 4 5 6 7 8 9]]})

      (should-have-invoked
        :get-winner-sign-stub)

      (should-have-invoked
        :print-final-result-stub
        {:with [:sign]}))))
