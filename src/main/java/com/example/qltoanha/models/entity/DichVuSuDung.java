package com.example.qltoanha.models.entity;

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
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "id_dvsd_sequence")
	@SequenceGenerator(name = "id_dvsd_sequence", sequenceName = "id_dvsd_sequence")
    @Column(name="id")
    private int id;

    @Column(name="so_luong")
    private int soLuong;

    @Column(name="giam_gia")
    private int giamGia;

    @Column(name="gia")
    private int gia;

    @ManyToOne(targetEntity = DichVu.class)
    @JoinColumn(name = "ma_dv")
    private DichVu dichVu;

    @ManyToOne(targetEntity = HopDong.class)
    @JoinColumn(name = "ma_hop_dong")
    private HopDong dv;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public int getGiamGia() {
		return giamGia;
	}

	public void setGiamGia(int giamGia) {
		this.giamGia = giamGia;
	}

	public int getGia() {
		return gia;
	}

	public void setGia(int gia) {
		this.gia = gia;
	}

	public DichVu getDichVu() {
		return dichVu;
	}

	public void setDichVu(DichVu dichVu) {
		this.dichVu = dichVu;
	}

//	public PhongSuDung getPhongSuDung() {
//		return phongSuDung;
//	}
//
//	public void setPhongSuDung(PhongSuDung phongSuDung) {
//		this.phongSuDung = phongSuDung;
//	}
    
}
