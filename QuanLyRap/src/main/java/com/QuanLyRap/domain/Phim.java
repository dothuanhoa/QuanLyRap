package com.QuanLyRap.domain;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Phim {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPhim;
    private String tenPhim;
    private String noiDung;
    private int thoiLuong;
    private String danhGia;
    private LocalDateTime ngayMua;
    private float giaMua;
    private int idTheLoai;
    private int idNcc;

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

    public String getDanhGia() {
        return danhGia;
    }

    public void setDanhGia(String danhGia) {
        this.danhGia = danhGia;
    }

    public LocalDateTime getNgayMua() {
        return ngayMua;
    }

    public void setNgayMua(LocalDateTime ngayMua) {
        this.ngayMua = ngayMua;
    }

    public float getGiaMua() {
        return giaMua;
    }

    public void setGiaMua(float giaMua) {
        this.giaMua = giaMua;
    }

    public int getIdTheLoai() {
        return idTheLoai;
    }

    public void setIdTheLoai(int idTheLoai) {
        this.idTheLoai = idTheLoai;
    }

    public int getIdNcc() {
        return idNcc;
    }

    public void setIdNcc(int idNcc) {
        this.idNcc = idNcc;
    }

    @Override
    public String toString() {
        return "Phim [idPhim=" + idPhim + ", tenPhim=" + tenPhim + ", noiDung=" + noiDung + ", thoiLuong=" + thoiLuong
                + ", danhGia=" + danhGia + ", ngayMua=" + ngayMua + ", giaMua=" + giaMua + ", idTheLoai=" + idTheLoai
                + ", idNcc=" + idNcc + "]";
    }

}
