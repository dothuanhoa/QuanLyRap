package com.QuanLyRap.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

import java.time.LocalDateTime;
import java.util.List;

@Entity
public class LichChieu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idLichChieu;

    private LocalDateTime ngayChieu;

    @ManyToOne
    @JoinColumn(name = "idPhim") // idPhim là khóa ngoại liên kết với Phim
    private Phim phim;

    @OneToMany(mappedBy = "lichChieu")
    private List<Ve> veList;

    @OneToMany(mappedBy = "lichChieu")
    private List<SuatChieu> suatChieuList;

    @OneToMany(mappedBy = "lichChieu")
    private List<Ghe> gheList;

    @ManyToOne
    @JoinColumn(name = "idPhongChieu") // idPhongChieu là khóa ngoại liên kết với PhongChieu
    private PhongChieu phongChieu;

    public LichChieu() {
    }

    public List<SuatChieu> getSuatChieuList() {
        return suatChieuList;
    }

    public void setSuatChieuList(List<SuatChieu> suatChieuList) {
        this.suatChieuList = suatChieuList;
    }

    public List<Ghe> getGheList() {
        return gheList;
    }

    public void setGheList(List<Ghe> gheList) {
        this.gheList = gheList;
    }

    public int getIdLichChieu() {
        return idLichChieu;
    }

    public void setIdLichChieu(int idLichChieu) {
        this.idLichChieu = idLichChieu;
    }

    public LocalDateTime getNgayChieu() {
        return ngayChieu;
    }

    public void setNgayChieu(LocalDateTime ngayChieu) {
        this.ngayChieu = ngayChieu;
    }

    public Phim getPhim() {
        return phim;
    }

    public void setPhim(Phim phim) {
        this.phim = phim;
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

    @Override
    public String toString() {
        return "LichChieu [idLichChieu=" + idLichChieu + ", ngayChieu=" + ngayChieu + ", phim=" + phim + ", veList="
                + veList + ", phongChieu=" + phongChieu + "]";
    }

}
