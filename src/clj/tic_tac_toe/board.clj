(ns tic_tac_toe.board)

(defn create-board []
 (vec (range 1 10)))

(defn put-sign-on-board [board place sign]
  (assoc board (- (Integer/parseInt place) 1) sign))

(defn get-available-moves [board]
  (filter number? board))

(defn get-rows [board]
  (partition 3 board))

(defn is-won? [board])
