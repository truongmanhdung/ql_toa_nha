package com.example.qltoanha.repository;

import com.example.qltoanha.models.entity.NhanVienCongTy;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NVCongTyRepository extends CrudRepository<NhanVienCongTy,Integer> {

	@Query(value = "select * from tbl_nv_cty where tbl_nv_cty.ma_cong_ty = ?1", nativeQuery = true)
	List<NhanVienCongTy>findAllByCongTy(int id);
	
	@Query(value = "select * from tbl_nv_cty where tbl_nv_cty.ma_cong_ty = ?1 limit ?2,10", nativeQuery = true)
	List<NhanVienCongTy>findAllInPage(int id,int index);
	
	@Query(value = "select * from tbl_nv_cty where tbl_nv_cty.ma_cong_ty = ?1 and tbl_nv_cty.ten like %?2%", nativeQuery = true)
	List<NhanVienCongTy>findAllByTen(int id, String x);
	
}
