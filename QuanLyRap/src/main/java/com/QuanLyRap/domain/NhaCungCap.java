package com.QuanLyRap.domain;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class NhaCungCap {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idNCC;

    private String tenNCC;
    private String diaChi;
    private String sdt;

    @OneToMany(mappedBy = "nhaCungCap")
    private List<Phim> phimList;

    // Constructor không đối số
    public NhaCungCap() {
    }

    // Getters và Setters
    public int getIdNCC() {
        return idNCC;
    }

    public void setIdNCC(int idNCC) {
        this.idNCC = idNCC;
    }

    public String getTenNCC() {
        return tenNCC;
    }

    public void setTenNCC(String tenNCC) {
        this.tenNCC = tenNCC;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public List<Phim> getPhimList() {
        return phimList;
    }

    public void setPhimList(List<Phim> phimList) {
        this.phimList = phimList;
    }

    // toString method
    @Override
    public String toString() {
        return "NhaCungCap{" +
                "idNCC=" + idNCC +
                ", tenNCC='" + tenNCC + '\'' +
                ", diaChi='" + diaChi + '\'' +
                ", sdt='" + sdt + '\'' +
                ", phimList=" + phimList +
                '}';
    }
}
