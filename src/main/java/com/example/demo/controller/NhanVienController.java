package com.example.demo.controller;

import com.example.demo.model.NhanVien;
import com.example.demo.repository.NhanVienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/nhanvien")
@CrossOrigin(origins = "*")
public class NhanVienController {

    @Autowired
    private NhanVienRepository nvRepo;

    @GetMapping("/all")
    public List<NhanVien> getAll() {
        return nvRepo.findAll();
    }

    @PostMapping("/add")
    public NhanVien add(@RequestBody NhanVien nv) {
        if (nv.getMatKhau() == null || nv.getMatKhau().isEmpty()) {
            nv.setMatKhau("123456");
        }
        return nvRepo.save(nv);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<NhanVien> update(@PathVariable String id, @RequestBody NhanVien nvDetails) {
        return nvRepo.findById(id).map(nv -> {
            nv.setHoTen(nvDetails.getHoTen());
            nv.setChucVu(nvDetails.getChucVu());
            nv.setSdt(nvDetails.getSdt());
            nv.setMaCa(nvDetails.getMaCa());
            nv.setMatKhau(nvDetails.getMatKhau());
            return ResponseEntity.ok(nvRepo.save(nv));
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        nvRepo.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
