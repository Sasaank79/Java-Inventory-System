# Java Inventory System 📦

A **Spring Boot** REST API for inventory management with **Swagger**, **validation**, and **Docker** support.

## 🚀 Features

- RESTful API with full CRUD operations
- **Swagger UI** for live API documentation
- **Input Validation** with clean error responses
- **Docker ready** (PostgreSQL) for production
- **H2** in-memory database for local development

## 🛠️ Tech Stack

- **Java 17+**
- **Spring Boot 3.2**
- **Spring Data JPA**
- **H2** (local) / **PostgreSQL** (Docker)
- **Docker & Docker Compose**
- **Swagger / OpenAPI**

## 🏃‍♂️ How to Run

### Local Development (H2)
```bash
mvn spring-boot:run
```

### With Docker (PostgreSQL)
```bash
docker-compose up --build
```

API available at: `http://localhost:8080`

## 📖 API Documentation

Swagger UI: `http://localhost:8080/swagger-ui.html`

## 📡 API Endpoints

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/api/items` | List all items |
| GET | `/api/items/{id}` | Get item by ID |
| POST | `/api/items` | Create new item |
| PUT | `/api/items/{id}` | Update item |
| DELETE | `/api/items/{id}` | Delete item |
| GET | `/api/items/search?name=keyword` | Search by name |

## 📝 Example

```bash
# Add item
curl -X POST http://localhost:8080/api/items \
  -H "Content-Type: application/json" \
  -d '{"name": "Laptop", "quantity": 10, "price": 999.99}'

# Validation error
curl -X POST http://localhost:8080/api/items \
  -H "Content-Type: application/json" \
  -d '{"name": "", "quantity": -5, "price": 0}'
```

## 📂 Project Structure

```
src/main/java/com/inventory/
├── InventoryApplication.java
├── controller/ItemController.java
├── model/Item.java
├── repository/ItemRepository.java
└── exception/GlobalExceptionHandler.java
```

---
*Built by Surya Sasaank Y.*
