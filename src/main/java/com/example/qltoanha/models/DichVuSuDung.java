package com.example.qltoanha.models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Data
@Entity
@Table(name="tbl_dv_su_dung")
@Getter
@Setter
public class DichVuSuDung {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="so_luong")
    private int soLuong;

    @Column(name="giam_gia")
    private int giamGia;

    @Column(name="gia")
    private int gia;

    @ManyToOne(targetEntity = DichVu.class)
    private DichVu dichVu;

    @ManyToOne(targetEntity = PhongSuDung.class)
    private PhongSuDung phongSuDung;
}
