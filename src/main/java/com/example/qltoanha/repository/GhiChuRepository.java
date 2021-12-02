package com.example.qltoanha.repository;

import com.example.qltoanha.models.entity.GhiChu;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GhiChuRepository extends CrudRepository<GhiChu,Integer> {
}
