<<<<<<< HEAD
# Spring Boot Advanced Backend Project

This project integrates **enterprise-grade practices** commonly used in real-world Spring Boot applications.  
It demonstrates robust backend design with database migrations, API documentation, AOP, validation, mapping, and exception handling.

---

## 🔹 Features Implemented

### 1. Liquibase Integration
- `dbmasterlog.yaml` for database changelog management  
- Separate YAML files for entity-based table creation  
- Version-controlled database schema changes  

### 2. Swagger
- API documentation for all REST endpoints  
- Interactive UI for testing APIs  

### 3. AOP (Aspect-Oriented Programming)
- **Logging Aspect**: centralized request/response logging  
- **Security Aspect**: method-level security checks  

### 4. Validation
- Field-level and class-level validation annotations  

### 5. Mapper
- DTO ↔ Entity conversion using mapper approach  

### 6. Global Exception Handling
- Centralized error responses using `@ControllerAdvice`  

---

## 🔹 Learning Outcome
This project demonstrates how to build a **robust, scalable backend system** with:  
- Controlled **database migrations** (Liquibase)  
- **Clean API documentation** (Swagger)  
- **Cross-cutting concerns** handled via AOP (logging, security)  
- Proper **validation & error handling**  
- Maintainable **DTO–Entity mapping**  

---

## 🚀 Tech Stack
- **Spring Boot**  
- **Liquibase**  
- **Swagger (OpenAPI)**  
- **Spring AOP**  
- **Hibernate Validator**  

---
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

>>>>>>> d3bebc1bca5f9ac42478c47609dfb3bc52baedcb
