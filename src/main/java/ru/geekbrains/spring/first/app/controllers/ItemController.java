package ru.geekbrains.spring.first.app.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.spring.first.app.model.Item;
import ru.geekbrains.spring.first.app.services.ItemService;
import ru.geekbrains.spring.first.app.utils.ArgumentValidationException;
import ru.geekbrains.spring.first.app.utils.ResourceNotFoundException;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/items")
@RequiredArgsConstructor
public class ItemController {
    private final ItemService itemService;

    @GetMapping
    public List<Item> getAllItems() {
        return itemService.findAll();
    }

    @GetMapping("/{id}")
    public Item getItemById(@PathVariable Long id) {
        return itemService.findById(id).orElseThrow(() -> new ResourceNotFoundException("Item with id: " + id + " not found"));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Item createNewItem(/*@Valid*/ @RequestBody Item item) {
        if (item.getPrice() <= 0)
            throw new ArgumentValidationException("Price cannot be less than or equal to zero");
        return itemService.save(item);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Item updateItem(@PathVariable("id") long id, /*@Valid*/ @RequestBody Item item) {
        if (item.getPrice() <= 0)
            throw new ArgumentValidationException("Price cannot be less than or equal to zero");
        Item _item = itemService.findById(id).orElseThrow(() -> new ResourceNotFoundException("Item with id: " + id + " not found"));
        _item.setTitle(item.getTitle());
        _item.setPrice(item.getPrice());
        return itemService.save(_item);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deleteItem(@PathVariable("id") long id) {
        try {
            itemService.deleteById(id);
        } catch (Exception e) {
            throw new ResourceNotFoundException("Item with id: " + id + " not found");
        }
    }

    @DeleteMapping()
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deleteAllItems() {
        try {
            itemService.deleteAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
