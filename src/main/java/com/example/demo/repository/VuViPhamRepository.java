package com.example.demo.repository;

import com.example.demo.model.VuViPham;
import com.example.demo.model.ViolationSummary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface VuViPhamRepository extends JpaRepository<VuViPham, String> {

    @Query("SELECT new com.example.demo.model.ViolationSummary(v.maVVP, v.tenVVP, v.ngayXayRa, v.hinhThucXuLy, ct.mucDoViPham, n.tenNS, n.xuatXu) " +
           "FROM VuViPham v " +
           "JOIN ChiTietViPham ct ON v.maVVP = ct.maVVP " +
           "JOIN NongSan n ON ct.maNS = n.maNS")
    List<ViolationSummary> getFullViolationSummary();
}