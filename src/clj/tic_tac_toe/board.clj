(ns tic_tac_toe.board)

(defn create-board []
 (vec (range 1 10)))

(defn put-sign-on-board [board place sign]
  (assoc board (- (Integer/parseInt place) 1) sign))

(defn get-available-moves [board]
  (filter number? board))

(defn has-free-places? [board]
  (boolean
    (some number? board)))

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

(defn is-over? [sign board]
  (winner? sign board))
