package com.example.qltoanha.repository;

import com.example.qltoanha.models.entity.DichVu;
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

}
