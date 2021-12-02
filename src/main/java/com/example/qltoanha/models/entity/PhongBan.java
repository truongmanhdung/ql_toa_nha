package com.example.qltoanha.models.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "tbl_phong_ban")
@Getter
@Setter
public class PhongBan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "ten")
    private int ten;

    @ManyToOne(targetEntity = ToaNha.class)
    private ToaNha toaNha;

    @OneToMany(targetEntity = NhanVienToaNha.class,mappedBy = "phongBan",cascade = CascadeType.ALL)
    private List<NhanVienToaNha> dcNv;

    @OneToOne(targetEntity = DichVu.class)
    private DichVu dvPhuTrach;
}
