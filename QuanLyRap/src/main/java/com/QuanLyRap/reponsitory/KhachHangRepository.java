package com.QuanLyRap.reponsitory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.QuanLyRap.domain.KhachHang;

@Repository
public interface KhachHangRepository extends JpaRepository<KhachHang, Long> {
    KhachHang findByIdkh(Long id);
    KhachHang findByTenKh(String tenKh);

    

}
