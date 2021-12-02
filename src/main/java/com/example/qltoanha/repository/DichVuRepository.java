package com.example.qltoanha.repository;

import com.example.qltoanha.models.entity.DichVu;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DichVuRepository extends CrudRepository<DichVu,Integer> {

    Iterable<DichVu>findAllByTenDvContainingIgnoreCaseOrLoaiDvIgnoreCase(String tenDv, String loaiDv);

    Iterable<DichVu>findAllByDonGiaIsLessThanEqual(int gia);

    Iterable<DichVu>findAllByDonGiaIsGreaterThanEqual(int gia);

    Iterable<DichVu>findAllByDonGiaIsLessThanEqualAndDonGiaIsGreaterThanEqual(int gia1,int gia2);

}
