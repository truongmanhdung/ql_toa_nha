package com.example.qltoanha.repository;

import com.example.qltoanha.models.entity.CongTy;
import com.example.qltoanha.models.entity.NhanVienCongTy;
import org.hibernate.Session;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CongTyRepository extends CrudRepository<CongTy,Integer> {

    Iterable<CongTy>findAllByVonDieuLeIsLessThanEqual(int keyword);
    Iterable<CongTy>findAllByVonDieuLeIsGreaterThanEqual(int keyword);
    Iterable<CongTy>findAllByVonDieuLeIsGreaterThanEqualAndVonDieuLeIsLessThanEqual(int keyword1,int keyword2);
    Iterable<CongTy>findAllByTenCongTyContainingOrDiaChiContainingOrMaSoThueContainingOrLinhVucContainingOrSdtContaining(String tenCongTy, String diaChi, String maSoThue, String linhVuc, String sdt);

}
