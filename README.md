# Java Inventory Management System

A simple, console-based Inventory Management System built with Java. This project demonstrates Object-Oriented Programming (OOP) principles, file handling with JSON, and unit testing.

## Features

- **Console-based Menu**: Easy-to-use interface for managing inventory.
- **CRUD Operations**: Add, Update, Delete, Search, and List items.
- **Data Persistence**: Inventory data is saved to `inventory.json` using the Gson library.
- **Input Validation**: Robust error handling for invalid inputs.
- **Unit Testing**: JUnit 5 tests for core logic.

## Project Structure

```
src/
  main/
    java/
      com/inventory/
        model/          # Data models (Item)
        service/        # Business logic (InventoryManager)
        Main.java       # Entry point
  test/
    java/
      com/inventory/    # Unit tests
```

## Prerequisites

- Java Development Kit (JDK) 17 or higher
- Maven 3.6 or higher

## How to Run

1.  **Clone the repository**:
    ```bash
    git clone <repository-url>
    cd inventory-system
    ```

2.  **Build the project**:
    ```bash
    mvn clean install
    ```

3.  **Run the application**:
    ```bash
    mvn exec:java
    ```

## How to Test

Run the unit tests using Maven:
```bash
mvn test
```

## Dependencies

- **Gson**: Google's library for JSON serialization/deserialization.
- **JUnit 5**: Testing framework.

## License

This project is open-source and available under the MIT License.
