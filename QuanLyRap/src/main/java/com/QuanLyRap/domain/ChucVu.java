package com.QuanLyRap.domain;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class ChucVu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer macv;

    private String tencv;

    private Double luong;

    private String mota;

    @OneToMany(mappedBy = "chucVu")
    private List<NhanVien> nhanViens;
    public ChucVu() {
    }

    public Integer getMacv() {
        return macv;
    }

    public void setMacv(Integer macv) {
        this.macv = macv;
    }

    public String getTencv() {
        return tencv;
    }

    public void setTencv(String tencv) {
        this.tencv = tencv;
    }

    public Double getLuong() {
        return luong;
    }

    public void setLuong(Double luong) {
        this.luong = luong;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }

    public List<NhanVien> getNhanViens() {
        return nhanViens;
    }

    public void setNhanViens(List<NhanVien> nhanViens) {
        this.nhanViens = nhanViens;
    }

    @Override
    public String toString() {
        return "ChucVu [macv=" + macv + ", tencv=" + tencv + ", luong=" + luong + ", mota=" + mota + ", nhanViens="
                + nhanViens + "]";
    }

    
    

}