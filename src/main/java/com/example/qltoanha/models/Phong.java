package com.example.qltoanha.models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name="tbl_phong")
@Getter
@Setter
public class Phong {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="ma_phong")
    private int id;

    @Column(name="ten_phong")
    private String name;

    @Column(name="dien_tich")
    private int dienTich;

    @Column(name="gia")
    private int price;

    @ManyToOne(targetEntity = ToaNha.class)
    private ToaNha toaNha;

    @OneToMany(targetEntity = PhongSuDung.class,mappedBy = "phong")
    private List<PhongSuDung> dsPhongSuDung;
}
