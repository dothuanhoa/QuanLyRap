package com.QuanLyRap.domain;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class HoaDon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idHoaDon;
    private LocalDateTime ngaylapHD;
    private int id;
    private String idNV;
    private String loaiThanhToan;

    public int getIdHoaDon() {
        return idHoaDon;
    }

    public void setIdHoaDon(int idHoaDon) {
        this.idHoaDon = idHoaDon;
    }

    public LocalDateTime getNgaylapHD() {
        return ngaylapHD;
    }

    public void setNgaylapHD(LocalDateTime ngaylapHD) {
        this.ngaylapHD = ngaylapHD;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIdNV() {
        return idNV;
    }

    public void setIdNV(String idNV) {
        this.idNV = idNV;
    }

    public String getLoaiThanhToan() {
        return loaiThanhToan;
    }

    public void setLoaiThanhToan(String loaiThanhToan) {
        this.loaiThanhToan = loaiThanhToan;
    }

    @Override
    public String toString() {
        return "HoaDon [idHoaDon=" + idHoaDon + ", ngaylapHD=" + ngaylapHD + ", id=" + id + ", idNV=" + idNV
                + ", loaiThanhToan=" + loaiThanhToan + "]";
    }
}
