(ns brave-and-truth.chapter_3_notes)

;; Chapter 3 notes

; Ifs in clojure support only one line. In order to write a multiple line use do
(if true
  (do (println "Success!")
      "By Zeus's hammer!")
  (do (println "Failure!")
      "By Aquaman's trident!"))

; When is a combination of if and do. When does not have else if false retuns nil
(when true
  (println "Success!")
  "abra cadabra")

; or returns either the first truthy value or the last value.
(or false nil :large_I_mean_venti :why_cant_I_just_say_large)
; :large_I_mean_venti

; and returns the first falsey value or if no values are falsey, the last truthy
(and :large_I_mean_venti :why_cant_I_just_say_large)
:why_cant_I_just_say_large

; Use str to concatenates string in clojure
(str "It was the panda " "in the library " "with a dust buster")

; Keywords can be used as functions that look up the corresponding value in a data structure
:c
(get {:a 1 :b 2 :c 3} :c)                                   ; Wrong
(:c {:a 1 :b 2 :c 3})                                       ; Better

; get doesn't work on lists
(get '(1 2 3 4) 0)

;use nth to get the value from a list
(nth '(1 2 3 4) 0)

; Sets are collections of unique values. use #{ or set function
(println #{:a :b 1 "a"})

; Arity overloading
; Arity overloading is one way to provide default values for arguments
(defn x-chop
  ([name chop-type]
   (str "I " chop-type " chop " name "! Take that!"))
  ([name]
   (x-chop name "karate")))

; Rest operator (variable-arity)
(defn codger-communication
  [whippersnapper]
  (str "Get off my lawn, " whippersnapper "!!!"))

(defn codger
  [& whippersnappers]
  (map codger-communication whippersnappers))

(codger "Billy" "Anne-Marie" "The Incredible Bulk")

; Destructuring maps
(defn announce-treasure-location
  ;[{lat :lat lng :lng}]
  [{:keys [lat lng]}]
  (println (str "Treasure lat: " lat))
  (println (str "Treasure lng: " lng)))

(announce-treasure-location {:lat 28.22 :lng 81.33})

; defn is a shortcut to def + fn
(def my-special-multiplier (fn [x] (* x 3)))

; lamdba the % is the parameter
(def my-special-multiplier #(* % 3))

; A function can return a another function
(defn inc-maker [inc-by]
  #(+ % inc-by))

(def inc-3 (inc-maker 3))
(inc-3 7)
((inc-maker 50) 10)

; Process each element in a sequence and build a result
; Reduce send two arguments the accumulator and the current element
(reduce + 15 [1 2 3 4])

; You can also use reduce to return an even larger collection
; (defn better-symmetrize-body-parts
;  "Expects a seq of maps that have a :name and :size"
;  [asym-body-parts]
;  (reduce (fn [final-body-parts part]
;            (into final-body-parts (set [part (matching-part part)])))
;          []
;          asym-body-parts))
