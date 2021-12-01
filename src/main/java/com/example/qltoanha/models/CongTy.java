package com.example.qltoanha.models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name="tbl_cong_ty")
@Getter
@Setter
public class CongTy {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="ten_cong_ty")
    private String tenCongTy;

    @Column(name="ma_so_thue")
    private String maSoThue;

    @Column(name="von_dieu_le")
    private int vonDieuLe;

    @Column(name="linh_vuc")
    private String linhVuc;

    @Column(name="dia_chi")
    private String diaChi;

    @Column(name="SDT")
    private String sdt;

    @OneToMany(targetEntity = NhanVienCongTy.class,mappedBy = "congTy")
    private List<NhanVienCongTy> listNv;

    @OneToMany(targetEntity = HopDong.class,mappedBy = "congTy")
    private List<HopDong> dsHopDong;
}
