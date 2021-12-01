package com.example.qltoanha.repository;

import com.example.qltoanha.models.LuongViTri;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LuongViTriRepository extends CrudRepository<LuongViTri,Integer> {
}
