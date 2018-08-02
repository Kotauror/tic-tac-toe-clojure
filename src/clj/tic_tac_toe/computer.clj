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

(defn best-move-and-score [depth moves] 
  (if (is-max-player-level? depth)
    (apply max-key val moves)
    (apply min-key val moves)))

(defn best-score-at-depth [depth moves]
  (val (best-move-and-score depth moves)))

(defn best-move [moves]
  (key (apply max-key val moves)))

(defn get-score [board first-sign second-sign depth]
  (cond (winner? first-sign board) (- max-value-of-place depth)
        (winner? second-sign board) (- (- max-value-of-place depth))
        (is-tie? board) tie-value-of-place
        :else (best-score-at-depth depth (score-moves board first-sign second-sign depth))))

(defn get-sign-for-depth [depth first-sign second-sign]
  (if (is-max-player-level? depth)
    first-sign
    second-sign))

(defn score-moves [board first-sign second-sign depth]
  (let [
       moves (get-free-places board)
       scores (map #(get-score (put-sign-on-board board (str %) (get-sign-for-depth depth first-sign second-sign)) first-sign second-sign (inc depth)) moves)]
  (zipmap moves scores)))

(defn minimax [board]
  (best-move (score-moves board (get-current-mark board) (get-opponent-mark board) 0)))
