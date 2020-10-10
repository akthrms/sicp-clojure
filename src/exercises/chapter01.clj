(ns exercises.chapter01)

; 1.1

; 1.2

; 1.3

(defn sum-of-squares [a b c]
  (let [square #(* % %)
        sum #(+ (square %1) (square %2))]
    (cond
      (>= a b) (sum a (max b c))
      (>= b c) (sum b (max c a))
      :else (sum c (max a b)))))

; 1.4

(defn a-plus-abs-b [a b]
  ((if (> b 0) + -) a b))

; 1.5

(def p p)

(defn test' [x y]
  (if (= x 0) 0 y))

(test' 0 p)                                                 ; => 0

; 適用順序評価 => (= x 0) の評価の結果、y が展開されないためエラーが発生しない
; 正規順序評価 => (= x 0) の評価にかかわらず y を展開するためエラーが発生する

; 1.6

(defn new-if [predicate then-clause else-clause]
  (cond
    predicate then-clause
    :else else-clause))

(new-if (= 2 3) 0 5)                                        ; => 5
(new-if (= 1 1) 0 5)                                        ; => 0

; (defn sqrt-iter [guess x]
;   (new-if (e/good-enough? guess x)
;           guess
;           (recur (e/improve guess x) x)))
;
; then-clause と else-clause の両方が評価される

; 1.7

; 1.8

; 1.9

(defn +'' [a b]
  (if (= a 0)
    b
    (inc (+'' (dec a) b))))

; 再帰
; (+'' 4 5)
; (inc (+'' 3 5))
; (inc (inc (+'' 2 5)))
; (inc (inc (inc (+'' 1 5))))
; (inc (inc (inc (inc (+'' 0 5)))))
; (inc (inc (inc (inc 5))))
; (inc (inc (inc 6)))
; (inc (inc 7))
; (inc 8)
; 9

(defn +''' [a b]
  (if (= a 0)
    b
    (+''' (dec a) (inc b))))

; 反復
; (+''' 4 5)
; (+''' 3 6)
; (+''' 2 7)
; (+''' 1 8)
; (+''' 0 9)
; 9

; 1.10

(defn A [x y]
  (cond
    (= y 0) 0
    (= x 0) (* 2 y)
    (= y 1) 2
    :else (A (- x 1) (A x (- y 1)))))

; (A 1 10)
; => 1024
; (A 2 4)
; => 65536
; (A 3 3)
; => 65536

(defn f [n]
  (A 0 n))

; 2n

(defn g [n]
  (A 1 n))

; 2^n

(defn h [n]
  (A 2 n))

; 2^h(n-1)

(defn k [n]
  (* 5 n n))

; 5n^2

; 1.11

(defn f-rec [n]
  (if (< n 3)
    n
    (+ (f (- n 1)) (* 2 (f (- n 2))) (* 3 (f (- n 3))))))

(defn f-iter [n]
  (let [iter (fn [a b c count]
               (if (= count 0)
                 a
                 (recur b c (+ c (* 2 b) (* 3 a)) (- count 1))))]
    (iter 0 1 2 n)))

; 0 if n = 0
; 1 if n = 1
; 2 if n = 2
; 4 if n = 3 (+ (* 1 (f 2)) => (* 1 2)
;               (* 2 (f 1)) => (* 2 1)
;               (* 3 (f 0))) => (* 3 0)
; 11 if n = 4 (+ (* 1 (f 3)) => (* 1 4)
;                (* 2 (f 2)) => (* 2 2)
;                (* 3 (f 1))) => (* 3 1)

; 1.12

(defn pascals-triangle
  "row = 行, column = 列"
  [row column]
  (if (or (= column row) (= column 1))                      ; 行の最初(column=1)と最後(column=row)は1
    1
    (+ (pascals-triangle (- row 1) (- column 1))
       (pascals-triangle (- row 1) column))))

; (pascals-triangle 3 2)
; (+ (pascals-triangle 2 1) => 1
;    (pascals-triangle 2 2)) => 1
; (pascals-triangle 4 2)
; (+ (pascals-triangle 3 1) => 1
;    (pascals-triangle 3 2)) => 2

; 1.13
