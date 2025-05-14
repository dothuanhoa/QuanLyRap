package com.QuanLyRap.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.CascadeType;
import java.util.List;

@Entity
public class SuatChieu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idSuatChieu;

    private String thoiGianBatDau;

    @ManyToOne
    @JoinColumn(name = "idLichChieu") // Liên kết với LichChieu
    private LichChieu lichChieu;

    @OneToMany(mappedBy = "suatChieu", cascade = CascadeType.ALL)
    private List<Ghe> gheList;

    // Getters và Setters
    public int getIdSuatChieu() {
        return idSuatChieu;
    }

    public void setIdSuatChieu(int idSuatChieu) {
        this.idSuatChieu = idSuatChieu;
    }

    public String getThoiGianBatDau() {
        return thoiGianBatDau;
    }

    public void setThoiGianBatDau(String thoiGianBatDau) {
        this.thoiGianBatDau = thoiGianBatDau;
    }

    public LichChieu getLichChieu() {
        return lichChieu;
    }

    public void setLichChieu(LichChieu lichChieu) {
        this.lichChieu = lichChieu;
    }

    public List<Ghe> getGheList() {
        return gheList;
    }

    public void setGheList(List<Ghe> gheList) {
        this.gheList = gheList;
    }
}
