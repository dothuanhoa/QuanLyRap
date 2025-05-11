package com.QuanLyRap.domain;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class TheLoai {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTheLoai;
    private String tenTheLoai;
    private String moTa;

    @OneToMany(mappedBy = "theLoai")
    private List<Phim> phimList;

    // Constructor không đối số
    public TheLoai() {
    }

    // Getters và Setters
    public int getIdTheLoai() {
        return idTheLoai;
    }

    public void setIdTheLoai(int idTheLoai) {
        this.idTheLoai = idTheLoai;
    }

    public String getTenTheLoai() {
        return tenTheLoai;
    }

    public void setTenTheLoai(String tenTheLoai) {
        this.tenTheLoai = tenTheLoai;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public List<Phim> getPhimList() {
        return phimList;
    }

    public void setPhimList(List<Phim> phimList) {
        this.phimList = phimList;
    }

    // toString
    @Override
    public String toString() {
        return "TheLoai{" +
                "idTheLoai=" + idTheLoai +
                ", tenTheLoai='" + tenTheLoai + '\'' +
                ", moTa='" + moTa + '\'' +
                ", phimList=" + phimList +
                '}';
    }
}
