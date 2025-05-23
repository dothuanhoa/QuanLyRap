package com.QuanLyRap.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Phim {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPhim;
    private String tenPhim;
    private String noiDung;
    private int thoiLuong;

    @DateTimeFormat(pattern = "yyyy-MM-dd") // Định dạng ngày
    private LocalDate ngayChieu;
    private String daoDien;
    private String dienVien;
    private String ngonNgu;

    @OneToMany(mappedBy = "phim")
    private List<Ve> veList;

    @ManyToOne
    @JoinColumn(name = "idTheLoai") // idTheLoai là khóa ngoại liên kết với TheLoai
    private TheLoai theLoai;

    @OneToMany(mappedBy = "phim", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private Set<LichChieu> lichChieuList;

    @OneToOne
    @JoinColumn(name = "idPhongChieu") // Liên kết với PhongChieu
    private PhongChieu phongChieu;

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

    public Integer getIdPhim() {
        return idPhim;
    }

    public void setIdPhim(Integer idPhim) {
        this.idPhim = idPhim;
    }

    public PhongChieu getPhongChieu() {
        return phongChieu;
    }

    public void setPhongChieu(PhongChieu phongChieu) {
        this.phongChieu = phongChieu;
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

    public Set<LichChieu> getLichChieuList() {
        return lichChieuList;
    }

    public void setLichChieuList(Set<LichChieu> lichChieuList) {
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
                ", lichChieuList=" + lichChieuList +
                '}';
    }

    public LocalDate getNgayChieu() {
        return ngayChieu;
    }

    public void setNgayChieu(LocalDate ngayChieu) {
        this.ngayChieu = ngayChieu;
    }

    public List<LichChieu> getSortedLichChieuList() {
        List<LichChieu> list = new ArrayList<>(this.lichChieuList);
        // Sắp xếp tăng dần (ngày nhỏ lên đầu)
        list.sort(Comparator.comparing(LichChieu::getNgayChieu));
        return list;
    }
}
