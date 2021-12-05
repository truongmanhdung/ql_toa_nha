package com.example.qltoanha.models.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name="tbl_hop_dong")
@Getter
@Setter
public class HopDong {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "ngay_tao")
    private String ngayTao;

    @Column(name = "ngay_het_han")
    private String ngayHetHan;

    @Column(name="ghi_chu")
    private String ghiChu;

    @Column(name="gia")
    private int gia;

    @ManyToOne(targetEntity = CongTy.class)
    @JoinColumn(name = "ma_cong_ty")
    private CongTy congTy;

    @ManyToOne(targetEntity = NhanVienToaNha.class)
    @JoinColumn(name="ma_nv_toa_nha")
    private NhanVienToaNha nhanVienToaNha;

    @OneToMany(targetEntity = PhongSuDung.class,mappedBy = "hopDong",cascade = CascadeType.ALL)
    private List<PhongSuDung> dsPhongSuDung;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNgayTao() {
		return ngayTao;
	}

	public void setNgayTao(String ngayTao) {
		this.ngayTao = ngayTao;
	}

	public String getNgayHetHan() {
		return ngayHetHan;
	}

	public void setNgayHetHan(String ngayHetHan) {
		this.ngayHetHan = ngayHetHan;
	}

	public String getGhiChu() {
		return ghiChu;
	}

	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}

	public int getGia() {
		return gia;
	}

	public void setGia(int gia) {
		this.gia = gia;
	}

	public CongTy getCongTy() {
		return congTy;
	}

	public void setCongTy(CongTy congTy) {
		this.congTy = congTy;
	}

	public NhanVienToaNha getNhanVienToaNha() {
		return nhanVienToaNha;
	}

	public void setNhanVienToaNha(NhanVienToaNha nhanVienToaNha) {
		this.nhanVienToaNha = nhanVienToaNha;
	}

	public List<PhongSuDung> getDsPhongSuDung() {
		return dsPhongSuDung;
	}

	public void setDsPhongSuDung(List<PhongSuDung> dsPhongSuDung) {
		this.dsPhongSuDung = dsPhongSuDung;
	}
    
    
}
