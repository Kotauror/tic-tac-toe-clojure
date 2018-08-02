(ns tic_tac_toe.board
  (:require [tic_tac_toe.signs :refer [player-one-sign
                                       player-two-sign]]))

(defn create-board []
 (vec (range 1 10)))

(defn put-sign-on-board [board place sign]
  (assoc board (- (Integer/parseInt place) 1) sign))

(defn get-permitted-moves [board]
  (mapv str (filter number? board)))

(defn get-free-places [board]
  (filter number? board))

(defn has-free-places? [board]
  (boolean
    (some number? board)))

(defn is-valid-position? [position board]
  (boolean
    (some #{position} (get-permitted-moves board))))

(defn get-rows [board]
  (partition 3 board))

(defn get-columns [board]
  (apply mapv vector (get-rows board)))

(defn get-diagonals [board]
  [[(nth board 0) (nth board 4) (nth board 8)] 
   [(nth board 2) (nth board 4) (nth board 6)]])

(defn get-win-paths [board]
  (concat (get-rows board) (get-columns board) (get-diagonals board)))

(defn win-in-path? [path sign]
 (= path [sign sign sign]))

(defn winner? [sign board]
  (boolean
    (some true? (mapv #(win-in-path? % sign) (get-win-paths board)))))

(defn is-tie? [board]
  (and 
    (not (has-free-places? board))
    (not (winner? player-one-sign board))
    (not (winner? player-two-sign board))))

(defn is-over? [board]
  (or
    (winner? player-one-sign board)
    (winner? player-two-sign board)
    (is-tie? board)))

(defn get-winner-sign [board]
  (cond
    (winner? player-one-sign board) player-one-sign
    (winner? player-two-sign board) player-two-sign
    (is-tie? board) nil))

(defn get-current-mark [board]
  (let [free-places-count (count (get-free-places board))]
  (if (= (mod free-places-count 2) 0)
    player-two-sign
    player-one-sign)))

(defn get-opponent-mark [board]
  (if (= (get-current-mark board) player-one-sign)
    player-two-sign
    player-one-sign))
