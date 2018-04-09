package com.example.tranxuantung.moneymanager.DoiTuong;

public class DTTaiKhoan {
    private long date;
    private String taikhoan, danhmuc, doituong, ghichu;
    private double sotien;

    public DTTaiKhoan() {
    }

    public long getDate() {

        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public String getTaikhoan() {
        return taikhoan;
    }

    public void setTaikhoan(String taikhoan) {
        this.taikhoan = taikhoan;
    }

    public String getDanhmuc() {
        return danhmuc;
    }

    public void setDanhmuc(String danhmuc) {
        this.danhmuc = danhmuc;
    }

    public String getDoituong() {
        return doituong;
    }

    public void setDoituong(String doituong) {
        this.doituong = doituong;
    }

    public String getGhichu() {
        return ghichu;
    }

    public void setGhichu(String ghichu) {
        this.ghichu = ghichu;
    }

    public double getSotien() {
        return sotien;
    }

    public void setSotien(double sotien) {
        this.sotien = sotien;
    }

    public DTTaiKhoan(long date, String taikhoan, String danhmuc, double sotien, String doituong, String ghichu) {

        this.date = date;
        this.taikhoan = taikhoan;
        this.danhmuc = danhmuc;
        this.doituong = doituong;
        this.ghichu = ghichu;
        this.sotien = sotien;
    }
}
