package com.example.demo.controller;

import com.example.demo.model.NongSan;
import com.example.demo.repository.NongSanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

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
    public ResponseEntity<?> addNongSan(@RequestBody NongSan ns) {
        if (nongSanRepository.existsById(ns.getMaNS())) {
            return ResponseEntity.badRequest().body("Lỗi: Mã nông sản này đã tồn tại. Vui lòng xóa mã cũ trước khi thêm mới!");
        }
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
    public ResponseEntity<?> deleteNongSan(@PathVariable String id) {
        try {
            if (nongSanRepository.existsById(id)) {
                nongSanRepository.deleteById(id);
                return ResponseEntity.ok().body("{\"message\": \"Xóa thành công\"}");
            } else {
                return ResponseEntity.status(404).body("Mã không tồn tại.");
            }
        } catch (Exception e) {
            return ResponseEntity.status(409).body("Không thể xóa: Nông sản này đang có dữ liệu liên quan trong bảng Kiểm định hoặc Cung cấp!");
        }
    }
    
    @GetMapping("/sap-het-han")
    public List<NongSan> getSapHetHan() {
        return nongSanRepository.findAll().stream()
            .filter(ns -> ns.getHsd() != null)
            .filter(ns -> {
                long diff = ns.getHsd().getTime() - System.currentTimeMillis();
                long days = diff / (1000 * 60 * 60 * 24);
                return days <= 7;
            })
        .collect(Collectors.toList());
    }
}