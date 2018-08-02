(ns tic_tac_toe.game-spec
  (:require [speclj.core :refer :all]
            [tic_tac_toe.human_player :refer [pick-position]]
            [tic_tac_toe.signs :refer [player-one-sign]]
            [tic_tac_toe.ui :refer [show-board
                                    print-prompt
                                    inform-of-move
                                    print-final-result]]
            [tic_tac_toe.board :refer [get-rows
                                       get-winner-sign
                                       get-current-mark
                                       is-over?
                                       create-board]]
            [tic_tac_toe.game :refer [run-game
                                      play-turn]]))

(describe "run-game"
  (with-stubs)
  (it "runs the whole game against computer - computer wins"
    (with-redefs [
      show-board (stub :show-board-stub)
      print-prompt (stub :print-prompt-stub)
      inform-of-move (stub :inform-of-move)]
    (should= "O has won!\n"
      (with-out-str
      (with-in-str "1\n3\n9\n"
    (run-game))))))

  (it "runs the whole game against computer - tie game"
    (with-redefs [
      show-board (stub :show-board-stub)
      print-prompt (stub :print-prompt-stub)
      inform-of-move (stub :inform-of-move)]
    (should= "It's a tie!\n"
      (with-out-str
      (with-in-str "1\n7\n6\n2\n8\n"
    (run-game)))))))
