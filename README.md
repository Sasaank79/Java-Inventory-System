# Java Inventory System 📦

Hi there! Welcome to my **Java Inventory Management System**.

I built this project to demonstrate a clean, efficient way to manage products using **Core Java**. It's a console-based application that lets you track items, update stock, and manage prices—all while saving everything automatically so you never lose your data.

It's designed to be simple but robust, using industry-standard tools like **Maven** for build management and **Gson** for handling data.

## 🚀 Key Features

*   **Persistent Storage**: Your data is saved to a `inventory.json` file. Close the app, open it back up, and your items are still there.
*   **CRUD Operations**: You can **C**reate, **R**ead, **U**pdate, and **D**elete items easily.
*   **Search**: Quickly find items by name (e.g., searching "Apple" finds "Apple Watch" and "Apple Juice").
*   **Input Validation**: The app won't crash if you accidentally type "abc" when it asks for a price. It handles errors gracefully.
*   **Clean Code**: Written with Object-Oriented principles (OOP) in mind.

## 🛠️ Tech Stack

*   **Language**: Java (JDK 17+)
*   **Build Tool**: Maven
*   **Data Format**: JSON (via Google Gson library)
*   **Testing**: JUnit 5

## 🏃‍♂️ How to Run It

You'll need **Java** and **Maven** installed on your machine.

1.  **Clone this repo**:
    ```bash
    git clone https://github.com/Sasaank79/Java-Inventory-System.git
    cd Java-Inventory-System
    ```

2.  **Build the project**:
    ```bash
    mvn clean install
    ```

3.  **Start the App**:
    ```bash
    mvn exec:java
    ```

4.  **Run Tests** (Optional):
    ```bash
    mvn test
    ```

## 📝 How It Works

When you start the application, it looks for a file called `inventory.json`.
*   **If found**: It loads all your existing items into memory.
*   **If not found**: It starts with an empty list.

Every time you **Add**, **Update**, or **Delete** an item, the system automatically rewrites the `inventory.json` file. This ensures your data is always safe, even if the program stops unexpectedly.

## 📂 Project Structure

*   `src/main/java`: The actual source code.
    *   `model/Item.java`: Defines what an "Item" is (ID, Name, Price, Qty).
    *   `service/InventoryManager.java`: The brain of the operation. Handles logic and file saving.
    *   `Main.java`: The menu you interact with.
*   `src/test/java`: Unit tests to make sure everything works correctly.
*   `inventory.json`: The database file (generated automatically).

---
*Built by [Surya Sasaank Y.]*
