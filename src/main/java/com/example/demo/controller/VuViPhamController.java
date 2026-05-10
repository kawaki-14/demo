package com.example.demo.controller;

import com.example.demo.model.VuViPham;
import com.example.demo.repository.VuViPhamRepository;
import java.util.ArrayList;
import java.util.HashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public VuViPham add(@RequestBody VuViPham vvp) {
        return vvpRepo.save(vvp);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<VuViPham> update(@PathVariable String id, @RequestBody VuViPham details) {
        return vvpRepo.findById(id).map(vvp -> {
            vvp.setTenVVP(details.getTenVVP());
            vvp.setNgayXayRa(details.getNgayXayRa());
            vvp.setHinhThucXuLy(details.getHinhThucXuLy());
            vvp.setMaNS(details.getMaNS());
            vvp.setMucDo(details.getMucDo());
            
            return ResponseEntity.ok(vvpRepo.save(vvp));
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