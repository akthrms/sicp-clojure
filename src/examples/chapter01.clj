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
