package com.example.qltoanha.repository;

import com.example.qltoanha.models.entity.HopDong;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HopDongRepository extends CrudRepository<HopDong,Integer> {
	
	@Query(value="select * from tbl_hop_dong where tbl_hop_dong.ma_toa_nha = ?1 ",nativeQuery = true)
	List<HopDong>findAllByToaNha(int id);
	
	@Query(value = "select * from tbl_hop_dong where tbl_hop_dong.ma_toa_nha = ?1 and ?2 between tbl_hop_dong.ngay_tao and tbl_hop_dong.ngay_het_han",nativeQuery = true)
	List<HopDong>searchByToaNha(int id,Date date);
	
	@Query(value = "select * from tbl_hop_dong where tbl_hop_dong.ma_toa_nha = ?1 limit ?2,10",nativeQuery = true)
	List<HopDong>findAllInPageByToaNha(int id,int index);
}
