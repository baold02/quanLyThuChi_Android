package com.example.quanlythuchi_android.Models;

public class KhoanNo {
    private String maKhoanNo;
    private String userName;
    private String soTienNo;
    private String ngayNo;
    private String ngayTra;
    private String chuThich;
    private String status;

    public KhoanNo() {
    }

    public KhoanNo(String maKhoanNo, String userName, String soTienNo, String ngayNo, String ngayTra, String chuThich, String status) {
        this.maKhoanNo = maKhoanNo;
        this.userName = userName;
        this.soTienNo = soTienNo;
        this.ngayNo = ngayNo;
        this.ngayTra = ngayTra;
        this.chuThich = chuThich;
        this.status = status;
    }

    public String getMaKhoanNo() {
        return maKhoanNo;
    }

    public void setMaKhoanNo(String maKhoanNo) {
        this.maKhoanNo = maKhoanNo;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getSoTienNo() {
        return soTienNo;
    }

    public void setSoTienNo(String soTienNo) {
        this.soTienNo = soTienNo;
    }

    public String getNgayNo() {
        return ngayNo;
    }

    public void setNgayNo(String ngayNo) {
        this.ngayNo = ngayNo;
    }

    public String getNgayTra() {
        return ngayTra;
    }

    public void setNgayTra(String ngayTra) {
        this.ngayTra = ngayTra;
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
