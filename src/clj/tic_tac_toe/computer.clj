(ns tic_tac_toe.computer
  (:require [tic_tac_toe.signs :refer [switch-signs]]
            [tic_tac_toe.board :refer [winner?
                                       get-free-places
                                       put-sign-on-board
                                       is-tie?]]))
(declare score-moves)

(defn best-move-and-score [depth moves] 
  (if (= (mod depth 2) 0)
    (apply max-key val moves)
    (apply min-key val moves)))

(defn best-score-at-depth [depth moves]
  (val (best-move-and-score depth moves)))

(defn best-move [moves]
  (key (apply max-key val moves)))

(defn get-score [board active-sign passive-sign depth]
  (cond (winner? active-sign board) (- 10 depth)
        (winner? passive-sign board) (- (- 10 depth))
        (is-tie? board) 0
        :else (best-score-at-depth depth (score-moves board active-sign passive-sign depth))))

(defn player-sign [depth active-sign passive-sign]
  (if (= (mod depth 2) 0)
    active-sign
    passive-sign))

(defn score-moves [board active-sign passive-sign depth]
  (let [
       moves (get-free-places board)
       scores (map #(get-score (put-sign-on-board board (str %) (player-sign depth active-sign passive-sign)) active-sign passive-sign (inc depth)) moves)]
  (zipmap moves scores)))

(defn minimax [board level active-sign passive-sign]
  (best-move (score-moves board active-sign passive-sign 0)))
