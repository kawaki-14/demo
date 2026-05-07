package com.example.demo.repository;

import com.example.demo.model.NhaCungCap;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NhaCungCapRepository extends JpaRepository<NhaCungCap, String> {
    
}