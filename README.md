Combines Gatling bundle with an sbt project

Fast and dirty way to get going with http://gatling.io/

Bundled: version 2.0.3

To develop new tests:  Add test in user-files/simulation. Use any package structure you want to.
To run the test in sbt:
$ sbt "gatling:test-only <Test class name>"


To run test from gatling bundled:

$ ./bin/gatling.sh
