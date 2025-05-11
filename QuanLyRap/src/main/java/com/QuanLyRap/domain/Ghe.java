package com.QuanLyRap.domain;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Ghe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idGhe;
    private String tenGhe;
    private boolean tinhTrang;

    @OneToMany(mappedBy = "ghe")
    private List<Ve> veList;

    @ManyToOne
    @JoinColumn(name = "idPhongChieu") // idPhongChieu là khóa ngoại liên kết với PhongChieu
    private PhongChieu phongChieu;

    @ManyToOne
    @JoinColumn(name = "idLoaiGhe") // idLoaiGhe là khóa ngoại liên kết với LoaiGhe
    private LoaiGhe loaiGhe;

    public Ghe() {
    }

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

    public List<Ve> getVeList() {
        return veList;
    }

    public void setVeList(List<Ve> veList) {
        this.veList = veList;
    }

    public PhongChieu getPhongChieu() {
        return phongChieu;
    }

    public void setPhongChieu(PhongChieu phongChieu) {
        this.phongChieu = phongChieu;
    }

    public LoaiGhe getLoaiGhe() {
        return loaiGhe;
    }

    public void setLoaiGhe(LoaiGhe loaiGhe) {
        this.loaiGhe = loaiGhe;
    }

    @Override
    public String toString() {
        return "Ghe [idGhe=" + idGhe + ", tenGhe=" + tenGhe + ", tinhTrang=" + tinhTrang + ", veList=" + veList
                + ", phongChieu=" + phongChieu + ", loaiGhe=" + loaiGhe + "]";
    }

}