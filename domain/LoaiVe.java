package com.QuanLyRap.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class LoaiVe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idLoaiVe;

    private String tenLoaiVe;
    private String moTa;

    // Getters and Setters
    public int getIdLoaiVe() {
        return idLoaiVe;
    }

    public void setIdLoaiVe(int idLoaiVe) {
        this.idLoaiVe = idLoaiVe;
    }

    public String getTenLoaiVe() {
        return tenLoaiVe;
    }

    public void setTenLoaiVe(String tenLoaiVe) {
        this.tenLoaiVe = tenLoaiVe;
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
        return "LoaiVe [idLoaiVe=" + idLoaiVe + ", tenLoaiVe=" + tenLoaiVe + ", moTa=" + moTa + "]";
    }
}
