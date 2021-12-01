package com.example.qltoanha.repository;

import com.example.qltoanha.models.PhongSuDung;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhongSuDungRepository extends CrudRepository<PhongSuDung,Integer> {
}
