package com.deltasigmaventures.item_management.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/")
    public ResponseEntity<String> home() {
        return ResponseEntity.ok(
                " Item Management Backend is LIVE!\n\n" +
                        "Available APIs:\n" +
                        "POST /api/items   -> Add item\n" +
                        "GET  /api/items/{id} -> Get item by ID\n\n" +
                        "Status: RUNNING"
        );
    }

    @GetMapping("/health")
    public ResponseEntity<String> health() {
        return ResponseEntity.ok("OK");
    }
}
