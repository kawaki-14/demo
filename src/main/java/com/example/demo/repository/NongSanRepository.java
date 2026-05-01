package com.example.demo.repository;

import com.example.demo.model.NongSan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NongSanRepository extends JpaRepository<NongSan, String> {
    
}