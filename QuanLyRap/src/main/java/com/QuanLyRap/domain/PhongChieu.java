package com.QuanLyRap.domain;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class PhongChieu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPhongChieu;
    private String tenPhongChieu;

    @OneToOne(mappedBy = "phongChieu", cascade = CascadeType.ALL)
    private Phim phim;

    @ManyToOne
    @JoinColumn(name = "idRap") // idRap là khóa ngoại liên kết với Rap
    private Rap rap;

    // Constructor không đối số
    public PhongChieu() {
    }

    // Getters và Setters
    public int getIdPhongChieu() {
        return idPhongChieu;
    }

    public void setIdPhongChieu(int idPhongChieu) {
        this.idPhongChieu = idPhongChieu;
    }

    public String getTenPhongChieu() {
        return tenPhongChieu;
    }

    public void setTenPhongChieu(String tenPhongChieu) {
        this.tenPhongChieu = tenPhongChieu;
    }

    public Rap getRap() {
        return rap;
    }

    public void setRap(Rap rap) {
        this.rap = rap;
    }

    // toString
    @Override
    public String toString() {
        return "PhongChieu{" +
                "idPhongChieu=" + idPhongChieu +
                ", tenPhongChieu='" + tenPhongChieu + '\'' +

                ", rap=" + rap +
                '}';
    }

    public Phim getPhim() {
        return phim;
    }

    public void setPhim(Phim phim) {
        this.phim = phim;
    }

}
