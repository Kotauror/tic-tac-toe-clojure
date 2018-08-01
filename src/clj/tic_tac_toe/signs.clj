(ns tic_tac_toe.signs)

(def player-one-sign "X")

(def player-two-sign "O")

(defn switch-signs [current-sign]
  (if (= current-sign player-one-sign)
    player-two-sign
    player-one-sign))
