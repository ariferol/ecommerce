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

This project is designed using the Domain-Driven Design (DDD) and Hexagonal Architecture (Ports & Adapters) approaches. The layers are as follows:
1. Adapter Layer (Input/Output Interfaces)

   adapter.in.web → REST Controllers (handles HTTP requests from the user)

   adapter.out.persistence → Database access layer (includes JPA Entities, Repositories, and Mappers)

2. Application Layer (Application Services)

   application.service.impl → Services that implement use cases

   application.service.spec → Interface-based ports (for external/domain-out services)

3. Domain Layer (Business Rules)

   domain.model → Core domain objects and business rules (Entities, Value Objects, Services, Policies, etc.)

   domain.usecase → Port definitions between the application layer and the domain

   domain.exception, domain.model.common → Common domain classes and exception structure

## 🧱 Layers (Summary)

    adapter.in.web → HTTP Controllers

    application.service.impl → Application services

    domain.model → Pure domain objects and rules

    adapter.out.persistence → Data access with JPA (Repository Adapter)

    adapter.out.persistence.mapper → Entity ↔︎ Domain Mapper classes


## 🧱 Project Structure
```
src/main/java/tr/org/ecommerce/
├── EcommerceApplication.java
├── adapter/
│   ├── in/
│   │   └── web/                         # Incoming requests – REST Controllers (driving adapters)
│   └── out/
│       └── persistence/                # Outgoing interactions – Data access layer (driven adapters)
│           ├── adapter/                # Bridges between domain repositories and database implementations
│           ├── entity/                 # JPA entities representing database tables
│           ├── mapper/                 # Converters between entity and domain models
│           └── repository/             # Spring Data JPA repositories
├── application/
│   └── service/
│       ├── impl/                       # Use case implementations (Application Services)
│       └── spec/                       # Application service interfaces (Input Ports)
├── common/
│   ├── exception/                      # Global/common exception definitions
│   └── util/                           # Utility classes (e.g., ID generator)
├── domain/
│   ├── exception/                      # Domain-specific exception types
│   ├── model/
│   │   ├── category/                   # Category aggregate root
│   │   │   ├── rootentity/             # Category domain entities
│   │   │   ├── policy/                 # Category-related business rules (policy interfaces and impls)
│   │   │   └── service/                # Domain services for category logic
│   │   ├── common/                     # Shared domain models (e.g., ID value object)
│   │   └── product/                    # Product aggregate root
│   │       ├── rootentity/             # Product domain entities
│   │       ├── policy/                 # Product policies (business constraints)
│   │       └── service/                # Product domain services
│   ├── port/
│   │   ├── in/
│   │   │   └── rest/                   # Port interfaces exposed to external REST adapters (input ports)
│   │   └── out/                        # Port interfaces for persistence or external systems (output ports)
│   └── usecase/                        # Domain-level use case interfaces
├── infrastructure/
│   ├── config/                         # Spring framework configuration (e.g., MapperConfig, JacksonConfig)
│   └── exception/                      # Global exception handlers (e.g., ControllerAdvice)

```

## ✅ Highlights
adapter.in.web: Controllers handle HTTP traffic (driving side).

adapter.out.persistence: Infrastructure implementation for persistence (driven side).

application.service.spec: Input ports – exposed use cases.

application.service.impl: Application logic – orchestrates domain.

domain.model: Business logic – pure domain entities, value objects, policies, and domain services.

domain.usecase: Port interfaces for use cases implemented by application.

infrastructure.config: Central place for Spring configuration classes like bean definitions and serialization.

---

## 🧭 Core Concepts

| Concept                | Explanation |
|------------------------|-------------|
| `Domain Model`         | Encapsulates business rules and logic |
| `Use Cases`            | Application layer orchestration logic |
| `Ports` & `Adapters`   | Hexagonal architecture input/output interfaces |
| `Infrastructure`       | Contains database, mappers, and REST implementations |


## 🧩 Core Concepts

| Concept              | Explanation                                                                                                  |
| -------------------- | ------------------------------------------------------------------------------------------------------------ |
| **Domain Model**     | Represents the core business logic and rules through entities, value objects, policies, and domain services. |
| **Use Cases**        | Encapsulate the application's orchestration logic via service interfaces and implementations.                |
| **Ports & Adapters** | Implements Hexagonal Architecture by separating external interfaces (REST, DB) from business logic.          |
| **Infrastructure**   | Contains global configurations such as exception handling and application-wide setup.                        |

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

Implement full CRUD for orders

Add JWT-based authentication

...

## 🧠 Principles Followed
✅ Separation of concerns

✅ Dependency inversion between core and infrastructure

✅ Domain-centered design

✅ Testable business logic

✅ Framework-agnostic domain layer

🧑‍💻 Author
Arif EROL

GitHub: [https://github.com/ariferol](https://github.com/ariferol/ecommerce)
