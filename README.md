=======
# 🚀 User Details Demo Project

This is a **Spring Boot demo project** showcasing enterprise-level best practices.  
It integrates database versioning, request validation, cross-cutting concerns via AOP, and role-based security.  
The project is built and managed using **Gradle**.

---

## 📌 Features

- **Liquibase Integration**
  - Database schema versioning and migrations.
  - YAML changelog files for easy tracking.
  
- **Validation**
  - Class-level and field-level validation using `jakarta.validation` annotations.
  - Custom validators for complex business rules.
  
- **AOP Logging**
  - Centralized logging for method calls, inputs, outputs, and execution time.
  - Helps in debugging and monitoring.

- **AOP Security**
  - Role-based access control using custom annotations + Spring Security.
  - Secures endpoints with minimal boilerplate code.

- **Global Exception Handling**
  - Unified error response with proper HTTP status codes.
  - Custom exception classes and handlers.

- **Gradle Build Tool**
  - Easy dependency management.
  - Supports both development and production builds.

- **Swagger/OpenAPI**
  - Auto-generated API documentation.
  - Interactive API testing from browser.

---

## 🛠️ Tech Stack

- **Java 17+**
- **Spring Boot 3+**
- **Gradle**
- **Liquibase**
- **Spring Validation**
- **Spring Security**
- **AOP (Aspect Oriented Programming)**
- **Swagger / Springdoc OpenAPI**

---
