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
