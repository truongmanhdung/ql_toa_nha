package com.example.qltoanha.repository;

import com.example.qltoanha.models.Phong;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhongRepository extends CrudRepository<Phong,Integer> {
}
