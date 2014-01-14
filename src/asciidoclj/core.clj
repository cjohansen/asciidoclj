(ns asciidoclj.core)

(defn- map-author [author]
  {:full-name (.getFullName author)
   :last-name (.getLastName author)
   :first-name (.getFirstName author)
   :middle-name (.getMiddleName author)
   :email (.getEmail author)
   :initials (.getInitials author)})

(defn- map-document-header [header]
  {:document-title (.getDocumentTitle header)
   :page-title (.getPageTitle header)
   :author (map-author (.getAuthor header))
   :authors (map map-author (.getAuthors header))
   :revision-info (.getRevisionInfo header)})

(defn- map-structured-document [document]
  {:header (map-document-header (.getHeader document))
   :parts (.getParts document)})

(defn render [str]
  (let [doctor (org.asciidoctor.Asciidoctor$Factory/create)]
    (.render doctor str (java.util.HashMap.))))

(defn parse [str]
  (let [doctor (org.asciidoctor.Asciidoctor$Factory/create)]
    (map-structured-document (.readDocumentStructure doctor str (java.util.HashMap.)))))
