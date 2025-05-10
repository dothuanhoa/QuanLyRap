package com.QuanLyRap.domain;

import java.time.LocalDateTime;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Ve {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idVe;
    private LocalDateTime thoiGianMua;
    private float giaVe;
    private int idPhim;
    private int id;
    private int idLichChieu;
    private int idHoaDon;
    private int idLoaiVe;
    private int idGhe;
    private String ghiChu;
    public int getIdVe() {
        return idVe;
    }
    public float getGiaVe() {
        return giaVe;
    }
    public int getIdPhim() {
        return idPhim;
    }
    public int getId() {
        return id;
    }
    public int getIdLichChieu() {
        return idLichChieu;
    }
    public int getIdHoaDon() {
        return idHoaDon;
    }
    public int getIdLoaiVe() {
        return idLoaiVe;
    }
    public int getIdGhe() {
        return idGhe;
    }
    public String getGhiChu() {
        return ghiChu;
    }
    public void setIdVe(int idVe) {
        this.idVe = idVe;
    }
    public void setGiaVe(float giaVe) {
        this.giaVe = giaVe;
    }
    public void setIdPhim(int idPhim) {
        this.idPhim = idPhim;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setIdLichChieu(int idLichChieu) {
        this.idLichChieu = idLichChieu;
    }
    public void setIdHoaDon(int idHoaDon) {
        this.idHoaDon = idHoaDon;
    }
    public void setIdLoaiVe(int idLoaiVe) {
        this.idLoaiVe = idLoaiVe;
    }
    public void setIdGhe(int idGhe) {
        this.idGhe = idGhe;
    }
    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }
    
     public LocalDateTime getThoiGianMua() {
        return thoiGianMua;
    }
    public void setThoiGianMua(LocalDateTime thoiGianMua) {
        this.thoiGianMua = thoiGianMua;
    }
    @Override
    public String toString() {
        return "Ve [idVe=" + idVe + ", giaVe=" + giaVe + ", idPhim=" + idPhim + ", id=" + id + ", idLichChieu="
                + idLichChieu + ", idHoaDon=" + idHoaDon + ", idLoaiVe=" + idLoaiVe + ", idGhe=" + idGhe + ", ghiChu="
                + ghiChu + "]";
    }
    

}
