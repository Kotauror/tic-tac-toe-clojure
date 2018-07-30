(ns tic_tac_toe.board)

(defn create-board []
 (vec (range 1 10)))

(defn put-sign-on-board [board place sign]
  (assoc board (- (Integer/parseInt place) 1) sign))
