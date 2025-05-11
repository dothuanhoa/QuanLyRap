package com.QuanLyRap.domain;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class KhachHang {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idkh;

    private String tenkh;
    private String sdt;
    private String email;
    private LocalDate ngaysinh;
    private Boolean gioitinh;

    @ManyToOne
    @JoinColumn(name = "idtaikhoan")
    private TaiKhoan taiKhoan;

    @OneToMany(mappedBy = "khachHang")
    private List<HoaDon> hoaDons;

    @OneToMany(mappedBy = "khachHang")
    private List<Ve> veList;

    @OneToMany(mappedBy = "khachHang")
    private List<PhanHoi> phanHoiList;

    public KhachHang() {
    }

    public Long getIdkh() {
        return idkh;
    }

    public void setIdkh(Long idkh) {
        this.idkh = idkh;
    }

    public String getTenkh() {
        return tenkh;
    }

    public void setTenkh(String tenkh) {
        this.tenkh = tenkh;
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

    public TaiKhoan getTaiKhoan() {
        return taiKhoan;
    }

    public void setTaiKhoan(TaiKhoan taiKhoan) {
        this.taiKhoan = taiKhoan;
    }

    public List<HoaDon> getHoaDons() {
        return hoaDons;
    }

    public void setHoaDons(List<HoaDon> hoaDons) {
        this.hoaDons = hoaDons;
    }

    public List<Ve> getVeList() {
        return veList;
    }

    public void setVeList(List<Ve> veList) {
        this.veList = veList;
    }

    public List<PhanHoi> getPhanHoiList() {
        return phanHoiList;
    }

    public void setPhanHoiList(List<PhanHoi> phanHoiList) {
        this.phanHoiList = phanHoiList;
    }

    @Override
    public String toString() {
        return "KhachHang [idkh=" + idkh + ", tenkh=" + tenkh + ", sdt=" + sdt + ", email=" + email + ", ngaysinh="
                + ngaysinh + ", gioitinh=" + gioitinh + ", taiKhoan=" + taiKhoan + ", hoaDons=" + hoaDons + ", veList="
                + veList + ", phanHoiList=" + phanHoiList + "]";
    }

}
