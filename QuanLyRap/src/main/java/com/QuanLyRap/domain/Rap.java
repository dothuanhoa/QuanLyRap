package com.QuanLyRap.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Rap {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idRap;
    private String tenRap;
    private String diaChi;

    public int getIdRap() {
        return idRap;
    }

    public String getTenRap() {
        return tenRap;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setIdRap(int idRap) {
        this.idRap = idRap;
    }

    public void setTenRap(String tenRap) {
        this.tenRap = tenRap;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    @Override
    public String toString() {
        return "Rap [idRap=" + idRap + ", tenRap=" + tenRap + ", diaChi=" + diaChi + "]";
    }

}
