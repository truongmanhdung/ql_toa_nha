package com.example.qltoanha.repository;

import com.example.qltoanha.models.entity.PhongSuDung;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhongSuDungRepository extends CrudRepository<PhongSuDung,Integer> {
	
	@Query(value = "select * from tbl_phong_su_dung where ma_phong in (select id from tbl_phong where tbl_phong.ma_toa_nha = ?1)", nativeQuery = true)
	List<PhongSuDung>findAllByToaNha(int id);
}
