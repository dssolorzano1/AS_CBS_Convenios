package com.banquito.cbs.convenios.controlador;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IncioController {

    @GetMapping
    public ResponseEntity<String> inicio() {
        return ResponseEntity.ok("Microservicio de convenios");
    }
}
