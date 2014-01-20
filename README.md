# asciidoclj

A Clojure interface to the [Asciidoctor](http://asciidoctor.org/) library. The
library wraps the
[Java integration](https://github.com/asciidoctor/asciidoctorj) but does not
intend to fully wrap all its APIs. The ambition is simply to provide a good
Ascii doc library for Clojure.

## Install

Add `[asciidoclj "0.2.0"]` to `:dependencies` in your `project.clj`.

## Usage

The only thing to consider for now is the parse function:

```clj
(asciidoclj.core/parse "= Sample Document")
```

which will return a map of information about the document.

## License

Copyright © 2014 Christian Johansen

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
