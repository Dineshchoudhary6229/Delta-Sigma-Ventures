package com.deltasigmaventures.item_management.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class HomeController {

    @GetMapping(value = "/", produces = MediaType.TEXT_HTML_VALUE)
    public ResponseEntity<String> home() {
        return ResponseEntity.ok("""
                <html>
                  <head>
                    <title>Item Management API</title>
                  </head>
                  <body style="font-family: Arial, sans-serif;">
                    <h2>Item Management Backend is LIVE!</h2>

                    <h3>Available APIs</h3>
                    <ul>
                      <li><b>POST</b> /api/items — Add item</li>
                      <li><b>GET</b> /api/items/{id} — Get item by ID</li>
                    </ul>

                    <p><b>Status:</b> RUNNING</p>
                  </body>
                </html>
                """);
    }

    @GetMapping("/health")
    public ResponseEntity<String> health() {
        return ResponseEntity.ok("OK");
    }
}
