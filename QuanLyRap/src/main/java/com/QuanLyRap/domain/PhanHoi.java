package com.QuanLyRap.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class PhanHoi {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPhanHoi;

    private String noiDung;
    private String email;

    @ManyToOne
    @JoinColumn(name = "idkh") // idkh là khóa ngoại liên kết với KhachHang
    private KhachHang khachHang;

    // Constructor không đối số
    public PhanHoi() {
    }

    // Getters và Setters
    public int getIdPhanHoi() {
        return idPhanHoi;
    }

    public void setIdPhanHoi(int idPhanHoi) {
        this.idPhanHoi = idPhanHoi;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public KhachHang getKhachHang() {
        return khachHang;
    }

    public void setKhachHang(KhachHang khachHang) {
        this.khachHang = khachHang;
    }

    // toString
    @Override
    public String toString() {
        return "PhanHoi{" +
                "idPhanHoi=" + idPhanHoi +
                ", noiDung='" + noiDung + '\'' +
                ", email='" + email + '\'' +
                ", khachHang=" + khachHang +
                +'}';
    }
}