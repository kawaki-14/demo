package com.example.demo.repository;

import com.example.demo.model.VuViPham;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VuViPhamRepository extends JpaRepository<VuViPham, String> {
    
}