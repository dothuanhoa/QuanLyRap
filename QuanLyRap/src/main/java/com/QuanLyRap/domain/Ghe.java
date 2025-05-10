package com.QuanLyRap.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Ghe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idGhe;
    private String tenGhe;
    private boolean tinhTrang;
    private String idPhong;
    private String idLoaiGhe;

    public int getIdGhe() {
        return idGhe;
    }

    public void setIdGhe(int idGhe) {
        this.idGhe = idGhe;
    }

    public String getTenGhe() {
        return tenGhe;
    }

    public void setTenGhe(String tenGhe) {
        this.tenGhe = tenGhe;
    }

    public boolean isTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(boolean tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

    public String getIdPhong() {
        return idPhong;
    }

    public void setIdPhong(String idPhong) {
        this.idPhong = idPhong;
    }

    public String getIdLoaiGhe() {
        return idLoaiGhe;
    }

    public void setIdLoaiGhe(String idLoaiGhe) {
        this.idLoaiGhe = idLoaiGhe;
    }

    @Override
    public String toString() {
        return "Ghe [idGhe=" + idGhe + ", tenGhe=" + tenGhe + ", tinhTrang=" + tinhTrang + ", idPhong=" + idPhong
                + ", idLoaiGhe=" + idLoaiGhe + "]";
    }

}