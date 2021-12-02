package com.example.qltoanha.repository;

import com.example.qltoanha.models.entity.NhanVienToaNha;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NVToaNhaRepository extends CrudRepository<NhanVienToaNha,Integer> {
}
