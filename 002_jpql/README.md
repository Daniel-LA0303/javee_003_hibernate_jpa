# JPQL

## Description

JPQL is the standard query language defined by JPA for interacting with entities in an object-oriented way. Unlike SQL, which operates on database tables, JPQL queries are written against entity classes and their attributes. It supports SELECT, UPDATE, and DELETE operations but does not handle INSERT (which is done via EntityManager.persist()). JPQL is database-agnostic, meaning the same query works across different database systems.

HQL is Hibernate’s extended version of JPQL with additional features. While JPQL is standardized, HQL includes Hibernate-specific extensions.

It includes the following key topics:

  - JPQL (Java Persistence Query Language): Standard object-oriented query language for JPA that works with entities instead of tables
  - HQL (Hibernate Query Language): Hibernate's extended version of JPQL with additional database features
  - EntityManagerFactory: Creates EntityManager instances (one per application) - heavy initialization, thread-safe
  - EntityManager: Main JPA interface for CRUD operations and transactions - short-lived, not thread-safe
  - JPA Utility Classes: Helper classes that simplify EntityManager handling and resource cleanup

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
   - commons-dbcp2
   - hibernate-core-jakarta
