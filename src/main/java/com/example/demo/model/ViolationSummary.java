package com.example.demo.model;

import java.sql.Date;

public class ViolationSummary {
    private String maVVP;
    private String tenVVP;
    private Date ngayXayRa;
    private String hinhThucXuLy;
    private String mucDo;
    private String tenNS;
    private String xuatXu;

    public ViolationSummary(String maVVP, String tenVVP, Date ngayXayRa, String hinhThucXuLy, String mucDo, String tenNS, String xuatXu) {
        this.maVVP = maVVP;
        this.tenVVP = tenVVP;
        this.ngayXayRa = ngayXayRa;
        this.hinhThucXuLy = hinhThucXuLy;
        this.mucDo = mucDo;
        this.tenNS = tenNS;
        this.xuatXu = xuatXu;
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

    public String getMucDo() {
        return mucDo;
    }

    public void setMucDo(String mucDo) {
        this.mucDo = mucDo;
    }

    public String getTenNS() {
        return tenNS;
    }

    public void setTenNS(String tenNS) {
        this.tenNS = tenNS;
    }

    public String getXuatXu() {
        return xuatXu;
    }

    public void setXuatXu(String xuatXu) {
        this.xuatXu = xuatXu;
    }
    
}