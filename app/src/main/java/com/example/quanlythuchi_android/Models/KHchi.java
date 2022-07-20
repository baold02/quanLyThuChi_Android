package com.example.quanlythuchi_android.Models;

public class KHchi {
    private String maDuChi;
     private String useName;
     private String soTienDuChi;
     private String ngayDuChi;
     private String chuThich;
     private String status;

    public KHchi() {
    }

    public KHchi(String maDuChi, String useName, String soTienDuChi, String ngayDuChi, String chuThich, String status) {
        this.maDuChi = maDuChi;
        this.useName = useName;
        this.soTienDuChi = soTienDuChi;
        this.ngayDuChi = ngayDuChi;
        this.chuThich = chuThich;
        this.status = status;
    }

    public String getMaDuChi() {
        return maDuChi;
    }

    public void setMaDuChi(String maDuChi) {
        this.maDuChi = maDuChi;
    }

    public String getUseName() {
        return useName;
    }

    public void setUseName(String useName) {
        this.useName = useName;
    }

    public String getSoTienDuChi() {
        return soTienDuChi;
    }

    public void setSoTienDuChi(String soTienDuChi) {
        this.soTienDuChi = soTienDuChi;
    }

    public String getNgayDuChi() {
        return ngayDuChi;
    }

    public void setNgayDuChi(String ngayDuChi) {
        this.ngayDuChi = ngayDuChi;
    }

    public String getChuThich() {
        return chuThich;
    }

    public void setChuThich(String chuThich) {
        this.chuThich = chuThich;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
