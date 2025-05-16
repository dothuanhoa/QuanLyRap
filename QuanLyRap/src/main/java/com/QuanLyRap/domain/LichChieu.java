package com.QuanLyRap.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.CascadeType;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

@Entity
public class LichChieu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idLichChieu;

    private LocalDate ngayChieu;

    @ManyToOne
    @JoinColumn(name = "idPhim") // Liên kết với Phim
    private Phim phim;

    @OneToMany(mappedBy = "lichChieu", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<SuatChieu> suatChieuList;

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

    public Set<SuatChieu> getSuatChieuList() {
        return suatChieuList;
    }

    public void setSuatChieuList(Set<SuatChieu> suatChieuList) {
        this.suatChieuList = suatChieuList;
    }

    public List<SuatChieu> getSortedSuatChieuList() {
        List<SuatChieu> list = new ArrayList<>(this.suatChieuList);
        list.sort(Comparator.comparing(SuatChieu::getThoiGianBatDau));
        return list;
    }
}
