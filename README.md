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
│   ├── in/web/                 # Controller katmanı (driving adapter)
│   └── out/db/                 # Veri erişim adaptörü (driven adapter)
├── application/
│   ├── dto/                    # Komut ve response DTO'ları
│   └── usecase/                # Use case arayüzleri ve implemantasyonları
├── common/
│   ├── exception/
│   └── utils/
├── domain/
│   ├── model/                  # Entity ve value object'ler
│   ├── port/                   # Port arayüzleri (repository port'ları)
│   └── service/                # Domain servisler (varsa)
├── infrastructure/
│   ├── config/                 # Spring config sınıfları (Bean tanımları)
│   ├── external/               # Harici sistem entegrasyonları (şu an boş)
│   └── repository/             # Repository port implementasyonları


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
