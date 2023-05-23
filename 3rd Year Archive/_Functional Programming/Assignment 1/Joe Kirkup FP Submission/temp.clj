(ns temperature.core)

(require '[clojure.string :as str])

;(def raw-data (slurp "cetdl1772on.txt"))
(def raw-data (slurp "trimmed.txt"))
(def rows (str/split raw-data #"\n"))
(def rows (map #(str/split (str/trim %) #"\s+") rows))

;; (defn parse-rows
;;     ([rows] (parse-rows (drop 31 rows) (take 31 rows) (first (first rows)) {}))
;;     ([rows year-data year-num data]
;;     (let [rows rows year-data year-data year-num year-num data data]
;;         (if (empty? year-data)
;;             data
;;             (recur
;;                 (drop 31 rows)
;;                 (take 31 rows)
;;                 (first (first rows))
;;                 (assoc data (keyword year-num) (drop 2 (apply mapv vector year-data))))
;;             ))))

; array of str to int - https://stackoverflow.com/a/4714991
(defn vec-str-to-int [vec]
    (map #(Integer/parseInt %) vec))

; vector transposition - https://stackoverflow.com/a/10347404
(defn transpose [vec]
    (apply mapv vector vec))

(defn remove-999s [data]
    (map #(remove (fn [val] (= val -999)) %) data))

(defn parse-rows [rows]
    (map #(drop 2 (transpose (map vec-str-to-int %))) (partition 31 rows)))

(defn build-year-map
    ([rows] (build-year-map rows {} 1772))
    ([rows data year]
    (let [rows rows data data year year]
        (if (empty? rows)
            data
            (recur (rest rows) (assoc data year (remove-999s (first rows))) (inc year))))))

; finds the warmest day for a given month across all of the years in the data
; month num should be 1-indexed
(defn warmest-day-for-month
    [data month-num warmest]
    (let [data data month-num month-num warmest -999]
        (if (empty? data)
            warmest
            (recur
                (rest data)
                month-num
                (if (> (apply max (second (first data)) warmest))
                    (apply max (second (first data))
                    warmest)))
            )))

(defn month-temperature
    [month-data]
    (reduce + month-data))

(defn year-temperature
    [year-data]
    (reduce + (map month-temperature year-data)))

(defn warmest-year
    ([data] (warmest-year (rest data) (first (first data)) (second (first data)) -999))
    ([data year year-data warmest]
    (let [data data year year year-data year-data warmest warmest]
        (if (empty? data)
            warmest
            (recur
                (rest data)
                [year year-data] (first data)
                (if (> (year-temperature year-data) warmest)
                    (year-temperature year-data)
                    warmest)
            )))))

(defn -main
    []
    (def parsed-rows (parse-rows rows))
    (def data (build-year-map parsed-rows))
    (prn (warmest-day-for-month data 1 -999))
    ;(prn data)
    ;(prn (month-temperature (first (get data 1772))))
    ;(prn (year-temperature (get data 1772)))
    ;(prn (warmest-year data))
    ;(def year-temps (reduce #(year-temperature (second %)) data))
    ;(prn year-temps)
)