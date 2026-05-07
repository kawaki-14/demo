package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import java.sql.Date;

@Entity
@Table(name = "CungCap")
@IdClass(CungCapID.class)
public class CungCap {
    @Id
    private String maNCC;
    @Id
    private String maNS;
    
    private Integer soLuongCC;
    private java.sql.Date ngayCC;

    public String getMaNCC() {
        return maNCC;
    }

    public void setMaNCC(String maNCC) {
        this.maNCC = maNCC;
    }

    public String getMaNS() {
        return maNS;
    }

    public void setMaNS(String maNS) {
        this.maNS = maNS;
    }

    public Integer getSoLuongCC() {
        return soLuongCC;
    }

    public void setSoLuongCC(Integer soLuongCC) {
        this.soLuongCC = soLuongCC;
    }

    public Date getNgayCC() {
        return ngayCC;
    }

    public void setNgayCC(Date ngayCC) {
        this.ngayCC = ngayCC;
    }

    
}