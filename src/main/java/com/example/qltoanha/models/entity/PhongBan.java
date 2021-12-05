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

//    @OneToMany(targetEntity = DichVu.class,mappedBy = "phongBan",cascade = CascadeType.ALL)
//    private List<DichVu> dv;


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public ToaNha getToaNha() {
		return toaNha;
	}

	public void setToaNha(ToaNha toaNha) {
		this.toaNha = toaNha;
	}

//	public List<DichVu> getDv() {
//		return dv;
//	}
//
//	public void setDv(List<DichVu> dv) {
//		this.dv = dv;
//	}
    
}
