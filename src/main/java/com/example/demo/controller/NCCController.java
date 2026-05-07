package com.example.demo.controller;

import com.example.demo.model.NhaCungCap;
import com.example.demo.repository.NhaCungCapRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/nhacungcap")
@CrossOrigin(origins = "*")
public class NCCController {
    @Autowired
    private NhaCungCapRepository nccRepo;

    @GetMapping("/all")
    public List<NhaCungCap> getAll() { return nccRepo.findAll(); }

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody NhaCungCap ncc) {
        if(nccRepo.existsById(ncc.getMaNCC())) return ResponseEntity.badRequest().body("Mã trùng!");
        return ResponseEntity.ok(nccRepo.save(ncc));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        nccRepo.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
