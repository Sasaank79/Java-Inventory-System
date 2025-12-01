package com.inventory;

import com.inventory.model.Item;
import com.inventory.service.InventoryManager;

import java.util.List;
import java.util.Scanner;

public class Main {
    private static final InventoryManager manager = new InventoryManager();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean running = true;

        while (running) {
            printMenu();
            int choice = getIntInput("Enter your choice: ");

            switch (choice) {
                case 1:
                    addItem();
                    break;
                case 2:
                    updateItem();
                    break;
                case 3:
                    deleteItem();
                    break;
                case 4:
                    searchItem();
                    break;
                case 5:
                    listItems();
                    break;
                case 6:
                    running = false;
                    System.out.println("Exiting... Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
            System.out.println();
        }
    }

    private static void printMenu() {
        System.out.println("=== Java Inventory Management System ===");
        System.out.println("1. Add Item");
        System.out.println("2. Update Item");
        System.out.println("3. Delete Item");
        System.out.println("4. Search Item");
        System.out.println("5. List All Items");
        System.out.println("6. Exit");
        System.out.println("========================================");
    }

    private static void addItem() {
        System.out.println("\n--- Add New Item ---");
        String id = getStringInput("Enter Item ID: ");
        String name = getStringInput("Enter Item Name: ");
        int qty = getIntInput("Enter Quantity: ");
        double price = getDoubleInput("Enter Price: ");

        try {
            manager.addItem(new Item(id, name, qty, price));
            System.out.println("Item added successfully!");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void updateItem() {
        System.out.println("\n--- Update Item ---");
        String id = getStringInput("Enter Item ID to update: ");
        
        if (manager.findItemById(id).isEmpty()) {
            System.out.println("Error: Item not found.");
            return;
        }

        String name = getStringInput("Enter New Name: ");
        int qty = getIntInput("Enter New Quantity: ");
        double price = getDoubleInput("Enter New Price: ");

        try {
            manager.updateItem(id, name, qty, price);
            System.out.println("Item updated successfully!");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void deleteItem() {
        System.out.println("\n--- Delete Item ---");
        String id = getStringInput("Enter Item ID to delete: ");

        try {
            manager.deleteItem(id);
            System.out.println("Item deleted successfully!");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void searchItem() {
        System.out.println("\n--- Search Item ---");
        String keyword = getStringInput("Enter name to search: ");
        List<Item> results = manager.searchItems(keyword);

        if (results.isEmpty()) {
            System.out.println("No items found.");
        } else {
            System.out.println("Search Results:");
            results.forEach(System.out::println);
        }
    }

    private static void listItems() {
        System.out.println("\n--- Inventory List ---");
        List<Item> items = manager.getAllItems();
        if (items.isEmpty()) {
            System.out.println("Inventory is empty.");
        } else {
            items.forEach(System.out::println);
        }
    }

    // Helper methods for input validation
    private static String getStringInput(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine().trim();
    }

    private static int getIntInput(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                int value = Integer.parseInt(scanner.nextLine().trim());
                if (value < 0) {
                    System.out.println("Value cannot be negative.");
                    continue;
                }
                return value;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }
    }

    private static double getDoubleInput(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                double value = Double.parseDouble(scanner.nextLine().trim());
                if (value < 0) {
                    System.out.println("Value cannot be negative.");
                    continue;
                }
                return value;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }
    }
}
