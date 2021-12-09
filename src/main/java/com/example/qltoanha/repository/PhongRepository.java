package com.example.qltoanha.repository;

import com.example.qltoanha.models.entity.NhanVienToaNha;
import com.example.qltoanha.models.entity.Phong;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhongRepository extends CrudRepository<Phong,Integer> {
    List<Phong>findAllByNameContaining(String ten);
    
    List<Phong>findAllByPriceIsLessThanEqual(int gia);
    
    List<Phong>findAllByPriceIsGreaterThanEqual(int gia);
    
    List<Phong>findAllByPriceIsLessThanEqualAndPriceIsGreaterThanEqual(int gia1, int gia2);
    
    @Query(value = "select * from tbl_phong where tbl_phong.ma_toa_nha = ?1 limit ?2,10", nativeQuery = true)
	List<Phong>findAllInPageByToaNha(int id,int index);
    
    @Query(value = "select * from tbl_phong where tbl_phong.ma_toa_nha = ?1", nativeQuery = true)
	List<Phong>findAllPhongByToaNha(int id);
}
