package com.example.qltoanha.models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name="tbl_phong_su_dung")
@Getter
@Setter
public class PhongSuDung {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name="giam_gia")
    private int giamGia;

    @Column(name = "ghi_chu")
    private String ghiChu;

    @Column(name="ngay_bat_dau")
    private String ngayBatDau;

    @ManyToOne(targetEntity = Phong.class)
    private Phong phong;
    
    @ManyToOne(targetEntity = HopDong.class)
    private HopDong hopDong;

    @OneToMany(targetEntity = DichVuSuDung.class,mappedBy = "phongSuDung")
    private List<DichVuSuDung> dsDichVuSuDung;

}
