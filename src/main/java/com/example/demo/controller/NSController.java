package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import java.util.Arrays;
import java.util.List;

@RestController
@CrossOrigin(origins = "*") 
@RequestMapping("/api/nongsan")
public class NSController {

    @GetMapping("/test")
    public List<String> testApi() {
        return Arrays.asList("Tao", "Le", "Man", "Dua Hau");
    }
}