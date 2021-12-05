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

    List<CongTy>findAllByVonDieuLeIsLessThanEqual(int keyword);
    List<CongTy>findAllByVonDieuLeIsGreaterThanEqual(int keyword);
    List<CongTy>findAllByVonDieuLeIsGreaterThanEqualAndVonDieuLeIsLessThanEqual(int keyword1,int keyword2);
    List<CongTy>findAllByTenCongTyContainingOrDiaChiContainingOrMaSoThueContainingOrLinhVucContainingOrSdtContaining(String tenCongTy, String diaChi, String maSoThue, String linhVuc, String sdt);

}
