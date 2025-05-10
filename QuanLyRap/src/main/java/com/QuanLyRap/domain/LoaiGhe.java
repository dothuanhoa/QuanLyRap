package com.QuanLyRap.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class LoaiGhe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idLoaiGhe;

    private String tenLoaiGhe;
    private int gia;
    private String moTa;

    // Getters and Setters
    public int getIdLoaiGhe() {
        return idLoaiGhe;
    }

    public void setIdLoaiGhe(int idLoaiGhe) {
        this.idLoaiGhe = idLoaiGhe;
    }

    public String getTenLoaiGhe() {
        return tenLoaiGhe;
    }

    public void setTenLoaiGhe(String tenLoaiGhe) {
        this.tenLoaiGhe = tenLoaiGhe;
    }

    public int getGia() {
        return gia;
    }

    public void setGia(int gia) {
        this.gia = gia;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    // toString method
    @Override
    public String toString() {
        return "LoaiGhe [idLoaiGhe=" + idLoaiGhe + ", tenLoaiGhe=" + tenLoaiGhe + ", gia=" + gia + ", moTa=" + moTa
                + "]";
    }
}
