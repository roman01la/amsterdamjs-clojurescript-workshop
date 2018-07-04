## Setup

_Please do this before workshop. Ping me on Slack if you have any problems with setup._

1.  If you don't have it yet, download and install [JDK 8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html) on your machine
2.  [Install Clojure CLI](https://clojure.org/guides/getting_started#_clojure_installer_and_cli_tools) or [Leiningen](https://leiningen.org/) if you are on Windows
3.  Clone [workshop repository](https://github.com/roman01la/amsterdamjs-clojurescript-workshop) that we are going to work with
4.  `cd` into repo's directory and execute the following commands

* `clojure -m figwheel.main -b dev -r` or `lein do server` to start dev server
* `clj -m nightlight.core --url "http://localhost:3000"` or `lein do ide` to start IDE server, which we will work in

5.  Verify build: once initial compilation is done you should see a running app at [localhost:3000](http://localhost:3000)
6.  Verify IDE: IDE starts at [localhost:4000](http://localhost:4000), you should see editor UI there

## Topics

* Syntax, variables, functions and macros
* Threading macro (pipeline operator)
* Primitive data types
* Control flow
* Data structures
* Collections transformation
* State
* Interop with JavaScript
* Namespaces
* Building UIs

## Tips

* Use [ClojureDocs](https://clojuredocs.org/) during the workshop to lookup functions from standard library
* Have [ClojureScript Cheatsheet](http://cljs.info/cheatsheet/) open as a quick guide

## Useful links

* [ClojureScript Synonyms](https://kanaka.github.io/clojurescript/web/synonym.html) — translation of common things from JavaScript into ClojureScript
* [ClojureScript Cheatsheet](http://cljs.info/cheatsheet/) — a quick reference to a standard library of the language
* [ClojureDocs](https://clojuredocs.org/) — documentation website
* [Clojure Style Guide](https://github.com/bbatsov/clojure-style-guide) — a style guide to writing idiomatic Clojure code
* [clojurescript.org](https://clojurescript.org/) — ClojureScript documentaion website
* [Community Resources](http://clojure.org/community/resources)
* [ClojureScript API Docs](http://cljs.github.io/api/)
* [Quickref for Clojure Core](https://clojuredocs.org/quickref)
* [ClojureScript Tutorial](https://www.niwi.nz/cljs-workshop/)
* [ClojureScript Koans](http://clojurescriptkoans.com/)
* [Transforming Data with ClojureScript](http://langintro.com/cljsbook/)
