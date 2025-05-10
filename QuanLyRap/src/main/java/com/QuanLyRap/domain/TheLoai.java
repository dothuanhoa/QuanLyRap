package com.QuanLyRap.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class TheLoai {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTheLoai;
    private String tenTheLoai;
    private String moTa;
    
    public int getIdTheLoai() {
        return idTheLoai;
    }
    public String getTenTheLoai() {
        return tenTheLoai;
    }
    public String getMoTa() {
        return moTa;
    }
    public void setIdTheLoai(int idTheLoai) {
        this.idTheLoai = idTheLoai;
    }
    public void setTenTheLoai(String tenTheLoai) {
        this.tenTheLoai = tenTheLoai;
    }
    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }
    @Override
    public String toString() {
        return "TheLoai [idTheLoai=" + idTheLoai + ", tenTheLoai=" + tenTheLoai + ", moTa=" + moTa + "]";
    }

    
}
