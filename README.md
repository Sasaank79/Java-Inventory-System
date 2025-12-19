# Java Inventory System 📦

A **Spring Boot** REST API for managing inventory items, built with **JPA** and **H2 Database**.

## 🚀 Features

- RESTful API with full CRUD operations
- H2 in-memory database (auto-creates tables)
- Spring Data JPA for database access
- Clean layered architecture (Controller → Repository → Entity)

## 🛠️ Tech Stack

- **Java 17+**
- **Spring Boot 3.2**
- **Spring Data JPA**
- **H2 Database**
- **Maven**

## 🏃‍♂️ How to Run

```bash
# Clone the repo
git clone https://github.com/Sasaank79/Java-Inventory-System.git
cd Java-Inventory-System

# Run the application
mvn spring-boot:run
```

The API will be available at `http://localhost:8080`

## 📡 API Endpoints

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/api/items` | List all items |
| GET | `/api/items/{id}` | Get item by ID |
| POST | `/api/items` | Create new item |
| PUT | `/api/items/{id}` | Update item |
| DELETE | `/api/items/{id}` | Delete item |
| GET | `/api/items/search?name=keyword` | Search by name |

## 📝 Example Usage

**Add an item:**
```bash
curl -X POST http://localhost:8080/api/items \
  -H "Content-Type: application/json" \
  -d '{"name": "Laptop", "quantity": 10, "price": 999.99}'
```

**List all items:**
```bash
curl http://localhost:8080/api/items
```

## 📂 Project Structure

```
src/main/java/com/inventory/
├── InventoryApplication.java   # Entry point
├── controller/
│   └── ItemController.java     # REST endpoints
├── model/
│   └── Item.java               # JPA Entity
└── repository/
    └── ItemRepository.java     # Data access layer
```

## 🗄️ H2 Console

Access the database console at: `http://localhost:8080/h2-console`
- JDBC URL: `jdbc:h2:mem:inventory`
- Username: `sa`
- Password: *(leave blank)*

---
*Built by Surya Sasaank Y.*
