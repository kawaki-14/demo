package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "NhaCungCap")
public class NhaCungCap {
    @Id
    private String maNCC;
    private String tenNCC;
    private String diaChi;
    private String loaiHinh;

    public String getMaNCC() {
        return maNCC;
    }

    public void setMaNCC(String maNCC) {
        this.maNCC = maNCC;
    }

    public String getTenNCC() {
        return tenNCC;
    }

    public void setTenNCC(String tenNCC) {
        this.tenNCC = tenNCC;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getLoaiHinh() {
        return loaiHinh;
    }

    public void setLoaiHinh(String loaiHinh) {
        this.loaiHinh = loaiHinh;
    }
    
    
}