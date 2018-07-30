(ns tic_tac_toe.board)

(defn create-board []
 vec (mapv str (range 1 10)))
