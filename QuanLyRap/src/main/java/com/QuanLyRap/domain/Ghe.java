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

    @ManyToOne
    @JoinColumn(name = "idSuatChieu") // Liên kết với SuatChieu
    private SuatChieu suatChieu;

    @ManyToOne
    @JoinColumn(name = "idLoaiGhe") // Liên kết với LoaiGhe
    private LoaiGhe loaiGhe;

    // Getters và Setters
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

    public SuatChieu getSuatChieu() {
        return suatChieu;
    }

    public void setSuatChieu(SuatChieu suatChieu) {
        this.suatChieu = suatChieu;
    }

    public LoaiGhe getLoaiGhe() {
        return loaiGhe;
    }

    public void setLoaiGhe(LoaiGhe loaiGhe) {
        this.loaiGhe = loaiGhe;
    }
}