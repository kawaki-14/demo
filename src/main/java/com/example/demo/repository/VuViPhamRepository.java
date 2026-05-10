package com.example.demo.repository;

import com.example.demo.model.VuViPham;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

public interface VuViPhamRepository extends JpaRepository<VuViPham, String> {

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO ChiTietViPham (maVVP, maNS, mucDoViPham) VALUES (:maVVP, :maNS, :mucDo)", nativeQuery = true)
    void insertDetail(@Param("maVVP") String maVVP, @Param("maNS") String maNS, @Param("mucDo") String mucDo);

    @Modifying
    @Transactional
    @Query(value = "UPDATE ChiTietViPham SET maNS = :maNS, mucDoViPham = :mucDo WHERE maVVP = :maVVP", nativeQuery = true)
    void updateDetail(@Param("maVVP") String maVVP, @Param("maNS") String maNS, @Param("mucDo") String mucDo);

    @Query(value = "SELECT v.maVVP, v.tenVVP, v.ngayXayRa, v.hinhThucXuLy, " +
                   "ct.mucDoViPham, n.tenNS, n.xuatXu " +
                   "FROM VuViPham v " +
                   "JOIN ChiTietViPham ct ON v.maVVP = ct.maVVP " +
                   "JOIN NongSan n ON ct.maNS = n.maNS", 
           nativeQuery = true)
    List<Object[]> getFullViolationSummaryNative();
}