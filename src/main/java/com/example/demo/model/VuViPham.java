package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.sql.Date;

@Entity
@Table(name = "VuViPham")
public class VuViPham {

    @Id
    private String maVVP;
    
    private String tenVVP;
    
    private Date ngayXayRa;
    
    private String hinhThucXuLy;

    public VuViPham() {
    }

    public VuViPham(String maVVP, String tenVVP, Date ngayXayRa, String hinhThucXuLy) {
        this.maVVP = maVVP;
        this.tenVVP = tenVVP;
        this.ngayXayRa = ngayXayRa;
        this.hinhThucXuLy = hinhThucXuLy;
    }

    public String getMaVVP() {
        return maVVP;
    }

    public void setMaVVP(String maVVP) {
        this.maVVP = maVVP;
    }

    public String getTenVVP() {
        return tenVVP;
    }

    public void setTenVVP(String tenVVP) {
        this.tenVVP = tenVVP;
    }

    public Date getNgayXayRa() {
        return ngayXayRa;
    }

    public void setNgayXayRa(Date ngayXayRa) {
        this.ngayXayRa = ngayXayRa;
    }

    public String getHinhThucXuLy() {
        return hinhThucXuLy;
    }

    public void setHinhThucXuLy(String hinhThucXuLy) {
        this.hinhThucXuLy = hinhThucXuLy;
    }
}