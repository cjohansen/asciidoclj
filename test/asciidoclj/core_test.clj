(ns asciidoclj.core-test
  (:use midje.sweet)
  (:require [asciidoclj.core :as asciidoc]))

(fact (asciidoc/render "*This* is it.") => "<strong>This</strong> is it")
