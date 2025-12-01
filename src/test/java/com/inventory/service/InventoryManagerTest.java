package com.inventory.service;

import com.inventory.model.Item;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.File;
import java.nio.file.Path;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class InventoryManagerTest {

    private InventoryManager manager;

    @BeforeEach
    void setUp() {
        // In a real scenario, we might want to mock the file system or use a temporary file.
        // For simplicity, we will just clear the inventory for each test if possible,
        // or rely on the fact that we are creating a new instance.
        // However, since InventoryManager reads from a file on startup, we need to be careful.
        // A better approach for testing would be to allow injecting the filename.
        
        // For this simple portfolio project, let's just delete the file before each test 
        // to ensure a clean state.
        File file = new File("inventory.json");
        if (file.exists()) {
            file.delete();
        }
        manager = new InventoryManager();
    }

    @Test
    void testAddItem() {
        Item item = new Item("1", "Laptop", 10, 999.99);
        manager.addItem(item);

        List<Item> items = manager.getAllItems();
        assertEquals(1, items.size());
        assertEquals("Laptop", items.get(0).getName());
    }

    @Test
    void testAddDuplicateItem() {
        Item item1 = new Item("1", "Laptop", 10, 999.99);
        manager.addItem(item1);

        Item item2 = new Item("1", "Mouse", 5, 20.00);
        assertThrows(IllegalArgumentException.class, () -> manager.addItem(item2));
    }

    @Test
    void testUpdateItem() {
        Item item = new Item("1", "Laptop", 10, 999.99);
        manager.addItem(item);

        manager.updateItem("1", "Gaming Laptop", 5, 1200.00);

        Optional<Item> updated = manager.findItemById("1");
        assertTrue(updated.isPresent());
        assertEquals("Gaming Laptop", updated.get().getName());
        assertEquals(5, updated.get().getQuantity());
    }

    @Test
    void testDeleteItem() {
        Item item = new Item("1", "Laptop", 10, 999.99);
        manager.addItem(item);

        manager.deleteItem("1");
        assertTrue(manager.getAllItems().isEmpty());
    }

    @Test
    void testSearchItem() {
        manager.addItem(new Item("1", "Apple", 10, 1.0));
        manager.addItem(new Item("2", "Banana", 20, 0.5));
        manager.addItem(new Item("3", "Pineapple", 5, 3.0));

        List<Item> results = manager.searchItems("apple");
        assertEquals(2, results.size()); // Apple and Pineapple
    }
}
