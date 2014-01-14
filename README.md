# asciidoclj

A Clojure interface to the [Asciidoctor](http://asciidoctor.org/) library. The
library wraps the
[Java integration](https://github.com/asciidoctor/asciidoctorj) but does not
intend to fully wrap all its APIs. The ambition is simply to provide a good
Ascii doc library for Clojure.

## Usage

Currently, asciidoclj depends on a not yet released version of asciidoctorj. To
use, first get asciidoctorj from source and install into your local repository:

```sh
git clone https://github.com/asciidoctor/asciidoctorj.git
cd asciidoctorj
mvn clean install
```

Then add asciidoclj to your project.clj. The only thing to consider for now is
the parse function:

```clj
(asciidoclj.core/parse "= Sample Document")
```

## License

Copyright © 2014 Christian Johansen

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
