package com.QuanLyRap.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class TaiKhoan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idtaikhoan;

    private String tentk;
    private String matkhau;
    private Boolean trangthai;

    @OneToOne(mappedBy = "taiKhoan")
    private NhanVien nhanVien;

    @OneToOne(mappedBy = "taiKhoan")
    private KhachHang khachHang;

    // Constructor không đối số
    public TaiKhoan() {}

    // Getters và Setters
    public Long getIdtaikhoan() {
        return idtaikhoan;
    }

    public void setIdtaikhoan(Long idtaikhoan) {
        this.idtaikhoan = idtaikhoan;
    }

    public String getTentk() {
        return tentk;
    }

    public void setTentk(String tentk) {
        this.tentk = tentk;
    }

    public String getMatkhau() {
        return matkhau;
    }

    public void setMatkhau(String matkhau) {
        this.matkhau = matkhau;
    }

    public Boolean getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(Boolean trangthai) {
        this.trangthai = trangthai;
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

    // toString
    @Override
    public String toString() {
        return "TaiKhoan{" +
                "idtaikhoan=" + idtaikhoan +
                ", tentk='" + tentk + '\'' +
                ", matkhau='" + matkhau + '\'' +
                ", trangthai=" + trangthai +
                ", nhanVien=" + nhanVien +
                ", khachHang=" + khachHang +
                '}';
    }
}
