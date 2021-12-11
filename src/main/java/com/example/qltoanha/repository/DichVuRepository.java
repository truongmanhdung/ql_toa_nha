package com.example.qltoanha.repository;

import com.example.qltoanha.models.entity.CongTy;
import com.example.qltoanha.models.entity.DichVu;
import com.example.qltoanha.models.entity.NhanVienToaNha;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DichVuRepository extends CrudRepository<DichVu,Integer> {

    List<DichVu>findAllByTenDvContainingIgnoreCaseOrLoaiDvIgnoreCase(String tenDv, String loaiDv);

    List<DichVu>findAllByDonGiaIsLessThanEqual(int gia);

    List<DichVu>findAllByDonGiaIsGreaterThanEqual(int gia);

    List<DichVu>findAllByDonGiaIsLessThanEqualAndDonGiaIsGreaterThanEqual(int gia1,int gia2);
    
    @Query(value = "select * from tbl_dich_vu limit ?1,10", nativeQuery = true)
    List<DichVu>findAllInPage(int index);
    
    @Query(value = "select * from tbl_dich_vu where tbl_dich_vu.ma_phong_ban in (select id from tbl_phong_ban where tbl_phong_ban.toa_nha_id = ?1) limit ?2,10", nativeQuery = true)
	List<DichVu>findAllInPage(int id,int index);
    
    @Query(value = "select * from tbl_dich_vu where tbl_dich_vu.ma_phong_ban in (select id from tbl_phong_ban where tbl_phong_ban.toa_nha_id = ?1)" , nativeQuery = true)
	List<DichVu>findAllByToaNha(int id);

}
