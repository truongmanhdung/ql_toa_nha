package com.example.qltoanha.repository;

import com.example.qltoanha.models.entity.Phong;
import com.example.qltoanha.models.entity.PhongBan;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhongBanRepository extends CrudRepository<PhongBan,Integer> {

	@Query(value = "select * from tbl_phong_ban where tbl_phong_ban.toa_nha_id = ?1 limit ?2,10", nativeQuery = true)
	List<PhongBan>findAllInPageByToaNha(int id,int index);
    
    @Query(value = "select * from tbl_phong_ban where tbl_phong_ban.toa_nha_id = ?1", nativeQuery = true)
	List<PhongBan>findAllPhongByToaNha(int id);
    
    @Query(value = "select * from tbl_phong_ban limit ?1,10", nativeQuery = true)
	List<PhongBan>findAllPage(int id);
    
    List<PhongBan>findAllByTenContainingIgnoreCase(String key);
}
