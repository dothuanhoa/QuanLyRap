package com.QuanLyRap.domain;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class HoaDon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idhoadon;

    private LocalDate ngaylaphd;

    private int tongtien;

    private String ghiChu;

    @ManyToOne
    @JoinColumn(name = "idnv")
    private NhanVien nhanVien;

    @ManyToOne
    @JoinColumn(name = "idkh")
    private KhachHang khachHang;

    @OneToMany(mappedBy = "hoaDon", cascade = CascadeType.ALL)
    private List<Ve> veList;

    public HoaDon() {
    }

    public Long getIdhoadon() {
        return idhoadon;
    }

    public void setIdhoadon(Long idhoadon) {
        this.idhoadon = idhoadon;
    }

    public LocalDate getNgaylaphd() {
        return ngaylaphd;
    }

    public void setNgaylaphd(LocalDate ngaylaphd) {
        this.ngaylaphd = ngaylaphd;
    }

    public NhanVien getNhanVien() {
        return nhanVien;
    }

    public void setNhanVien(NhanVien nhanVien) {
        this.nhanVien = nhanVien;
    }

    public KhachHang getKhachHang() {
        return khachHang;
    }

    public void setKhachHang(KhachHang khachHang) {
        this.khachHang = khachHang;
    }

    public List<Ve> getVeList() {
        return veList;
    }

    public void setVeList(List<Ve> veList) {
        this.veList = veList;
    }

    @Override
    public String toString() {
        return "HoaDon [idhoadon=" + idhoadon + ", ngaylaphd=" + ngaylaphd + ", ghiChu=" + ghiChu
                + ", nhanVien=" + nhanVien + ", khachHang=" + khachHang + ", veList=" + veList + "]";
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public int getTongtien() {
        return tongtien;
    }

    public void setTongtien(int tongtien) {
        this.tongtien = tongtien;
    }
}