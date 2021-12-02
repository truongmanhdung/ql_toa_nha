package com.example.qltoanha.repository;

import com.example.qltoanha.models.entity.NhanVienCongTy;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NVCongTyRepository extends CrudRepository<NhanVienCongTy,Integer> {

}
