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
