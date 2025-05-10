package com.QuanLyRap.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class KhachHang {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String tenkh;
    private String sdt;
    private String email;
    private boolean giotinh;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public boolean isGiotinh() {
        return giotinh;
    }

    public void setGiotinh(boolean giotinh) {
        this.giotinh = giotinh;
    }

    @Override
    public String toString() {
        return "KhachHang [id=" + id + ", tenkh=" + tenkh + ", sdt=" + sdt + ", email=" + email + ", giotinh=" + giotinh
                + "]";
    }

}
