# Java, Spring Boot, Aerospike database, and JMH.

Project tutorial with an easy step-by-step instructions can be found here:

https://medium.com/aerospike-developer-blog/simple-web-application-using-java-spring-boot-aerospike-database-and-docker-ad13795e0089


Project is backed by spring-data-aerospike:

https://github.com/aerospike-community/spring-data-aerospike

In order to run the test:
JMHSpringDataDemo should have the following as parameters which are configurable:
forkNum=1;warmIterNum=1;warmTime=1;measurementIterations=1;numThreads=1;numUsers=10
