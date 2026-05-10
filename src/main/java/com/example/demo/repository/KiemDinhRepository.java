package com.example.demo.repository;

import com.example.demo.model.KiemDinh;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface KiemDinhRepository extends JpaRepository<KiemDinh, String> {
    List<KiemDinh> findByMaNS(String maNS);
}