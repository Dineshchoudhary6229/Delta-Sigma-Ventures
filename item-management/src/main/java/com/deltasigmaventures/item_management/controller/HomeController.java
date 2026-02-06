package com.deltasigmaventures.item_management.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping(value = "/", produces = "text/html")
    public String home() {
        return """
               <pre>
Item Management Backend is LIVE!

Available APIs:
POST /api/items        -> Add item
GET  /api/items/{id}   -> Get item by ID

Status: RUNNING
               </pre>
               """;
    }

    @GetMapping("/health")
    public ResponseEntity<String> health() {
        return ResponseEntity.ok("OK");
    }
}
