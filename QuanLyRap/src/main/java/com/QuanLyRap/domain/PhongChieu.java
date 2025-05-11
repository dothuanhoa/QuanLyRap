package com.QuanLyRap.domain;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class PhongChieu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPhongChieu;
    private String tenPhongChieu;
    private int soGhe;

    @OneToMany(mappedBy = "phongChieu")
    private List<LichChieu> lichChieuList;

    @OneToMany(mappedBy = "phongChieu")
    private List<Ghe> gheList;

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

    public int getSoGhe() {
        return soGhe;
    }

    public void setSoGhe(int soGhe) {
        this.soGhe = soGhe;
    }

    public List<LichChieu> getLichChieuList() {
        return lichChieuList;
    }

    public void setLichChieuList(List<LichChieu> lichChieuList) {
        this.lichChieuList = lichChieuList;
    }

    public List<Ghe> getGheList() {
        return gheList;
    }

    public void setGheList(List<Ghe> gheList) {
        this.gheList = gheList;
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
                ", soGhe=" + soGhe +
                ", lichChieuList=" + lichChieuList +
                ", gheList=" + gheList +
                ", rap=" + rap +
                '}';
    }
}
