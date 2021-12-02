package com.example.qltoanha.models.entity;

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
    @JoinColumn(name = "ma_cong_ty")
    private CongTy congTy;

    @ManyToOne(targetEntity = NhanVienToaNha.class)
    @JoinColumn(name="ma_nv_toa_nha")
    private NhanVienToaNha nhanVienToaNha;

    @OneToMany(targetEntity = PhongSuDung.class,mappedBy = "hopDong",cascade = CascadeType.ALL)
    private List<PhongSuDung> dsPhongSuDung;
}
