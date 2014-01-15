(defproject asciidoclj "0.1.1"
  :description "A Clojure API to parse and render Asciidoc"
  :url "http://github.com/cjohansen/asciidoclj"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [org.asciidoctor/asciidoctorj "1.5.0-SNAPSHOT"]]
  :profiles {:dev {:dependencies [[midje "1.6.0"]]
                   :plugins [[lein-midje "3.1.3"]]}})
