package com.example.qltoanha.repository;

import com.example.qltoanha.models.CongTy;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CongTyRepository extends CrudRepository<CongTy,Integer> {

    @Query(value = "select * from tbl_cong_ty where MATCH (ten_cong_ty) AGAINST(?1)",nativeQuery = true)
    List<CongTy> search(String keyword);
}
