package com.example.qltoanha.models.entity;

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
    @JoinColumn(name = "ma_toa_nha")
    private ToaNha toaNha;

    @OneToMany(targetEntity = PhongSuDung.class,mappedBy = "phong",cascade = CascadeType.ALL)
    private List<PhongSuDung> dsPhongSuDung;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getDienTich() {
		return dienTich;
	}

	public void setDienTich(int dienTich) {
		this.dienTich = dienTich;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public ToaNha getToaNha() {
		return toaNha;
	}

	public void setToaNha(ToaNha toaNha) {
		this.toaNha = toaNha;
	}

//	public List<PhongSuDung> getDsPhongSuDung() {
//		return dsPhongSuDung;
//	}
//
//	public void setDsPhongSuDung(List<PhongSuDung> dsPhongSuDung) {
//		this.dsPhongSuDung = dsPhongSuDung;
//	}
    
}
