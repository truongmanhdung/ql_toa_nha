package com.example.qltoanha.repository;

import com.example.qltoanha.models.entity.GhiChu;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GhiChuRepository extends CrudRepository<GhiChu,Integer> {
	
	
}
