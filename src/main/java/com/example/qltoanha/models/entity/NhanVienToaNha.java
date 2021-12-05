package com.example.qltoanha.models.entity;

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

    @OneToOne(targetEntity = LuongViTri.class,cascade = CascadeType.ALL)
    private LuongViTri luongViTri;

    @ManyToOne(targetEntity = PhongBan.class)
    @JoinColumn(name = "ma_phong_ban")
    private PhongBan phongBan;

    @OneToMany(targetEntity = GhiChu.class,mappedBy = "nhanVien",cascade = CascadeType.ALL)
    private List<GhiChu> ghiChu;

    @OneToMany(targetEntity = HopDong.class,mappedBy = "nhanVienToaNha",cascade = CascadeType.ALL)
    private List<HopDong> dsHopDong;
}
