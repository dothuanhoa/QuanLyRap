package com.QuanLyRap.domain;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idRole;
    private String rolename;

    @OneToMany(mappedBy = "role")
    private List<KhachHang> khachHangList;

    @OneToMany(mappedBy = "role")
    private List<NhanVien> NhanVienList;

    public List<KhachHang> getKhachHangList() {
        return khachHangList;
    }

    public void setKhachHangList(List<KhachHang> khachHangList) {
        this.khachHangList = khachHangList;
    }

    public List<NhanVien> getNhanVienList() {
        return NhanVienList;
    }

    public void setNhanVienList(List<NhanVien> nhanVienList) {
        NhanVienList = nhanVienList;
    }

    public int getIdRole() {
        return idRole;
    }

    public void setIdRole(int idRole) {
        this.idRole = idRole;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }

    @Override
    public String toString() {
        return "Role [idRole=" + idRole + ", rolename=" + rolename + "]";
    }
}
