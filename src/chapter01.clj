(ns chapter01)

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
