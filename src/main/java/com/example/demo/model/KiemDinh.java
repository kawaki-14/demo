package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.sql.Date;

@Entity
@Table(name = "KiemDinh")
public class KiemDinh {
    @Id
    private String maKD;
    private String coQuanKD;
    private String ketQua;
    private Date ngayKiemDinh;
    private String ghiChu;
    private String maNS;

    public KiemDinh() {}

    public String getMaKD() {
        return maKD;
    }

    public void setMaKD(String maKD) {
        this.maKD = maKD;
    }

    public String getCoQuanKD() {
        return coQuanKD;
    }

    public void setCoQuanKD(String coQuanKD) {
        this.coQuanKD = coQuanKD;
    }

    public String getKetQua() {
        return ketQua;
    }

    public void setKetQua(String ketQua) {
        this.ketQua = ketQua;
    }

    public Date getNgayKiemDinh() {
        return ngayKiemDinh;
    }

    public void setNgayKiemDinh(Date ngayKiemDinh) {
        this.ngayKiemDinh = ngayKiemDinh;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public String getMaNS() {
        return maNS;
    }

    public void setMaNS(String maNS) {
        this.maNS = maNS;
    }
    
}