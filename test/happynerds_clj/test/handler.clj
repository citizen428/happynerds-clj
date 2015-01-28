(ns happynerds-clj.test.handler
  (:use clojure.test
        ring.mock.request
        happynerds-clj.handler))

(deftest test-app
  (testing "main route"
    (let [response (app (request :get "/"))]
      (is (= 200 (:status response)))))

  (testing "not-found route"
    (let [response (app (request :get "/invalid"))]
      (is (= 302 (:status response))))))
