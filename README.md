# RegistrationApplication

Simple Java Servlet/JSP registration example (WAR) that stores user details in a MySQL database.

## Overview
This project provides a minimal registration and login flow using Jakarta Servlets and JSPs. It builds to a WAR (packaging: war) and is intended to be deployed to a servlet container (e.g., Apache Tomcat).

## Prerequisites
- JDK 26
- Maven (or use the included Maven wrapper: `mvnw` / `mvnw.cmd`)
- MySQL server
- Servlet container (Tomcat 10+ or any Jakarta EE 10/11 compatible container)

## Database setup
The application expects a database named `java_db` and a `personalinfo` table. Example SQL:

```sql
CREATE DATABASE IF NOT EXISTS java_db;
USE java_db;

CREATE TABLE IF NOT EXISTS personalinfo (
  id INT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(255) NOT NULL,
  email VARCHAR(255) NOT NULL,
  upassword VARCHAR(255) NOT NULL,
  city VARCHAR(255)
);
```

Update database credentials in `JdbcUtil.java` before running the application.

## Build
From the project root (Windows):

## Deploy
- Copy the generated WAR to your servlet container's `webapps/` (e.g., Tomcat) and start the server.
- Visit: `http://localhost:8080/RegistrationApplication/` (or the context path used by your container).

Alternatively, install an embedded runner or use your IDE to deploy the WAR.

## Project structure (important files)
- `src/main/java/com/jay/registrationapplication/`
  - `Register.java` - servlet handling registration
  - `Login.java` - servlet handling login
  - `Model.java` - DB operations for register/login
  - `JdbcUtil.java` - JDBC connection helper (contains DB credentials)
- `src/main/webapp/` - JSPs and static pages (index.html, register.html, login.html, success/failure JSPs)
- `pom.xml` - Maven configuration

## Notes & Security
- Credentials are hardcoded in `JdbcUtil.java` for simplicity. Replace with environment variables, JNDI datasource, or configuration file before production use.
- Passwords are stored in plaintext in this example. Use secure hashing (bcrypt/argon2) for real projects.

## Tests
No automated tests included. The pom contains JUnit dependencies (JUnit 5) in case you add unit tests.

## Contributing
- Fork the repo, create a feature branch, open a PR.
- Update README if you change configuration or behavior.

## Contact
For questions, open an issue or contact the repository owner.
