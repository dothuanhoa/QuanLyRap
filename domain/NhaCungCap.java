package com.QuanLyRap.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class NhaCungCap {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idNCC;

    private String tenNCC;
    private String diaChi;
    private String sdt;

    // Getters and Setters
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

    // toString method
    @Override
    public String toString() {
        return "NhaCungCap [idNCC=" + idNCC + ", tenNCC=" + tenNCC + ", diaChi=" + diaChi + ", sdt=" + sdt + "]";
    }
}
