package com.QuanLyRap.domain;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Ve {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idVe;
    private LocalDateTime thoiGianMua;
    private float giaVe;
    private String ghiChu;

    @ManyToOne
    @JoinColumn(name = "idkh") // idkh là khóa ngoại liên kết với KhachHang
    private KhachHang khachHang;

    @ManyToOne
    @JoinColumn(name = "idHoaDon") // idHoaDon là khóa ngoại liên kết với HoaDon
    private HoaDon hoaDon;

    @ManyToOne
    @JoinColumn(name = "idPhim") // idPhim là khóa ngoại liên kết với Phim
    private Phim phim;

    @ManyToOne
    @JoinColumn(name = "idLichChieu") // idLichChieu là khóa ngoại liên kết với LichChieu
    private LichChieu lichChieu;

    @ManyToOne
    @JoinColumn(name = "idGhe") // idGhe là khóa ngoại liên kết với Ghe
    private Ghe ghe;

    // Constructor không đối số
    public Ve() {
    }

    // Getters và Setters
    public int getIdVe() {
        return idVe;
    }

    public void setIdVe(int idVe) {
        this.idVe = idVe;
    }

    public LocalDateTime getThoiGianMua() {
        return thoiGianMua;
    }

    public void setThoiGianMua(LocalDateTime thoiGianMua) {
        this.thoiGianMua = thoiGianMua;
    }

    public float getGiaVe() {
        return giaVe;
    }

    public void setGiaVe(float giaVe) {
        this.giaVe = giaVe;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public KhachHang getKhachHang() {
        return khachHang;
    }

    public void setKhachHang(KhachHang khachHang) {
        this.khachHang = khachHang;
    }

    public HoaDon getHoaDon() {
        return hoaDon;
    }

    public void setHoaDon(HoaDon hoaDon) {
        this.hoaDon = hoaDon;
    }

    public Phim getPhim() {
        return phim;
    }

    public void setPhim(Phim phim) {
        this.phim = phim;
    }

    public LichChieu getLichChieu() {
        return lichChieu;
    }

    public void setLichChieu(LichChieu lichChieu) {
        this.lichChieu = lichChieu;
    }

    public Ghe getGhe() {
        return ghe;
    }

    public void setGhe(Ghe ghe) {
        this.ghe = ghe;
    }

    // toString
    @Override
    public String toString() {
        return "Ve{" +
                "idVe=" + idVe +
                ", thoiGianMua=" + thoiGianMua +
                ", giaVe=" + giaVe +
                ", ghiChu='" + ghiChu + '\'' +
                ", khachHang=" + khachHang +
                ", hoaDon=" + hoaDon +
                ", phim=" + phim +
                ", lichChieu=" + lichChieu +
                ", ghe=" + ghe +
                '}';
    }
}
