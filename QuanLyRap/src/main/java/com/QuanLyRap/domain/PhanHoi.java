package com.QuanLyRap.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class PhanHoi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPhanHoi;
    private String noiDung;
    private String id;
    private String email;

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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "PhanHoi [idPhanHoi=" + idPhanHoi + ", noiDung=" + noiDung + ", id=" + id + ", email=" + email + "]";
    }

}
