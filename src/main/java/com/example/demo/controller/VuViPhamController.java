package com.example.demo.controller;

import com.example.demo.model.VuViPham;
import com.example.demo.repository.VuViPhamRepository;
import java.util.ArrayList;
import java.util.HashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

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
    @Transactional
    public VuViPham add(@RequestBody VuViPham vvp) {
        VuViPham saved = vvpRepo.save(vvp);
        
        if (vvp.getMaNS() != null && !vvp.getMaNS().isEmpty()) {
            vvpRepo.insertDetail(saved.getMaVVP(), vvp.getMaNS(), vvp.getMucDo());
        }
        return saved;
    }

    @PutMapping("/update/{id}")
    @Transactional
    public ResponseEntity<VuViPham> update(@PathVariable String id, @RequestBody VuViPham details) {
        return vvpRepo.findById(id).map(vvp -> {
            vvp.setTenVVP(details.getTenVVP());
            vvp.setNgayXayRa(details.getNgayXayRa());
            vvp.setHinhThucXuLy(details.getHinhThucXuLy());
            
            vvpRepo.save(vvp);
            
            vvpRepo.updateDetail(id, details.getMaNS(), details.getMucDo());
            
            return ResponseEntity.ok(vvp);
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        vvpRepo.deleteById(id);
        return ResponseEntity.ok().build();
    }
    
    @GetMapping("/summary")
    public List<Map<String, Object>> getSummary() {
        List<Object[]> results = vvpRepo.getFullViolationSummaryNative();
        List<Map<String, Object>> summary = new ArrayList<>();
    
        for (Object[] row : results) {
            Map<String, Object> map = new HashMap<>();
            map.put("maVVP", row[0]);
            map.put("tenVVP", row[1]);
            map.put("ngayXayRa", row[2]);
            map.put("hinhThucXuLy", row[3]);
            map.put("mucDo", row[4]);
            map.put("tenNS", row[5]);
            map.put("xuatXu", row[6]);
            summary.add(map);
        }
        return summary;
    }
}