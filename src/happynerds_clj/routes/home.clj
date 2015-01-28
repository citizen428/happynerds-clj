(ns happynerds-clj.routes.home
  (:require [compojure.core :refer :all]
            [ring.util.response :refer [redirect]]
            [happynerds-clj.layout :as layout]
            [happynerds-clj.db.core :as db]
            [happynerds-clj.util :as util]))

(defn home-page []
  (layout/render "index.html"))

(defn tag-page [tag]
  (layout/render "tag.html"
                 {:sites (sort-by :desc (db/find-for-tag tag))
                  :title (util/page-title tag)}))

(defroutes home-routes
  (GET "/" [] (home-page))
  (GET "/view/:tag" [tag] (tag-page tag))
  (ANY "*" [] (redirect "/")))
