package com.example.qltoanha.models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name="tbl_nv_toa_nha")
@Getter
@Setter
public class NhanVienToaNha {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ma_NV")
    private int maNv;

    @Column(name="ten")
    private String ten;

    @Column(name="ngay_sinh")
    private String ngaySinh;

    @Column(name="dia_chi")
    private String diaChi;

    @Column(name="SDT")
    private String sdt;

    @Column(name="bac")
    private int bac;

    @Column(name="vi_tri")
    private String viTri;

    @OneToOne(targetEntity = LuongViTri.class)
    private LuongViTri luongViTri;

    @ManyToOne(targetEntity = ToaNha.class)
    private ToaNha toaNha;

    @ManyToOne(targetEntity = GhiChu.class)
    private GhiChu ghiChu;

    @OneToMany(targetEntity = HopDong.class,mappedBy = "nhanVienToaNha")
    private List<HopDong> dsHopDong;
}
