# JPA / Hibernate

## Description

JPA (Java Persistence API) is a Java standard for object-relational mapping (ORM) that defines how to interact with databases using objects. Hibernate is the most popular JPA implementation, offering additional features and optimizations.


It includes the following key topics:

- persistence.xml:
    - Configuration file located in META-INF/.
    - Defines the persistence unit (<persistence-unit>), JPA provider (e.g., Hibernate), data source, and properties like SQL dialect.
    - Can be omitted in Hibernate if configured programmatically or via Spring.

- Core Etity Annotations:
    - @Entity: Marks a class as a persistent entity.
    - @Table: Specifies the database table name.
    - @Id: Indicates the primary key.
    - @GeneratedValue: Defines ID generation strategy (e.g., auto-increment).
    - @Column: Customizes attribute-to-column mapping.
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
