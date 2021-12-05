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
    private String ten;

    @ManyToOne(targetEntity = ToaNha.class)
    private ToaNha toaNha;

    @OneToMany(targetEntity = DichVu.class,mappedBy = "phongBan",cascade = CascadeType.ALL)
    private List<DichVu> dv;
}
