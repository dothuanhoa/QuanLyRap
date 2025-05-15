package com.QuanLyRap.domain;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class LoaiGhe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idLoaiGhe;

    private String tenLoaiGhe;
    private int gia;
    private String moTa;

    @OneToMany(mappedBy = "loaiGhe")
    private List<Ghe> gheList;

    // Constructor không đối số
    public LoaiGhe() {
    }

    public LoaiGhe(int idLoaiGhe) {
        this.idLoaiGhe = idLoaiGhe;
    }

    // Getter và Setter cho các thuộc tính khác
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

    // Getter và Setter cho gheList
    public List<Ghe> getGheList() {
        return gheList;
    }

    public void setGheList(List<Ghe> gheList) {
        this.gheList = gheList;
    }

    // toString
    @Override
    public String toString() {
        return "LoaiGhe{" +
                "idLoaiGhe=" + idLoaiGhe +
                ", tenLoaiGhe='" + tenLoaiGhe + '\'' +
                ", gia=" + gia +
                ", moTa='" + moTa + '\'' +
                ", gheList=" + gheList +
                '}';
    }
}
