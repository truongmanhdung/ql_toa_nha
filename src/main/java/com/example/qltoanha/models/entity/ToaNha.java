package com.example.qltoanha.models.entity;

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

//    @OneToMany(targetEntity = Phong.class,mappedBy = "toaNha",cascade = CascadeType.ALL)
//    private List<Phong> dsPhong;
//
//    @OneToMany(targetEntity = PhongBan.class,mappedBy = "toaNha",cascade = CascadeType.ALL)
//    private List<PhongBan> dsPhongBan;

	public int getMaToaNha() {
		return maToaNha;
	}

	public void setMaToaNha(int maToaNha) {
		this.maToaNha = maToaNha;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

//	public List<Phong> getDsPhong() {
//		return dsPhong;
//	}
//
//	public void setDsPhong(List<Phong> dsPhong) {
//		this.dsPhong = dsPhong;
//	}
//
//	public List<PhongBan> getDsPhongBan() {
//		return dsPhongBan;
//	}
//
//	public void setDsPhongBan(List<PhongBan> dsPhongBan) {
//		this.dsPhongBan = dsPhongBan;
//	}
    
}
