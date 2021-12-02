package com.example.qltoanha.models.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

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
    private Date ngayTao;

    @Column(name="ly_do")
    private String lyDo;

    @ManyToOne(targetEntity = NhanVienToaNha.class)
    @JoinColumn(name = "ma_nv")
    private NhanVienToaNha nhanVien;
}
