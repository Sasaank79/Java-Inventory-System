package com.inventory.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.inventory.model.Item;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class InventoryManager {
    private List<Item> inventory;
    private final String dataFile = "inventory.json";
    private final Gson gson;

    public InventoryManager() {
        this.gson = new GsonBuilder().setPrettyPrinting().create();
        this.inventory = new ArrayList<>();
        loadInventory();
    }

    // Load inventory from JSON file
    private void loadInventory() {
        File file = new File(dataFile);
        if (file.exists()) {
            try (Reader reader = new FileReader(file)) {
                Type listType = new TypeToken<ArrayList<Item>>() {}.getType();
                inventory = gson.fromJson(reader, listType);
                if (inventory == null) {
                    inventory = new ArrayList<>();
                }
            } catch (IOException e) {
                System.err.println("Error loading inventory: " + e.getMessage());
            }
        }
    }

    // Save inventory to JSON file
    private void saveInventory() {
        try (Writer writer = new FileWriter(dataFile)) {
            gson.toJson(inventory, writer);
        } catch (IOException e) {
            System.err.println("Error saving inventory: " + e.getMessage());
        }
    }

    public void addItem(Item item) throws IllegalArgumentException {
        if (findItemById(item.getId()).isPresent()) {
            throw new IllegalArgumentException("Item with ID " + item.getId() + " already exists.");
        }
        inventory.add(item);
        saveInventory();
    }

    public void updateItem(String id, String newName, int newQuantity, double newPrice) throws IllegalArgumentException {
        Optional<Item> itemOpt = findItemById(id);
        if (itemOpt.isPresent()) {
            Item item = itemOpt.get();
            item.setName(newName);
            item.setQuantity(newQuantity);
            item.setPrice(newPrice);
            saveInventory();
        } else {
            throw new IllegalArgumentException("Item with ID " + id + " not found.");
        }
    }

    public void deleteItem(String id) throws IllegalArgumentException {
        Optional<Item> itemOpt = findItemById(id);
        if (itemOpt.isPresent()) {
            inventory.remove(itemOpt.get());
            saveInventory();
        } else {
            throw new IllegalArgumentException("Item with ID " + id + " not found.");
        }
    }

    public Optional<Item> findItemById(String id) {
        return inventory.stream()
                .filter(item -> item.getId().equalsIgnoreCase(id))
                .findFirst();
    }

    public List<Item> searchItems(String keyword) {
        return inventory.stream()
                .filter(item -> item.getName().toLowerCase().contains(keyword.toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<Item> getAllItems() {
        return new ArrayList<>(inventory);
    }
}
