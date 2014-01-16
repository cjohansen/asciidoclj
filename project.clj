(defproject asciidoclj "0.2.0-SNAPSHOT"
  :description "A Clojure API to parse and render Asciidoc"
  :url "http://github.com/cjohansen/asciidoclj"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [org.asciidoctor/asciidoctorj "1.5.0-SNAPSHOT"]
                 [org.slf4j/slf4j-simple "1.7.5"]]
  :profiles {:dev {:dependencies [[midje "1.6.0"]]
                   :plugins [[lein-midje "3.1.3"]]}})
