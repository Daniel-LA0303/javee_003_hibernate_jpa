# API Criteria

## Description

The Criteria API provides a programmatic, type-safe way to create queries in JPA. Unlike JPQL (which uses string-based queries), the Criteria API builds queries using Java objects and methods, enabling compile-time checking and IDE support.

It includes the following key topics:

- CriteriaBuilder: Factory class for creating criteria queries, predicates, and expressions. Provides type-safe query construction methods.
- CriteriaQuery: Defines the structure of a criteria query (SELECT, WHERE, ORDER BY). Acts as the query root for building type-safe queries.

- Methods
  - `criteriaBuilder.createQuery()` - Creates CriteriaQuery instance
  - `criteriaBuilder.equal()` - Creates equality predicate
  - `criteriaBuilder.gt()/lt()` - Greater-than/Less-than comparisons
  - `criteriaBuilder.between()` - Range condition
  - `criteriaBuilder.like()` - String pattern matching
  - `criteriaBuilder.isNull()/isNotNull()` - Null checks
  - `criteriaBuilder.and()/or()` - Logical operations
  - `criteriaBuilder.asc()/desc()` - Sorting
  - `criteriaBuilder.count()/sum()/avg()` - Aggregate functions

## Quick Start

### Prerequisites

- Java 17+ (recommended for Spring Boot 3+)
- Maven (optional, since `mvnw` is included)
- IDE: IntelliJ, Eclipse, or VS Code

### Run the Application

1. Execute the application:
- mvn clean package

- In Linux/macOS
  - cp target/mi-app.war /ruta/al/tomcat/webapps/

- In Windows
  - copy target\mi-app.war C:\ruta\al\tomcat\webapps\

- with plugin tomcat
  - mvn tomcat7:deploy  
  - mvn tomcat7:redeploy

- Init tomcat
  - In Linux/macOS
    - /ruta/al/tomcat/bin/startup.sh

  - In Windows
    - C:\ruta\al\tomcat\bin\startup.bat


2. Access the application:
   - Default URL: `http://localhost:8080/`

3. Dependencies used:
   - mysql-connector-java
   - hibernate-core-jakarta
