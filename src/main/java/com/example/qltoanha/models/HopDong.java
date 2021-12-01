package com.example.qltoanha.models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name="tbl_hop_dong")
@Getter
@Setter
public class HopDong {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "ngay_tao")
    private String ngayTao;

    @Column(name = "ngay_het_han")
    private String ngayHetHan;

    @Column(name="ghi_chu")
    private String ghiChu;

    @Column(name="gia")
    private int gia;

    @ManyToOne(targetEntity = CongTy.class)
    private CongTy congTy;

    @ManyToOne(targetEntity = NhanVienToaNha.class)
    private NhanVienToaNha nhanVienToaNha;

    @OneToMany(targetEntity = PhongSuDung.class,mappedBy = "hopDong")
    private List<PhongSuDung> dsPhongSuDung;
}
