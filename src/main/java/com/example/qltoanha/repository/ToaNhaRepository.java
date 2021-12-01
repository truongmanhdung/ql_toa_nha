package com.example.qltoanha.repository;

import com.example.qltoanha.models.ToaNha;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ToaNhaRepository extends CrudRepository<ToaNha,Integer> {
}
