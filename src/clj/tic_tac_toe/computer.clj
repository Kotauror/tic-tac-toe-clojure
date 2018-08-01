(ns tic_tac_toe.computer
  (:require [tic_tac_toe.signs :refer [switch-signs]]
            [tic_tac_toe.board :refer [winner?
                                       get-free-places
                                       put-sign-on-board
                                       is-tie?]]))
(declare score-moves)

;(defn calculate-score [board level active-sign passive-sign]
;  (cond 
;    (winner? active-sign board) (- 10 level)
;    (winner? passive-sign board) (- (- 10 level)) 
;    (is-tie? board) 0 ))

(defn best-move-and-score [depth moves] 
  (if (= (mod depth 2) 0)
    (apply max-key val moves)
    (apply min-key val moves)))

(defn best-score-at-depth [depth moves]
  (println depth)
  (println moves)
  (val (best-move-and-score depth moves)))

(defn best-move [moves]
  (key (apply max-key val moves)))

(defn get-score [board active-sign passive-sign depth]
 ; (println depth)
  (cond (winner? passive-sign board) (- 10 depth)
        (winner? active-sign board) (- (- 10 depth))
        (is-tie? board) 0
        :else (best-score-at-depth depth (score-moves board active-sign passive-sign depth))))

(defn score-moves [board active-sign passive-sign depth]
  (let [
       moves (get-free-places board)
       scores (map #(get-score (put-sign-on-board board (str %) active-sign) (switch-signs active-sign) (switch-signs passive-sign) (inc depth)) moves)]
 ;      (println scores)
  (zipmap moves scores)))

(defn minimax [board level active-sign passive-sign]
  (best-move (score-moves board active-sign passive-sign 0)))
