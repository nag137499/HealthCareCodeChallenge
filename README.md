# Coding Challenge
This is a Springboot microservice for tracking the status of enrollees in a health care program using H2 Database

## Requirements

For building and running the application you need:

- [JDK 1.8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
- [Maven 3](https://maven.apache.org)

## Build

use maven to build the application
use mvn clean install command to build the application at the root directory

## Running the application locally

There are several ways to run a Spring Boot application on your local machine. One way is to execute the `main` method in the `com.healthcare.codingchallenge.CodingchallengeApplication` class from your IDE.

Alternatively you can use the [Spring Boot Maven plugin](https://docs.spring.io/spring-boot/docs/current/reference/html/build-tool-plugins-maven-plugin.html) like so:

```shell
mvn spring-boot:run
```

## To run integration tests

```
mvn spring-boot:run
mvn verify
```

Once the application is up and running, We can access the APIs through http://localhost:8097/swagger-ui.html and access them and also we can access through postman and curl
