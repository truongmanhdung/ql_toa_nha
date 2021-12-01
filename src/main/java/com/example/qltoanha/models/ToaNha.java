package com.example.qltoanha.models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name="tbl_toa_nha")
@Getter
@Setter
public class ToaNha {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int maToaNha;

    @Column(name="ten")
    private String name;

    @Column(name="dia_chi")
    private String diaChi;

    @Column(name="mo_ta")
    private String description;

    @OneToMany(targetEntity = Phong.class,mappedBy = "toaNha")
    private List<Phong> dsPhong;

    @OneToMany(targetEntity = NhanVienToaNha.class,mappedBy = "toaNha")
    private List<NhanVienToaNha> dsNhanVien;
}
