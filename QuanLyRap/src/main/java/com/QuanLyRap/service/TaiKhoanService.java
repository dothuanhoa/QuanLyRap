// package com.QuanLyRap.service;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;

// import com.QuanLyRap.domain.TaiKhoan;
// import com.QuanLyRap.reponsitory.TaiKhoanRepository;

// @Service
// public class TaiKhoanService {

// @Autowired
// private TaiKhoanRepository taiKhoanRepository;

// // Kiểm tra tài khoản đã tồn tại hay chưa
// public boolean isTaiKhoanTonTai(String tentk) {
// return taiKhoanRepository.findByTentkAndMatkhau(tentk, null) != null;
// }

// // Đăng ký tài khoản
// public String dangKyTaiKhoan(TaiKhoan taiKhoan) {
// if (isTaiKhoanTonTai(taiKhoan.getTentk())) {
// return "Tài khoản đã tồn tại!";
// }
// taiKhoanRepository.save(taiKhoan);
// return "Đăng ký tài khoản thành công!";
// }

// // Đăng nhập tài khoản
// public String dangNhapTaiKhoan(String tentk, String matkhau) {
// TaiKhoan taiKhoan = taiKhoanRepository.findByTentkAndMatkhau(tentk, matkhau);
// if (taiKhoan == null) {
// return "Tên tài khoản hoặc mật khẩu không đúng!";
// }

// // Kiểm tra tài khoản thuộc về khách hàng hay nhân viên
// if (taiKhoan.getKhachHang() != null) {
// return "Đăng nhập thành công với vai trò Khách hàng!";
// } else if (taiKhoan.getNhanVien() != null) {
// return "Đăng nhập thành công với vai trò Nhân viên!";
// } else {
// return "Tài khoản không liên kết với Khách hàng hoặc Nhân viên!";
// }
// }
// }
