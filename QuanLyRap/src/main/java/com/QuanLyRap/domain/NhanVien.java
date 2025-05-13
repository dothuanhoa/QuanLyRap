package com.QuanLyRap.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

import java.time.LocalDate;
import java.util.List;

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
    private String matkhau;

    @OneToMany(mappedBy = "nhanVien")
    private List<HoaDon> hoaDons;

    public List<HoaDon> getHoaDons() {
        return hoaDons;
    }

    @ManyToOne
    @JoinColumn(name = "idRole")
    private Role role;

    public void setHoaDons(List<HoaDon> hoaDons) {
        this.hoaDons = hoaDons;
    }

    // Constructor không đối số
    public NhanVien() {
        this.role = new Role();
        this.role.setIdRole(3);
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

    @Override
    public String toString() {
        return "NhanVien [idnv=" + idnv + ", tennv=" + tennv + ", sdt=" + sdt + ", email=" + email + ", ngaysinh="
                + ngaysinh + ", gioitinh=" + gioitinh + ", ngaybatdau=" + ngaybatdau
                + ", hoaDons=" + hoaDons + "]";
    }

    public String getMatkhau() {
        return matkhau;
    }

    public void setMatkhau(String matkhau) {
        this.matkhau = matkhau;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
