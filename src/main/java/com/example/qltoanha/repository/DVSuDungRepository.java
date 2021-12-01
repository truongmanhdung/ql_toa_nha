package com.example.qltoanha.repository;

import com.example.qltoanha.models.DichVuSuDung;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DVSuDungRepository extends CrudRepository<DichVuSuDung,Integer> {
}
