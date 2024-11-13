package com.example.demo5;

import java.time.LocalDate;
import java.util.Date;

public class PhongTro {
    int id;
    String name;
    String sodienthoai;
    LocalDate ngaythue;
    String ghichu;
    private PhuongThuc phuongthuc;

    public PhongTro(int id, String name, String sodienthoai, LocalDate ngaythue, String ghichu, PhuongThuc phuongthuc) {
        this.id = id;
        this.name = name;
        this.sodienthoai = sodienthoai;
        this.ngaythue = ngaythue;
        this.ghichu = ghichu;
        this.phuongthuc = phuongthuc;
    }

    public PhongTro(int id, String name, String sodienthoai, LocalDate ngaythue, String ghichu) {
        this.id = id;
        this.name = name;
        this.sodienthoai = sodienthoai;
        this.ngaythue = ngaythue;
        this.ghichu = ghichu;
    }

    public PhongTro(String name, String sodienthoai, LocalDate ngaythue, String ghichu, PhuongThuc phuongthuc) {
        this.name = name;
        this.sodienthoai = sodienthoai;
        this.ngaythue = ngaythue;
        this.ghichu = ghichu;
        this.phuongthuc = phuongthuc;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSodienthoai() {
        return sodienthoai;
    }

    public void setSodienthoai(String sodienthoai) {
        this.sodienthoai = sodienthoai;
    }

    public LocalDate getNgaythue() {
        return ngaythue;
    }

    public void setNgaythue(LocalDate ngaythue) {
        this.ngaythue = ngaythue;
    }

    public String getGhichu() {
        return ghichu;
    }

    public void setGhichu(String ghichu) {
        this.ghichu = ghichu;
    }

    public PhuongThuc getPhuongthuc() {
        return phuongthuc;
    }

    public void setPhuongthuc(PhuongThuc phuongthuc) {
        this.phuongthuc = phuongthuc;
    }
}
