package com.QuanLyRap.domain;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Phim {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPhim;
    private String tenPhim;
    private String noiDung;
    private int thoiLuong;
    private String danhGia;
    private LocalDateTime ngayMua;
    private float giaMua;

    @OneToOne(mappedBy = "phim")
    private PhanHoi phanHoi;

    @OneToMany(mappedBy = "phim")
    private List<Ve> veList;

    @ManyToOne
    @JoinColumn(name = "idTheLoai") // idTheLoai là khóa ngoại liên kết với TheLoai
    private TheLoai theLoai;

    @ManyToOne
    @JoinColumn(name = "idNcc") // idNcc là khóa ngoại liên kết với NhaCungCap
    private NhaCungCap nhaCungCap;

    @OneToMany(mappedBy = "phim")
    private List<LichChieu> lichChieuList;

    // Constructor không đối số
    public Phim() {
    }

    // Getters và Setters
    public int getIdPhim() {
        return idPhim;
    }

    public void setIdPhim(int idPhim) {
        this.idPhim = idPhim;
    }

    public String getTenPhim() {
        return tenPhim;
    }

    public void setTenPhim(String tenPhim) {
        this.tenPhim = tenPhim;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    public int getThoiLuong() {
        return thoiLuong;
    }

    public void setThoiLuong(int thoiLuong) {
        this.thoiLuong = thoiLuong;
    }

    public String getDanhGia() {
        return danhGia;
    }

    public void setDanhGia(String danhGia) {
        this.danhGia = danhGia;
    }

    public LocalDateTime getNgayMua() {
        return ngayMua;
    }

    public void setNgayMua(LocalDateTime ngayMua) {
        this.ngayMua = ngayMua;
    }

    public float getGiaMua() {
        return giaMua;
    }

    public void setGiaMua(float giaMua) {
        this.giaMua = giaMua;
    }

    public PhanHoi getPhanHoi() {
        return phanHoi;
    }

    public void setPhanHoi(PhanHoi phanHoi) {
        this.phanHoi = phanHoi;
    }

    public List<Ve> getVeList() {
        return veList;
    }

    public void setVeList(List<Ve> veList) {
        this.veList = veList;
    }

    public TheLoai getTheLoai() {
        return theLoai;
    }

    public void setTheLoai(TheLoai theLoai) {
        this.theLoai = theLoai;
    }

    public NhaCungCap getNhaCungCap() {
        return nhaCungCap;
    }

    public void setNhaCungCap(NhaCungCap nhaCungCap) {
        this.nhaCungCap = nhaCungCap;
    }

    public List<LichChieu> getLichChieuList() {
        return lichChieuList;
    }

    public void setLichChieuList(List<LichChieu> lichChieuList) {
        this.lichChieuList = lichChieuList;
    }

    // toString
    @Override
    public String toString() {
        return "Phim{" +
                "idPhim=" + idPhim +
                ", tenPhim='" + tenPhim + '\'' +
                ", noiDung='" + noiDung + '\'' +
                ", thoiLuong=" + thoiLuong +
                ", danhGia='" + danhGia + '\'' +
                ", ngayMua=" + ngayMua +
                ", giaMua=" + giaMua +
                ", phanHoi=" + phanHoi +
                ", veList=" + veList +
                ", theLoai=" + theLoai +
                ", nhaCungCap=" + nhaCungCap +
                ", lichChieuList=" + lichChieuList +
                '}';
    }
}
