# Asociations

## Description

Entity associations define how different JPA entities relate to each other and how these relationships are persisted in the database. They mirror foreign key relationships in relational databases while providing object-oriented navigation capabilities. Associations can be unidirectional or bidirectional, and their cardinality is expressed through specific annotations that determine if the relationship is one-to-one, one-to-many, many-to-one, or many-to-many.

It includes the following key topics:

- @OneToOne: 1:1 relationship between entities (e.g., User-Profile)
- @OneToMany: 1:N relationship (e.g., Department-Employees)
- @ManyToOne: "Many" side of 1:N relationship (e.g., Employee-Department)
- @ManyToMany: M:N relationship with join table (e.g., Students-Courses)
- @JoinColumn: Specifies foreign key column in DB
- @JoinTable: Configures join table for M:N relationships
- @MappedBy: Inverse side of bidirectional relationship
- FetchType.LAZY: Loads data only when accessed
- FetchType.EAGER: Loads data immediately
- CascadeType.ALL: Cascades all operations
- CascadeType.PERSIST: Cascades save operations
- CascadeType.REMOVE: Cascades delete operations

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
