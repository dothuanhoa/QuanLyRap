package com.QuanLyRap.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

import java.time.LocalDate;

@Entity
public class NhanVien {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idnv;

    private String tennv;
    private String sdt;
    private String email;
    private LocalDate ngaysinh;
    private Boolean gioitinh;
    private LocalDate ngaybatdau;

    @ManyToOne
    @JoinColumn(name = "macv")
    private ChucVu chucVu;

    @ManyToOne
    @JoinColumn(name = "idtaikhoan")
    private TaiKhoan taiKhoan;

    // Constructor không đối số
    public NhanVien() {
    }

    // Getters và Setters
    public Long getIdnv() {
        return idnv;
    }

    public void setIdnv(Long idnv) {
        this.idnv = idnv;
    }

    public String getTennv() {
        return tennv;
    }

    public void setTennv(String tennv) {
        this.tennv = tennv;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getNgaysinh() {
        return ngaysinh;
    }

    public void setNgaysinh(LocalDate ngaysinh) {
        this.ngaysinh = ngaysinh;
    }

    public Boolean getGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(Boolean gioitinh) {
        this.gioitinh = gioitinh;
    }

    public LocalDate getNgaybatdau() {
        return ngaybatdau;
    }

    public void setNgaybatdau(LocalDate ngaybatdau) {
        this.ngaybatdau = ngaybatdau;
    }

    public ChucVu getChucVu() {
        return chucVu;
    }

    public void setChucVu(ChucVu chucVu) {
        this.chucVu = chucVu;
    }

    public TaiKhoan getTaiKhoan() {
        return taiKhoan;
    }

    public void setTaiKhoan(TaiKhoan taiKhoan) {
        this.taiKhoan = taiKhoan;
    }

    // toString
    @Override
    public String toString() {
        return "NhanVien{" +
                "idnv=" + idnv +
                ", tennv='" + tennv + '\'' +
                ", sdt='" + sdt + '\'' +
                ", email='" + email + '\'' +
                ", ngaysinh=" + ngaysinh +
                ", gioitinh=" + gioitinh +
                ", ngaybatdau=" + ngaybatdau +
                ", chucVu=" + chucVu +
                ", taiKhoan=" + taiKhoan +
                '}';
    }
}
