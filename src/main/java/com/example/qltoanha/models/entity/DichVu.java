package com.example.qltoanha.models.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name="tbl_dich_vu")
@Getter
@Setter
public class DichVu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="ten")
    private String tenDv;

    @Column(name="loai")
    private String loaiDv;

    @Column(name="don_gia")
    private int donGia;

    @OneToMany(targetEntity = DichVuSuDung.class,mappedBy = "dichVu",cascade = CascadeType.ALL)
    private List<DichVuSuDung> dsDichVuSuDung;
}
