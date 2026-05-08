package com.example.demo.controller;

import com.example.demo.model.VuViPham;
import com.example.demo.repository.VuViPhamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vuvipham")
@CrossOrigin(origins = "*")
public class VuViPhamController {

    @Autowired
    private VuViPhamRepository vvpRepo;

    @GetMapping("/all")
    public List<VuViPham> getAll() {
        return vvpRepo.findAll();
    }

    @PostMapping("/add")
    public VuViPham add(@RequestBody VuViPham vvp) {
        return vvpRepo.save(vvp);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<VuViPham> update(@PathVariable String id, @RequestBody VuViPham details) {
        return vvpRepo.findById(id).map(vvp -> {
            vvp.setTenVVP(details.getTenVVP());
            vvp.setNgayXayRa(details.getNgayXayRa());
            vvp.setHinhThucXuLy(details.getHinhThucXuLy());
            return ResponseEntity.ok(vvpRepo.save(vvp));
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        vvpRepo.deleteById(id);
        return ResponseEntity.ok().build();
    }
}