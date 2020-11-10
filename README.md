# Spring-Boot-TDD

  
### What is Test Driven Development ( TDD ) ?

<p>Test driven development is an iterative development process.</p>
<p>
In TDD, developers write a test before they write just enough production code to fulfill that test and the subsequent refactoring. 
Developers use the specifications and first write test describing how the code should behave. It is a rapid cycle of testing, coding, and refactoring.
</p>

### Advantages of Test Driven Development ( TDD ) 

- You have a better understanding of a feature you implement
- 100% testable code
- You have robust indicators of feature completeness
- Low maintenance cost
- Code is covered with tests and has less chance to be corrupted by fixes or new features


### Tech Stack
 - Java 11
 - Spring Boot
 - Maven
 - JUnit
 - Mockito
 - Hamcrest
 
### Requirements

For building and running the application you need:
- [JDK 11](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html) or newer . 
- [Maven](https://maven.apache.org)
- [Lombok](https://projectlombok.org/)


### Build & Run 
```
  mvn clean install && mvn --projects backend spring-boot:run
```
  
### Port
```
  http://localhost:8088
```
