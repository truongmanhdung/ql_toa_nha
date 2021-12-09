package com.example.qltoanha.repository;

import com.example.qltoanha.models.entity.ToaNha;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ToaNhaRepository extends CrudRepository<ToaNha,Integer> {

	List<ToaNha> findAllByNameContainingOrDiaChiContainingOrDescriptionContaining(String keyword, String keyword2,
			String keyword3);
	
	@Query(value = "select * from tbl_toa_nha limit ?1,10", nativeQuery = true)
	List<ToaNha> findAllInPage(int index);
	
	@Query(value = "select * from tbl_toa_nha where id in (select tbl_toa_nha.id from tbl_phong_ban where tbl_phong_ban.id = ?1)", nativeQuery = true)
	List<ToaNha> findByPhongBan(int index);
}
