package com.example.qltoanha.models.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Data
@Entity
@Table(name="tbl_nv_cty")
@Getter
@Setter
public class NhanVienCongTy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name = "CMT")
    private String cmt;

    @Column(name = "ten")
    private String ten;

    @Column(name = "SDT")
    private String sdt;

    @Column(name = "ngay_sinh")
    private String ngaySinh;

    @ManyToOne(targetEntity = CongTy.class)
    @JoinColumn(name = "ma_cong_ty")
    private CongTy congTy;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCmt() {
		return cmt;
	}

	public void setCmt(String cmt) {
		this.cmt = cmt;
	}

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public String getSdt() {
		return sdt;
	}

	public void setSdt(String sdt) {
		this.sdt = sdt;
	}

	public String getNgaySinh() {
		return ngaySinh;
	}

	public void setNgaySinh(String ngaySinh) {
		this.ngaySinh = ngaySinh;
	}

	public CongTy getCongTy() {
		return congTy;
	}

	public void setCongTy(CongTy congTy) {
		this.congTy = congTy;
	}
    

}
