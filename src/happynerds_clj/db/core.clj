(ns happynerds-clj.db.core
    (:require [monger.core :as mg]
              [monger.collection :as mc]))

;; Tries to get the Mongo URI from the environment variable
;; MONGOLAB_URI, otherwise default it to localhost
(defonce db (let [uri (get (System/getenv) "MONGOLAB_URI" "mongodb://127.0.0.1/happynerds")
                  {:keys [conn db]} (mg/connect-via-uri uri)]
              db))

(defn find-for-tag [tag]
    (mc/find-maps db "sites" { :tags tag }))
