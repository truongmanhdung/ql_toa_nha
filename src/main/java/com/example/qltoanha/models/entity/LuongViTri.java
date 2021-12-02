package com.example.qltoanha.models.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Data
@Entity
@Table(name="tbl_luong_vi_tri")
@Getter
@Setter
public class LuongViTri {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "vi_tri")
    private String viTri;

    @Column(name="luong")
    private int luong;
}
