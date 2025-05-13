package com.QuanLyRap.domain;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Phim {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPhim;
    private String tenPhim;
    private String noiDung;
    private int thoiLuong;
    private LocalDateTime ngayChieu;
    private String daoDien;
    private String dienVien;
    private String ngonNgu;

    @OneToMany(mappedBy = "phim")
    private List<Ve> veList;

    @ManyToOne
    @JoinColumn(name = "idTheLoai") // idTheLoai là khóa ngoại liên kết với TheLoai
    private TheLoai theLoai;

    @ManyToOne
    @JoinColumn(name = "idNcc") // idNcc là khóa ngoại liên kết với NhaCungCap
    private NhaCungCap nhaCungCap;

    @OneToMany(mappedBy = "phim")
    private List<LichChieu> lichChieuList;

    // Constructor không đối số
    public Phim() {
    }

    // Getters và Setters
    public String getDaoDien() {
        return daoDien;
    }

    public void setDaoDien(String daoDien) {
        this.daoDien = daoDien;
    }

    public String getDienVien() {
        return dienVien;
    }

    public void setDienVien(String dienVien) {
        this.dienVien = dienVien;
    }

    public String getNgonNgu() {
        return ngonNgu;
    }

    public void setNgonNgu(String ngonNgu) {
        this.ngonNgu = ngonNgu;
    }

    public int getIdPhim() {
        return idPhim;
    }

    public void setIdPhim(int idPhim) {
        this.idPhim = idPhim;
    }

    public String getTenPhim() {
        return tenPhim;
    }

    public void setTenPhim(String tenPhim) {
        this.tenPhim = tenPhim;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    public int getThoiLuong() {
        return thoiLuong;
    }

    public void setThoiLuong(int thoiLuong) {
        this.thoiLuong = thoiLuong;
    }

    public List<Ve> getVeList() {
        return veList;
    }

    public void setVeList(List<Ve> veList) {
        this.veList = veList;
    }

    public TheLoai getTheLoai() {
        return theLoai;
    }

    public void setTheLoai(TheLoai theLoai) {
        this.theLoai = theLoai;
    }

    public NhaCungCap getNhaCungCap() {
        return nhaCungCap;
    }

    public void setNhaCungCap(NhaCungCap nhaCungCap) {
        this.nhaCungCap = nhaCungCap;
    }

    public List<LichChieu> getLichChieuList() {
        return lichChieuList;
    }

    public void setLichChieuList(List<LichChieu> lichChieuList) {
        this.lichChieuList = lichChieuList;
    }

    // toString
    @Override
    public String toString() {
        return "Phim{" +
                "idPhim=" + idPhim +
                ", tenPhim='" + tenPhim + '\'' +
                ", noiDung='" + noiDung + '\'' +
                ", thoiLuong=" + thoiLuong +
                ", ngayChieu=" + ngayChieu +

                ", veList=" + veList +
                ", theLoai=" + theLoai +
                ", nhaCungCap=" + nhaCungCap +
                ", lichChieuList=" + lichChieuList +
                '}';
    }

    public LocalDateTime getNgayChieu() {
        return ngayChieu;
    }

    public void setNgayChieu(LocalDateTime ngayChieu) {
        this.ngayChieu = ngayChieu;
    }
}
