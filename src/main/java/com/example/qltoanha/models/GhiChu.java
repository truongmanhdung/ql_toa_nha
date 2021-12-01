package com.example.qltoanha.models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name="tbl_ghi_chu")
@Getter
@Setter
public class GhiChu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="ngay_tao")
    private String ngayTao;

    @Column(name="ly_do")
    private String lyDo;

    @OneToMany(targetEntity = NhanVienToaNha.class,mappedBy = "ghiChu")
    private List<NhanVienToaNha> listNhanVien;
}
