# JMH integration with Spring and Aerospike

Please refer to the full documentation:

[Spring JMH Aerospike Integration](https://aerospike.atlassian.net/wiki/spaces/~62d1c4dcafe495359d9e79a9/pages/2762997864/Spring+JMH+Aerospike+Integration)


The project is based on the following Spring Application, in order to fully understand the Spring Aerospike 
integration please refer to this link:

[Springboot Aerospike and Docker](https://medium.com/aerospike-developer-blog/simple-web-application-using-java-spring-boot-aerospike-database-and-docker-ad13795e0089
)


Project is backed by spring-data-aerospike:

https://github.com/aerospike-community/spring-data-aerospike

### In order to run the JMHSpringDataDemo through IDE:
JMHSpringDataDemo should have the following as parameters which are configurable:

forkNum=1;warmIterNum=1;warmTime=1;measurementIterations=1;numThreads=1;numUsers=10
