package com.example.demo.controller;

import com.example.demo.model.KiemDinh;
import com.example.demo.repository.KiemDinhRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/kiemdinh")
@CrossOrigin(origins = "*")
public class KiemDinhController {
    @Autowired
    private KiemDinhRepository kdRepo;

    @GetMapping("/all")
    public List<KiemDinh> getAll() { return kdRepo.findAll(); }

    @GetMapping("/nong-san/{maNS}")
    public List<KiemDinh> getByNongSan(@PathVariable String maNS) {
        return kdRepo.findByMaNS(maNS);
    }

    @PostMapping("/add")
    public KiemDinh add(@RequestBody KiemDinh kd) { return kdRepo.save(kd); }

    @PutMapping("/update/{id}")
    public ResponseEntity<KiemDinh> update(@PathVariable String id, @RequestBody KiemDinh details) {
        return kdRepo.findById(id).map(kd -> {
            kd.setCoQuanKD(details.getCoQuanKD());
            kd.setKetQua(details.getKetQua());
            kd.setNgayKiemDinh(details.getNgayKiemDinh());
            kd.setGhiChu(details.getGhiChu());
            return ResponseEntity.ok(kdRepo.save(kd));
        }).orElse(ResponseEntity.notFound().build());
    }
}