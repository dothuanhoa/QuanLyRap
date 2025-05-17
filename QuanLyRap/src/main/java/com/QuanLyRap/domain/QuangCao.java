package com.QuanLyRap.domain;

import jakarta.persistence.*;

@Entity
public class QuangCao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idqc;

    private String tenqc;
    private Integer slgiam;

    // Constructors
    public QuangCao() {}

    public QuangCao(String tenqc, Integer slgiam) {
        this.tenqc = tenqc;
        this.slgiam = slgiam;
    }

    // Getters and Setters
    public Integer getIdqc() {
        return idqc;
    }

    public void setIdqc(Integer idqc) {
        this.idqc = idqc;
    }

    public String getTenqc() {
        return tenqc;
    }

    public void setTenqc(String tenqc) {
        this.tenqc = tenqc;
    }

    public Integer getSlgiam() {
        return slgiam;
    }

    public void setSlgiam(Integer slgiam) {
        this.slgiam = slgiam;
    }
}