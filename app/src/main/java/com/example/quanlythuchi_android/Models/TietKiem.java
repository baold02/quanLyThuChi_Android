package com.example.quanlythuchi_android.Models;

public class TietKiem {
    private String maTietKiem;
    private String userName;
    private String soTienTietKiem;
    private String chuThich;
    private String status;

    public TietKiem() {
    }

    public TietKiem(String maTietKiem, String userName, String soTienTietKiem, String chuThich, String status) {
        this.maTietKiem = maTietKiem;
        this.userName = userName;
        this.soTienTietKiem = soTienTietKiem;
        this.chuThich = chuThich;
        this.status = status;
    }

    public String getMaTietKiem() {
        return maTietKiem;
    }

    public void setMaTietKiem(String maTietKiem) {
        this.maTietKiem = maTietKiem;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getSoTienTietKiem() {
        return soTienTietKiem;
    }

    public void setSoTienTietKiem(String soTienTietKiem) {
        this.soTienTietKiem = soTienTietKiem;
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
