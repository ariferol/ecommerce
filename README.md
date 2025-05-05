![image](https://github.com/user-attachments/assets/480f33f6-1fb6-4207-85c0-7f9370fe8548)

# 🛒 Ecommerce Project

This is a modular, scalable e-commerce application developed using **Domain-Driven Design (DDD)**, **Hexagonal Architecture**, and **Clean Architecture** principles. The aim is to separate business logic from technical details and allow easy testing, extension, and maintenance.

---

## 📚 Tech Stack

- Java 17+
- Spring Boot
- Maven
- Lombok
- JPA (Hibernate)
- H2 Database (for development)
- REST API (Spring Web)

---

## 🧱 Architectural Layers
```
src/main/java/tr/org/ecommerce/
├── EcommerceApplication.java
├── adapter/
│   ├── in/web/                 # Controller layer (driving adapter)
│   └── out/db/                 # Data access adapter (driven adapter)
├── application/
│   ├── dto/                    # Command and response DTOs
│   └── usecase/                # Use case interfaces and implementations
├── common/
│   ├── exception/              # Custom exceptions
│   └── utils/                  # Utility classes
├── domain/
│   ├── model/                  # Entities and value objects
│   ├── port/                   # Port interfaces (repository ports)
│   └── service/                # Domain services (if any)
├── infrastructure/
│   ├── config/                 # Spring configuration classes (Bean definitions)
│   ├── external/               # External system integrations (currently empty)
│   └── repository/             # Repository port implementations

```

---

## 🧭 Core Concepts

| Concept                | Explanation |
|------------------------|-------------|
| `Domain Model`         | Encapsulates business rules and logic |
| `Use Cases`            | Application layer orchestration logic |
| `Ports` & `Adapters`   | Hexagonal architecture input/output interfaces |
| `Infrastructure`       | Contains database, mappers, and REST implementations |

---

## 🚀 Getting Started

### Prerequisites

- Java 17+
- Maven 3.8+

### Run the application

```bash
git clone https://github.com/ariferol/ecommerce-project.git
cd ecommerce-project
./mvnw clean install
./mvnw spring-boot:run
```
Access REST API
Base URL: http://localhost:8080/api

Sample endpoints:

GET /api/products

POST /api/products

GET /api/categories


## 📖 API Documentation

The project uses **Swagger/OpenAPI** for interactive API documentation.

- URL: `http://localhost:8080/swagger-ui/index.html`
- Specification: `http://localhost:8080/v3/api-docs`

![image](https://github.com/user-attachments/assets/ba7ea2be-315b-49b6-a01f-833596cf637e)

## 🧪 Testing
bash
Copy
Edit
./mvnw test
Unit tests focus on use case logic and domain rules. Infrastructure details are mocked.

## 📦 Modules (Planned / In Progress)
 Product Management

 Category Management

 Order & Cart Module

 User & Role Management

 Payment Integration

## 🗂️ To-Do / Future Work
Add global exception handling

Implement full CRUD for orders

Add JWT-based authentication

## 🧠 Principles Followed
✅ Separation of concerns

✅ Dependency inversion between core and infrastructure

✅ Domain-centered design

✅ Testable business logic

✅ Framework-agnostic domain layer

🧑‍💻 Author
Arif EROL

GitHub: [https://github.com/ariferol](https://github.com/ariferol/ecommerce)
