# TwitterBackend
### A relational database for a project that aims to be a clone of twitter.

## Database ER model
![](public/model.png)


## Before running 
Make a resources folder in src/main

Make an application.properties file in src/main/resources
```
spring.datasource.url=jdbc:postgresql://localhost:5432/twitterdb
spring.datasource.username=postgres
spring.datasource.password=passwordHere
server.port=3001
#spring.sql.init.mode=always

```

## To Run
### Have atleast Java 16 installed
`.\mvnw spring-boot:run`