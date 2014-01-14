(ns asciidoclj.core-test
  (:use midje.sweet)
  (:require [asciidoclj.core :as asciidoc]))


(fact (asciidoc/render "*This* is it.") => "<div class=\"paragraph\">\n<p><strong>This</strong> is it.</p>\n</div>")

(def sample-doc (asciidoc/parse "= Sample Document
Doc Writer <doc.writer@asciidoc.org>; John Smith <john.smith@asciidoc.org>
v1.0, 2013-05-20: First draft

== Section one
This is content of section one

== Section two
And content of section two"))

(facts "parse returns StructuredDocument map with header"
       (fact "with document and page titles"
             (:document-title (:header sample-doc)) => "Sample Document"
             (:page-title (:header sample-doc)) => nil)

       (fact "with main author"
             (:author (:header sample-doc)) => {:full-name "Doc Writer"
                                                :last-name "Writer"
                                                :first-name "Doc"
                                                :middle-name nil
                                                :email "doc.writer@asciidoc.org"
                                                :initials "DW"})

       (fact "with all authors"
             (count (:authors (:header sample-doc))) => 2)

       (fact "with main author as first author"
             (:full-name (first (:authors (:header sample-doc)))) => "Doc Writer")

       (fact "with author as second author"
             (:full-name (nth (:authors (:header sample-doc)) 1)) => "John Smith"))

(facts "parse returns StructuredDocument map with revision info"
       (fact (:revision-info (:header sample-doc)) => {:date "2013-05-20"
                                                       :number "1.0"
                                                       :remark "First draft"}))

(facts "parse returns StructuredDocument map with parts"
       (fact "includes all parts"
             (count (:parts sample-doc)) => 2)

       (fact "parts have details"
             (first (:parts sample-doc)) => {:id "_section_one"
                                             :level 1
                                             :context "section"
                                             :style nil
                                             :role nil
                                             :title "Section one"
                                             :attributes {}
                                             :content "<div class=\"paragraph\">\n<p>This is content of section one</p>\n</div>"
                                             :parts []}))

(facts "parse document without author")
