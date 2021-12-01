package com.example.qltoanha.repository;

import com.example.qltoanha.models.CongTy;
import com.example.qltoanha.models.NhanVienCongTy;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NVCongTyRepository extends CrudRepository<NhanVienCongTy,Integer> {

}
