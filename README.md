#  Clean-Architecture-and-DDD 

## What is Clean Architecture ?
> According to Robert C Martin - business rules are testable by design and independent of frameworks, databases, UI technologies, and other external applications or interfaces.

## About the Program  

This program(Spring Boot) demonstrates how to develop applications based on Clean Architecture principles and structure the codebase based on Hexagonal architecture by Alistair Cockburn. Also, the application showcases some of the Domain Driven concepts, such as  Domain entities, value objects, etc. Another important aspect of this application is it follows vertical slicing architecture.

Application source code is structured into three primary packages, namely.
  * application - contains use cases, interfaces for infra layer 
  * domain - contains domain entities, domain logic, business rules,value objects, etc
  * infra - contains repository, data access logic, and ports(interface) implementations.

Within these packages, we create an additional grouping for specific use cases; essentially, it screams about the intent. So, we are following screaming and vertical slicing architecture.

Also, in the test folders, it demonstrates how to unit test the domain layer, application layer etc. The program uses Mockitio and Spring-started-test for unit and integration tests. 
