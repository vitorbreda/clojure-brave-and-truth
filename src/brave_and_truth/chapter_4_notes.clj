(ns brave-and-truth.chapter_4_notes)

;; Chapter 4 notes

; Maps

; Multiple collections
; The elements of the first collection will be passed as the first argument of the mapping
; function (str), the elements of the second collection will be passed as the second argument
(map str ["a" "b" "c"] ["A" "B" "C"])
; => ("aA" "bB" "cC")

; maps with a collection of functions
(def sum #(reduce + %))
(def avg #(/ (sum %) (count %)))
(defn stats
  [numbers]
  (map #(% numbers) [sum count avg]))

(stats [3 4 10])
; => (17 3 17/3)

; map to retrieve the value associated with a keyword from a collection
(def identities
  [{:alias "Batman" :real "Bruce Wayne"}
   {:alias "Spider-Man" :real "Peter Parker"}
   {:alias "Santa" :real "Your mom"}
   {:alias "Easter Bunny" :real "Your dad"}])

(map :real identities)
; => ("Bruce Wayne" "Peter Parker" "Your mom" "Your dad")

(apply [0 1 2])
