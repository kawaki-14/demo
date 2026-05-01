package com.example.demo.controller;

import com.example.demo.model.NongSan;
import com.example.demo.repository.NongSanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@CrossOrigin(origins = "*") 
@RequestMapping("/api/nongsan")
public class NSController {

    @Autowired
    private NongSanRepository nongSanRepository;

    @GetMapping("/test")
    public List<String> testApi() {
        return Arrays.asList("Tao", "Le", "Man", "Dua Hau");
    }

    @GetMapping("/all")
    public List<NongSan> getAllNongSan() {
        return nongSanRepository.findAll(); 
    }
}