(ns asciidoclj.core)

(defn render [str]
  (let [doctor (org.asciidoctor.Asciidoctor$Factory/create)]
    (.render doctor str {})))
