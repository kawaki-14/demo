package com.example.demo.controller;

import com.example.demo.model.CungCap;
import com.example.demo.model.NongSan;
import com.example.demo.repository.CungCapRepository;
import com.example.demo.repository.NongSanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/cungcap")
@CrossOrigin(origins = "*")
public class CungCapController {

    @Autowired
    private CungCapRepository cungCapRepo;

    @Autowired
    private NongSanRepository nongSanRepo;

    @GetMapping("/all")
    public List<CungCap> getAll() {
        return cungCapRepo.findAll();
    }

    @PostMapping("/add")
    public ResponseEntity<?> addCungCap(@RequestBody CungCap cc) {
        try {
            CungCap savedCC = cungCapRepo.save(cc);

            Optional<NongSan> nsOpt = nongSanRepo.findById(cc.getMaNS());
            if (nsOpt.isPresent()) {
                NongSan ns = nsOpt.get();
                int soLuongMoi = ns.getSoLuong() + cc.getSoLuongCC();
                ns.setSoLuong(soLuongMoi);
                
                nongSanRepo.save(ns);
            }

            return ResponseEntity.ok(savedCC);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Lỗi khi nhập hàng: " + e.getMessage());
        }
    }

    @DeleteMapping("/delete/{maNCC}/{maNS}")
    public ResponseEntity<?> deleteCungCap(@PathVariable String maNCC, @PathVariable String maNS) {
        com.example.demo.model.CungCapID id = new com.example.demo.model.CungCapID(maNCC, maNS);
        cungCapRepo.deleteById(id);
        return ResponseEntity.ok().build();
    }
}