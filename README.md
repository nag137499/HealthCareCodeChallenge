# Coding Challenge
Using Spring Boot or Go, and your database of choice (PostgreSQL, MySQL, MongoDB -- any you'd like), develop a microservice for tracking the status of enrollees in a health care program.

Enrollees must have an id, name, and activation status (true or false), and a birth date
Enrollees may have a phone number (although they do not have to supply this)
Enrollees may have zero or more dependents
Each of an enrollee's dependents must have an id, name, and birth date
The application we will be building will need to be able to do these things:

Add a new enrollee
Modify an existing enrollee
Remove an enrollee entirely
Add dependents to an enrollee
Remove dependents from an enrollee
Modify existing dependents

#
This is a Springboot microservice for tracking the status of enrollees in a health care program using H2 Database

## Requirements

For building and running the application you need:

- [JDK 1.8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
- [Maven 3](https://maven.apache.org)
- Docker

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


## Containerize the Codingchallenge Application

TO create the docker image, we need jar file for application, we can generate it by using below command
mvn clean install

The above command creates a jar file in the target directory of the project.

Build the image using this Dockerfile. To do so, move to the root directory of the application and run this command:
docker build -t image-name .

We built the image using docker build. We gave it a name with the -t flag and specified the current directory where the Dockerfile is. The image is built and stored in our local docker registry.

check our image using below command
docker images

We can run our image using below command
docker run -p 8090:8097 image-name

Once the application is started, we should be able to access it at http://localhost:8090
