(ns brave-and-truth.chapter_3_exercices)

;; Chapter 3 Exercises

; 1 - Use the str, vector, list, hash-map, and hash-set functions.
(str "A" "B" "C")

(vector 1 2 3)
; or
[1 2 3]

(list 1 2 3)
; or
'(1 2 3)

(hash-map :a 1 :b 2 :c 3)
; or
{:a 1 :b 2 :c 3}

(hash-set 1 2 2)
; or
#{1 2}

; use set function to create a set from vectors and lists
(set [3 3 3 4 4])
; => #{3 4}

; 2 - Write a function that takes a number and adds 100 to it.
(defn add-100 [number]
  (+ number 100))

(add-100 100)
(#(+ % 100) 100)

; 3 - Write a function, dec-maker, that works exactly like the function inc-maker except with subtraction
(defn dec-maker [dec-by]
  #(- % dec-by))

(def dec-by-5 (dec-maker 5))

(dec-by-5 10)

; 4 - Write a function, mapset, that works like map except the return value is a set
(defn mapset [f coll]
  (set (map f coll)))

(mapset inc [1 2 1 2])