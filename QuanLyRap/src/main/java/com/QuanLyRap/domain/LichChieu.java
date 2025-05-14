package com.QuanLyRap.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.CascadeType;

import java.time.LocalDate;
import java.util.List;

@Entity
public class LichChieu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idLichChieu;

    private LocalDate ngayChieu;

    @ManyToOne
    @JoinColumn(name = "idPhim") // Liên kết với Phim
    private Phim phim;

    @OneToMany(mappedBy = "lichChieu", cascade = CascadeType.ALL)
    private List<SuatChieu> suatChieuList;

    // Getters và Setters
    public int getIdLichChieu() {
        return idLichChieu;
    }

    public void setIdLichChieu(int idLichChieu) {
        this.idLichChieu = idLichChieu;
    }

    public LocalDate getNgayChieu() {
        return ngayChieu;
    }

    public void setNgayChieu(LocalDate ngayChieu) {
        this.ngayChieu = ngayChieu;
    }

    public Phim getPhim() {
        return phim;
    }

    public void setPhim(Phim phim) {
        this.phim = phim;
    }

    public List<SuatChieu> getSuatChieuList() {
        return suatChieuList;
    }

    public void setSuatChieuList(List<SuatChieu> suatChieuList) {
        this.suatChieuList = suatChieuList;
    }
}
