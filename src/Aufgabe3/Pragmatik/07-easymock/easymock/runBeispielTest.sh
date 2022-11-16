# !/bin/sh
# runBeispielTest.sh

javac -cp easymock-4.3.jar BeispielTest.java
java -cp 'easymock-4.3.jar;.' BeispielTest x x
java -cp 'easymock-4.3.jar;.' BeispielTest x
java -cp 'easymock-4.3.jar;.' BeispielTest x x x

