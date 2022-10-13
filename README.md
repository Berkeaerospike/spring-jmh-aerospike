# JMH integration with Spring and Aerospike

Please refer to a full documentation:

https://aerospike.atlassian.net/wiki/spaces/~62d1c4dcafe495359d9e79a9/pages/2762997864/Spring+JMH+Aerospike+Integration

The project based on the following Spring Application, in order to fully understand the Spring Aerospike 
integration please refer to this link:

Project tutorial with an easy step-by-step instructions can be found here:

https://medium.com/aerospike-developer-blog/simple-web-application-using-java-spring-boot-aerospike-database-and-docker-ad13795e0089


Project is backed by spring-data-aerospike:

https://github.com/aerospike-community/spring-data-aerospike

# In order to run the JMHSpringDataDemo through IDE:
JMHSpringDataDemo should have the following as parameters which are configurable,
added. removed according to test needs:

forkNum=1;warmIterNum=1;warmTime=1;measurementIterations=1;numThreads=1;numUsers=10
