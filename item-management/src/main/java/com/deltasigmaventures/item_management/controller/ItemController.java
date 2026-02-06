package com.deltasigmaventures.item_management.controller;


import com.deltasigmaventures.item_management.model.Item;
import com.deltasigmaventures.item_management.service.ItemService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController                    //This tells the spring that this  class handles HTTP requests ,all methods return JSON responses, not HTML pages
@RequestMapping("/api/items")      //a base URL for all endpoints in this controller, every API inside this class will start with   /api/items
public class ItemController {      //Handles client requests and sends responses

    private final ItemService itemService;      // DI of ItemService class injected here

    public ItemController(ItemService itemService) {    // constructor DI
        this.itemService = itemService;
    }

    @PostMapping                                         //Maps HTTP POST requests
    public ResponseEntity<Item> addItem(@Valid @RequestBody Item item) {
        //ResponseEntity<Item>:Wraps response body + HTTP status.
       //@RequestBody : Converts incoming JSON to Item object
       //@Valid : Triggers validation rules defined in Item class (like @NotNull)

        return new ResponseEntity<>(itemService.addItem(item), HttpStatus.CREATED);
// itemService.addItem(item) : call service method to gernate id and save them,
//new ResponseEntity<>(..., HttpStatus.CREATED) : Returns the Saved item in response body
    }

    @GetMapping("/{id}")                    //Maps HTTP GET requests with a path variable
    public ResponseEntity<Item> getItem(@PathVariable Long id) {
        return itemService.getItemById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
//map(ResponseEntity::ok)= If item is found Wrap it in ResponseEntity and  Return HTTP 200 OK
// .orElse(ResponseEntity.notFound().build()); = if item not found: Return HTTP 404 NOT FOUND No response body
//@PathVariable : extracts id from URL and Converts /api/items/{id like 5 or any other }
// itemService.getItemById(id) = calls service method and Returns:Optional<Item>