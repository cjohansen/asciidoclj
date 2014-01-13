(defproject asciidoclj "0.1.0-SNAPSHOT"
  :description "A Clojure API to parse and render Asciidoc"
  :url "http://github.com/cjohansen/asciidoclj"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [org.asciidoctor/asciidoctor-java-integration "0.1.4"]]
  :profiles {:dev {:dependencies [[midje "1.5.1"]]
                   :plugins [[lein-midje "3.0.0"]]}})
