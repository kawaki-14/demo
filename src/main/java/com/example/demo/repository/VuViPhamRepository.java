package com.example.demo.repository;

import com.example.demo.model.VuViPham;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface VuViPhamRepository extends JpaRepository<VuViPham, String> {

    @Query(value = "SELECT v.maVVP, v.tenVVP, v.ngayXayRa, v.hinhThucXuLy, " +
                   "ct.mucDoViPham, n.tenNS, n.xuatXu " +
                   "FROM VuViPham v " +
                   "JOIN ChiTietViPham ct ON v.maVVP = ct.maVVP " +
                   "JOIN NongSan n ON ct.maNS = n.maNS", 
           nativeQuery = true)
    List<Object[]> getFullViolationSummaryNative();
}