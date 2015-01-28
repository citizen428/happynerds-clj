(ns happynerds-clj.util
  (:require [clojure.string :as s]))

(defonce mappings {:ios "iOS" :raspberry "Raspberry Pi"})

(defn page-title [tag]
  ((keyword tag) mappings (s/capitalize tag)))
