package com.example.qltoanha.repository;

import com.example.qltoanha.models.entity.GhiChu;
import com.example.qltoanha.models.entity.NhanVienCongTy;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GhiChuRepository extends CrudRepository<GhiChu,Integer> {
	
	@Query(value = "select * from tbl_ghi_chu where tbl_ghi_chu.ma_nv = ?1", nativeQuery = true)
	List<GhiChu>findAllByNhanVien(int id);
	
	@Query(value = "select * from tbl_ghi_chu where tbl_ghi_chu.ma_nv = ?1 limit ?2,10", nativeQuery = true)
	List<GhiChu>findAllInPage(int id,int index);
	
	@Query(value = "select * from tbl_ghi_chu where tbl_ghi_chu.ma_nv = ?1 and tbl_ghi_chu.ly_do like %?2%", nativeQuery = true)
	List<GhiChu>findAllByLiDo(int id, String x);
	
	@Query(value = "select count(*) from tbl_ghi_chu where tbl_ghi_chu.ma_nv = ?1 and tbl_ghi_chu.status like ?2 and (tbl_ghi_chu.ngay_tao between ?3 and ?4)", nativeQuery = true)
	int countStatusByNhanVien(int id, String status, Date start, Date end);
	
}
