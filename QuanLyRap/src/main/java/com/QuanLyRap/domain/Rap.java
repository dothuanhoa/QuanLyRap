package com.QuanLyRap.domain;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Rap {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idRap;
    private String tenRap;
    private String diaChi;

    @OneToMany(mappedBy = "rap")
    private List<PhongChieu> phongChieuList;

    // Constructor không đối số
    public Rap() {
    }

    // Getters và Setters
    public int getIdRap() {
        return idRap;
    }

    public void setIdRap(int idRap) {
        this.idRap = idRap;
    }

    public String getTenRap() {
        return tenRap;
    }

    public void setTenRap(String tenRap) {
        this.tenRap = tenRap;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public List<PhongChieu> getPhongChieuList() {
        return phongChieuList;
    }

    public void setPhongChieuList(List<PhongChieu> phongChieuList) {
        this.phongChieuList = phongChieuList;
    }

    // toString
    @Override
    public String toString() {
        return "Rap{" +
                "idRap=" + idRap +
                ", tenRap='" + tenRap + '\'' +
                ", diaChi='" + diaChi + '\'' +
                ", phongChieuList=" + phongChieuList +
                '}';
    }
}
