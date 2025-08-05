# Conections Pool

## Description

A transaction is a sequence of database operations executed as a single logical unit, ensuring data integrity through ACID properties (Atomicity, Consistency, Isolation, Durability). In JDBC, transactions are managed explicitly via the Connection object. Key operations include.


It includes the following key topics:

- Commit: 
  - Finalizes all changes within the transaction, making them permanent in the database.
  - Invoked via connection.commit().

- Rollback:
  - Reverts all changes made during the transaction, restoring the database to its previous state.
  - Triggered by connection.rollback() (typically in a catch block after an error).

- Auto-Commit Mode:
  - By default, JDBC uses auto-commit (connection.setAutoCommit(true)), executing each statement as an independent transaction.
  - Disable it (setAutoCommit(false)) to group multiple operations into a single transaction.

- Savepoints:
  - Intermediate markers within a transaction, allowing partial rollbacks via connection.setSavepoint().

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
