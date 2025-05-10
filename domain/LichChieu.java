package com.QuanLyRap.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class LichChieu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idLichChieu;

    private LocalDateTime ngayChieu;
    private int idPhim;
    private int idSuatChieu;
    private int idPhong;

    // Getters and Setters
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

    public int getIdPhim() {
        return idPhim;
    }

    public void setIdPhim(int idPhim) {
        this.idPhim = idPhim;
    }

    public int getIdSuatChieu() {
        return idSuatChieu;
    }

    public void setIdSuatChieu(int idSuatChieu) {
        this.idSuatChieu = idSuatChieu;
    }

    public int getIdPhong() {
        return idPhong;
    }

    public void setIdPhong(int idPhong) {
        this.idPhong = idPhong;
    }

    // toString method
    @Override
    public String toString() {
        return "LichChieu [idLichChieu=" + idLichChieu + ", ngayChieu=" + ngayChieu + ", idPhim=" + idPhim
                + ", idSuatChieu=" + idSuatChieu + ", idPhong=" + idPhong + "]";
    }
}
