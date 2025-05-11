package com.QuanLyRap.domain;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class LoaiVe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idLoaiVe;

    private String tenLoaiVe;
    private String moTa;

    @OneToMany(mappedBy = "loaiVe")
    private List<Ve> veList;

    // Constructor không đối số
    public LoaiVe() {
    }

    // Getter và Setter
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

    public List<Ve> getVeList() {
        return veList;
    }

    public void setVeList(List<Ve> veList) {
        this.veList = veList;
    }

    // toString
    @Override
    public String toString() {
        return "LoaiVe{" +
                "idLoaiVe=" + idLoaiVe +
                ", tenLoaiVe='" + tenLoaiVe + '\'' +
                ", moTa='" + moTa + '\'' +
                ", veList=" + veList +
                '}';
    }
}
