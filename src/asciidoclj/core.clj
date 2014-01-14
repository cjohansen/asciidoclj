(ns asciidoclj.core)

(defn- map-author [author]
  {:full-name (.getFullName author)
   :last-name (.getLastName author)
   :first-name (.getFirstName author)
   :middle-name (.getMiddleName author)
   :email (.getEmail author)
   :initials (.getInitials author)})

(defn- map-revision-info [revision-info]
  {:date (.getDate revision-info)
   :number (.getNumber revision-info)
   :remark (.getRemark revision-info)})

(defn- map-document-header [header]
  {:document-title (.getDocumentTitle header)
   :page-title (.getPageTitle header)
   :author (map-author (.getAuthor header))
   :authors (map map-author (.getAuthors header))
   :revision-info (map-revision-info (.getRevisionInfo header))})

(defn- map-content-part [part]
  {:id (.getId part)
   :level (.getLevel part)
   :context (.getContext part)
   :style (.getStyle part)
   :role (.getRole part)
   :title (.getTitle part)
   :attributes (.getAttributes part)
   :content (.getContent part)
   :parts (map map-content-part (.getParts part))})

(defn- map-structured-document [document]
  {:header (map-document-header (.getHeader document))
   :parts (map map-content-part (.getParts document))})

(defn render [str]
  (let [doctor (org.asciidoctor.Asciidoctor$Factory/create)]
    (.render doctor str (java.util.HashMap.))))

(defn parse [str]
  (let [doctor (org.asciidoctor.Asciidoctor$Factory/create)]
    (map-structured-document (.readDocumentStructure doctor str (java.util.HashMap.)))))
