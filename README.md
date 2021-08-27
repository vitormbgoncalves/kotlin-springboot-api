# 🍃 Spring Boot Travel Agency  Sample Application

## 💻 [Live demo](https://kotlin-springboot-api.herokuapp.com/swagger-ui.html#/promocao-controller)

An example from the `kotlin-springboot-api` is deployed on Heroku, access API documentation on the Swagger UI. https://kotlin-springboot-api.herokuapp.com/swagger-ui.html#/promocao-controller

## 🚀 About this project

This project was developed based on Udemy's course [*__Desenvolva uma aplicação com Spring Boot e linguagem Kotlin.__*](https://www.udemy.com/course/desenvolva-uma-aplicacao-com-spring-boot-e-linguagem-kotlin/), taught by Leonardo Silva da Gloria.
The objective of this project was to study the concepts of the Spring Boot framework together with the Kotlin programming language for the development of RESTful Web Services.
The code consists of Rest Web Services built with Kotlin, Spring Boot and MySQL. This service provides functionalities for the registration system of a travel agency.

## 🧰 Tools

- [**JDK 11**](https://www.oracle.com/br/java/technologies/javase-jdk11-downloads.html) - Java language support development kit;
- [**Maven**](https://maven.apache.org/) - for project management and build tool;
- [**Spring Boot**](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/) - for creating web application;
- [**Spring Data JPA**](https://spring.io/projects/spring-data-jpa) - to access database;
- [**Swagger**](https://springdoc.org/) - for OpenAPI 2 documentation generation;
- [**MySQL**](https://www.mysql.com/) - for database;
- [**Insomnia**](https://insomnia.rest/) - for API development testing;
- [**Heroku**](https://heroku.co) - for deployment and production testing;

## 📀 Running

1. Clone the git project through the terminal:

```shell
git clone https://github.com/vitormbgoncalves/kotlin-springboot-api.git
cd kotlin-springboot-api
```

2. Then build the application with the command below:

```shell
mvn install
```

3. Now you are ready to lunch it:

```shell
mvn spring-boot:run
```

## 🗒 Quick note

To run this project it is necessary to have an instance of MySQL running locally or in Docker container, and configure uri in: `src/main/resources/application.yml`

This project was developed and runs on Linux.
