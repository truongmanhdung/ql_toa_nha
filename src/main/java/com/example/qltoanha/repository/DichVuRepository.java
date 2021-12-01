package com.example.qltoanha.repository;

import com.example.qltoanha.models.DichVu;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DichVuRepository extends CrudRepository<DichVu,Integer> {
    @Query(value = "select * from tbl_dich_vu where MATCH (ten) AGAINST(?1)",nativeQuery = true)
    List<DichVu> search(String keyword);
}
