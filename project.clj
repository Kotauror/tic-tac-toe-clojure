(defproject tic-tac-toe "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url  "http://www.eclipse.org/legal/epl-v10.html"}
  :main tic_tac_toe.core
  :dependencies [[org.clojure/clojure "1.7.0-RC2"]
                [org.clojure/math.numeric-tower "0.0.4"]]

  :profiles {:dev {:dependencies [[org.clojure/clojurescript "0.0-3308"]
                                  [speclj "3.3.1"]]}}
  :plugins [[speclj "3.3.1"]
            [lein-cljsbuild "1.0.5"]]

  :cljsbuild {:builds        {:dev  {:source-paths   ["src/cljs" "spec/cljs"]
                                     :compiler       {:output-to     "js/tic-tac-toe_dev.js"
                                                      :optimizations :whitespace
                                                      :pretty-print  true}
                                     :notify-command ["phantomjs"  "bin/speclj" "js/tic-tac-toe_dev.js"]}

                              :prod {:source-paths ["src/cljs"]
                                     :compiler     {:output-to     "js/tic-tac-toe.js"
                                                    :optimizations :simple}}}
              :test-commands {"test" ["phantomjs" "bin/speclj" "js/tic-tac-toe_dev.js"]}}

  :source-paths ["src/clj" "src/cljs"]
  :test-paths ["spec/clj"]

  :aliases {"cljs" ["do" "clean," "cljsbuild" "once" "dev"]})
