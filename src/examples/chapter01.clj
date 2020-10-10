(ns examples.chapter01)

(defn square [x]
  (* x x))

(defn average [x y]
  (/ (+ x y) 2))

(defn sqrt [x]
  (let [good-enough? (fn [guess]
                       (< (Math/abs ^Double (- (square guess) x)) 0.001))
        improve (fn [guess]
                  (average guess (/ x guess)))
        sqrt-iter (fn [guess]
                    (if (good-enough? guess)
                      guess
                      (recur (improve guess))))]
    (sqrt-iter 1.0)))

(defn factorial [n]
  (let [iter (fn [product counter]
               (if (> counter n)
                 product
                 (recur (* counter product) (+ counter 1))))]
    (iter 1 1)))

(defn fact-iter [product counter max-count]
  (if (> counter max-count)
    product
    (fact-iter (* counter product)
               (+ counter 1)
               max-count)))

(defn fib [n]
  (cond
    (= n 0) 0
    (= n 1) 1
    :else (+ (fib (- n 1))
             (fib (- n 2)))))

(defn fib' [n]
  (let [fib-iter (fn [a b count]
                   (if (= count 0)
                     b
                     (recur (+ a b) a (- count 1))))]
    (fib-iter 1 0 n)))

(defn first-denomination [kinds-of-coins]
  (cond
    (= kinds-of-coins 1) 1
    (= kinds-of-coins 2) 5
    (= kinds-of-coins 3) 10
    (= kinds-of-coins 4) 25
    :else 50))

(defn cc [amount kinds-of-coins]
  (cond
    (= amount 0) 1
    (or (< amount 0) (= kinds-of-coins 0)) 0
    :else (+ (cc amount (- kinds-of-coins 1))
             (cc (- amount (first-denomination kinds-of-coins)) kinds-of-coins))))

(defn count-charge [amount]
  (cc amount 5))

; (count-charge 100)
; => 292
