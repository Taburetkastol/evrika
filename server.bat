@ECHO OFF
cd pwd
start java -jar target/evrika-0.0.1-SNAPSHOT-jar-with-dependencies.jar
start http://localhost:8080/greeting