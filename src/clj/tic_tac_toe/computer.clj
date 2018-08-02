(ns tic_tac_toe.computer
  (:require [tic_tac_toe.signs :refer [switch-signs]]
            [tic_tac_toe.board :refer [winner?
                                       get-current-mark
                                       get-opponent-mark
                                       get-free-places
                                       put-sign-on-board
                                       is-tie?]]))
(declare score-moves)

(def max-value-of-place 10)
(def tie-value-of-place 0)

(defn is-max-player-level? [depth]
  (boolean
    (= (mod depth 2) 0)))

(defn pick-lowest-scoring-move [moves]
  (val (apply min-key val moves)))

(defn pick-highest-scoring-move [moves]
  (val (apply max-key val moves)))

(defn best-score-at-depth [depth moves]
  (if (is-max-player-level? depth)
    (pick-highest-scoring-move moves)
    (pick-lowest-scoring-move moves)))

(defn get-best-move [moves]
  (key (apply max-key val moves)))

(defn get-score [board max-player-sign min-player-sign depth]
  (cond (winner? max-player-sign board) (- max-value-of-place depth)
        (winner? min-player-sign board) (- (- max-value-of-place depth))
        (is-tie? board) tie-value-of-place
        :else (best-score-at-depth depth (score-moves board max-player-sign min-player-sign depth))))

(defn get-sign-for-depth [depth max-player-sign min-player-sign]
  (if (is-max-player-level? depth)
    max-player-sign
    min-player-sign))

(defn score-moves [board max-player-sign min-player-sign depth]
  (let [
       moves (get-free-places board)
       scores (map #(get-score (put-sign-on-board board (str %) (get-sign-for-depth depth max-player-sign min-player-sign)) max-player-sign min-player-sign (inc depth)) moves)]
  (zipmap moves scores)))

(defn minimax [board]
  (get-best-move (score-moves board (get-current-mark board) (get-opponent-mark board) 0)))
