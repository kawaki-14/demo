package com.example.demo.repository;

import com.example.demo.model.CungCap;
import com.example.demo.model.CungCapID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CungCapRepository extends JpaRepository<CungCap, CungCapID> {

}