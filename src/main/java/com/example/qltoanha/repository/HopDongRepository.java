package com.example.qltoanha.repository;

import com.example.qltoanha.models.entity.HopDong;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HopDongRepository extends CrudRepository<HopDong,Integer> {
	List<HopDong>findAllByNgayTaoIsLessThanEqual(Date key);
}
