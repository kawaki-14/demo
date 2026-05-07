package com.example.demo.controller;

import com.example.demo.model.NhanVien;
import com.example.demo.repository.NhanVienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
public class AuthController {

    @Autowired
    private NhanVienRepository nhanVienRepository;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> loginData) {
        String maNV = loginData.get("maNV");
        String password = loginData.get("password");

        return nhanVienRepository.findById(maNV)
            .map(nv -> {
                if (nv.getMatKhau().equals(password)) {
                    Map<String, String> response = new HashMap<>();
                    response.put("maNV", nv.getMaNV());
                    response.put("hoTen", nv.getHoTen());
                    response.put("chucVu", nv.getChucVu());
                    return ResponseEntity.ok(response);
                } else {
                    return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                                         .body("Sai mật khẩu!");
                }
            })
            .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND)
                                 .body("Mã nhân viên không tồn tại!"));
    }
}