package com.example.qltoanha.repository;

import com.example.qltoanha.models.entity.DichVuSuDung;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DVSuDungRepository extends CrudRepository<DichVuSuDung,Integer> {

    Iterable<DichVuSuDung>findAllByGiaIsLessThanEqual(int x);
    Iterable<DichVuSuDung>findAllByGiaIsGreaterThanEqual(int x);
    Iterable<DichVuSuDung>findAllByGiaIsLessThanEqualAndGiaIsGreaterThanEqual(int x,int y);
}
