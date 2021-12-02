package com.example.qltoanha.repository;

import com.example.qltoanha.models.entity.PhongBan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhongBanRepository extends CrudRepository<PhongBan,Integer> {

}
