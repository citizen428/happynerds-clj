(ns happynerds-clj.test.util
  (:use clojure.test
        ring.mock.request
        happynerds-clj.util))

(deftest test-util
  (testing "page-title for ios"
    (is (= "iOS" (page-title "ios"))))

  (testing "page-title for raspberry"
    (is (= "Raspberry Pi" (page-title "raspberry"))))

  (testing "page-title for other tag"
    (is (= "Mac" (page-title "mac")))))
