# RPNCalculator
CLI application in Spring Boot

# How to run
mvn spring-boot:run

# How to run unit tests
mvn test

# Description
I built this app for a technical test so try to use as many features as I can. The app is built with Spring boot and benefits Sprint Context dependency injection. Implement InsufficientParametersException to make the app user interface friendly.

To Implement UNDO operation, I set up hierarchy stacks and record all external commands (user input) and all internal commands (stack opertions: push & pop). Since it's a time limited test, I take functionality implementation as a top priority. It could have space to improve the performance. Because the solution could have potential memery issue if a user input a extremely long commands.

I have written unit tests for all classes I wrote. I didn't apply TDD in this test but the unit test coverage is still very high: 100% classes and 91% lines covered.
 

