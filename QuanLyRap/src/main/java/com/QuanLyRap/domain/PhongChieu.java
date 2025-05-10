package com.QuanLyRap.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class PhongChieu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPhongChieu;
    private String tenPhongChieu;
    private int soGhe;
    private int idRap;

    public int getIdPhongChieu() {
        return idPhongChieu;
    }

    public String getTenPhongChieu() {
        return tenPhongChieu;
    }

    public int getSoGhe() {
        return soGhe;
    }

    public int getIdRap() {
        return idRap;
    }

    public void setIdPhongChieu(int idPhongChieu) {
        this.idPhongChieu = idPhongChieu;
    }

    public void setTenPhongChieu(String tenPhongChieu) {
        this.tenPhongChieu = tenPhongChieu;
    }

    public void setSoGhe(int soGhe) {
        this.soGhe = soGhe;
    }

    public void setIdRap(int idRap) {
        this.idRap = idRap;
    }

    @Override
    public String toString() {
        return "PhongChieu [idPhongChieu=" + idPhongChieu + ", tenPhongChieu=" + tenPhongChieu + ", soGhe=" + soGhe
                + ", idRap=" + idRap + "]";
    }

    
}
