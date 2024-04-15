# SFG Brewery Gateway Service

Source code in this repository is to support my online courses.

Learn more about my courses below!
* [Spring Boot Microservices with Spring Cloud](https://www.udemy.com/spring-boot-microservices-with-spring-cloud-beginner-to-guru/?couponCode=GIT_HUB2)

## Commands used to push to DockerHub and manage the version:
* mvn release:prepare
* mvn release:perform
* git checkout tags/<TAG>
* mvn clean package -DskipTests docker:build docker:push