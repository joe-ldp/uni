(ns morse-code.core)
(require '[clojure.string :as str])

(def table {
    "A" ".—"
    "B" "—..."
    "C" "—.—."
    "D" "—.."
    "E" "."
    "F" "..—."
    "G" "——."
    "H" "...."
    "I" ".."
    "J" ".———"
    "K" "—.—"
    "L" ".—.."
    "M" "——"
    "N" "—."
    "O" "———"
    "P" ".——."
    "Q" "——.—"
    "R" ".—."
    "S" "..."
    "T" "—"
    "U" "..—"
    "V" "...—"
    "W" ".——"
    "X" "—..—"
    "Y" "—.——"
    "Z" "——.."
    "1" ".————"
    "2" "..———"
    "3" "...——"
    "4" "....—"
    "5" "....."
    "6" "—...."
    "7" "——..."
    "8" "———.."
    "9" "————."
    "0" "—————"
    " " " "
    "       " " "
})

(defn translate-char
    ([char] (translate-char char table))
    ([char table]
    (let [[k v] (first table)]
        (if (= (first k) char)
            (str v "   ")
            (if (= v char)
                k
                (if (empty? table)
                    "?"
                    (recur char (rest table))))))))

(defn translate-phrase
    ([from] (translate-phrase from ""))
    ([from to]
        (let [from from to to]
            (if (empty? from)
                (str/trim to)
                (recur (rest from) (str to (translate-char (first from))))))))

(defn text->morse
    ([text] (text->morse text ""))
    ([text morse]
    (let [text text morse morse]
        (if (empty? text)
            (str/trimr morse)
            (recur (rest text) (str morse (translate-char (first text))))))))

(defn morse->text
    ([morse] (morse->text (re-seq #"\S+|\s{7}" morse) ""))
    ([morse-chars text]
    (let [morse morse-chars text text]
        (if (empty? morse)
            text
            (recur (rest morse) (str text (translate-char (first morse))))))))

(defn -main
  []
  ;(prn (translate-char "A"))
  ;(prn (translate-char ".—"))
  (prn (text->morse "TESTING TESTING 1 2 3"))
  (prn (morse->text "—   .   ...   —   ..   —.   ——.       —   .   ...   —   ..   —.   ——.       .————       ..———       ...——"))
)