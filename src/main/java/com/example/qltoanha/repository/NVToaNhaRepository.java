package com.example.qltoanha.repository;

import com.example.qltoanha.models.entity.CongTy;
import com.example.qltoanha.models.entity.NhanVienCongTy;
import com.example.qltoanha.models.entity.NhanVienToaNha;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NVToaNhaRepository extends CrudRepository<NhanVienToaNha,Integer> {
	
    @Query(value = "select * from tbl_nv_toa_nha limit ?1,10", nativeQuery = true)
    List<NhanVienToaNha>findAllInPage(int index);
    
    List<NhanVienToaNha>findAllByTenContainingIgnoreCase(String key);
    
    @Query(value = "select * from tbl_nv_toa_nha where tbl_nv_toa_nha.ma_phong_ban in (select id from tbl_phong_ban where tbl_phong_ban.toa_nha_id = ?1) limit ?2,10", nativeQuery = true)
	List<NhanVienToaNha>findAllInPage(int id,int index);
    
    @Query(value = "select * from tbl_nv_toa_nha where tbl_nv_toa_nha.ma_phong_ban in (select id from tbl_phong_ban where tbl_phong_ban.toa_nha_id = ?1)" , nativeQuery = true)
	List<NhanVienToaNha>findAllByToaNha(int id);
}
