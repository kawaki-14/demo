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
 
    @PostMapping("/add")
    public NongSan addNongSan(@RequestBody NongSan ns) {
        return nongSanRepository.save(ns);
    }

    @PutMapping("/update/{id}")
    public NongSan updateNongSan(@PathVariable String id, @RequestBody NongSan nsDetails) {
        NongSan ns = nongSanRepository.findById(id).orElseThrow();
        ns.setTenNS(nsDetails.getTenNS());
        ns.setLoai(nsDetails.getLoai());
        ns.setSoLuong(nsDetails.getSoLuong());
        ns.setGia(nsDetails.getGia());
        ns.setXuatXu(nsDetails.getXuatXu());
        return nongSanRepository.save(ns);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteNongSan(@PathVariable String id) {
        nongSanRepository.deleteById(id);
    }
}

