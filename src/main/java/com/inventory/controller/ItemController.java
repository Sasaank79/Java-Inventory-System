package com.inventory.controller;

import com.inventory.model.Item;
import com.inventory.repository.ItemRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/items")
public class ItemController {

    private final ItemRepository repository;

    public ItemController(ItemRepository repository) {
        this.repository = repository;
    }

    // GET all items
    @GetMapping
    public List<Item> getAllItems() {
        return repository.findAll();
    }

    // GET item by ID
    @GetMapping("/{id}")
    public ResponseEntity<Item> getItemById(@PathVariable Long id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // POST create new item
    @PostMapping
    public Item createItem(@RequestBody Item item) {
        return repository.save(item);
    }

    // PUT update item
    @PutMapping("/{id}")
    public ResponseEntity<Item> updateItem(@PathVariable Long id, @RequestBody Item itemDetails) {
        return repository.findById(id)
                .map(item -> {
                    item.setName(itemDetails.getName());
                    item.setQuantity(itemDetails.getQuantity());
                    item.setPrice(itemDetails.getPrice());
                    return ResponseEntity.ok(repository.save(item));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // DELETE item
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteItem(@PathVariable Long id) {
        return repository.findById(id)
                .map(item -> {
                    repository.delete(item);
                    return ResponseEntity.ok().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // GET search by name
    @GetMapping("/search")
    public List<Item> searchItems(@RequestParam String name) {
        return repository.findByNameContainingIgnoreCase(name);
    }
}
