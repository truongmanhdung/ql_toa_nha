package com.example.qltoanha.models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Data
@Entity
@Table(name="tbl_nv_cty")
@Getter
@Setter
public class NhanVienCongTy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name = "CMT")
    private String cmt;

    @Column(name = "ten")
    private String ten;

    @Column(name = "SDT")
    private String sdt;

    @Column(name = "ngay_sinh")
    private String ngaySinh;

    @ManyToOne(targetEntity = CongTy.class)
    private CongTy congTy;

}
