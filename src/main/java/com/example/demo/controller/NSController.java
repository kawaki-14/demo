package com.example.demo.controller;

import com.example.demo.model.NongSan;
import com.example.demo.repository.NongSanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/nongsan")
public class NSController {

    @Autowired
    private NongSanRepository nongSanRepository;

    @GetMapping("/all")
    public List<NongSan> getAllNongSan() {
        return nongSanRepository.findAll(); 
    }
 
    @PostMapping("/add")
    public ResponseEntity<NongSan> addNongSan(@RequestBody NongSan ns) {
        NongSan savedNs = nongSanRepository.save(ns);
        return ResponseEntity.ok(savedNs);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<NongSan> updateNongSan(@PathVariable String id, @RequestBody NongSan nsDetails) {
        return nongSanRepository.findById(id)
                .map(ns -> {
                    ns.setTenNS(nsDetails.getTenNS());
                    ns.setLoai(nsDetails.getLoai());
                    ns.setSoLuong(nsDetails.getSoLuong());
                    ns.setGia(nsDetails.getGia());
                    ns.setXuatXu(nsDetails.getXuatXu());
                    NongSan updatedNs = nongSanRepository.save(ns);
                    return ResponseEntity.ok(updatedNs);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteNongSan(@PathVariable String id) {
        if (nongSanRepository.existsById(id)) {
            nongSanRepository.deleteById(id);
            Map<String, Boolean> response = new HashMap<>();
            response.put("deleted", Boolean.TRUE);
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}