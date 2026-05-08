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
    public ResponseEntity<?> update(
        @PathVariable String id, 
        @RequestBody NhanVien nvDetails,
        @RequestHeader("currentRole") String currentRole,
        @RequestHeader("currentMaNV") String currentMaNV) {

        if (!currentRole.equals("Quản lý") && !currentMaNV.equals(id)) {
            return ResponseEntity.status(403).body("Bro không có quyền sửa người khác!");
        }

        return nvRepo.findById(id).map(nv -> {
            nv.setHoTen(nvDetails.getHoTen());
            if (currentRole.equals("Quản lý")) {
                nv.setChucVu(nvDetails.getChucVu());
                nv.setMaCa(nvDetails.getMaCa());
            }
            nv.setSdt(nvDetails.getSdt());
            nv.setMatKhau(nvDetails.getMatKhau());
            return ResponseEntity.ok(nvRepo.save(nv));
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(
        @PathVariable String id,
        @RequestHeader("currentRole") String currentRole) {
        if (!currentRole.equals("Quản lý")) {
            return ResponseEntity.status(403).body("Chỉ admin mới được xóa nhân viên!");
        }
        
        nvRepo.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
