package com.example.qltoanha.models.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name="tbl_hop_dong")
@Getter
@Setter
public class HopDong {
    @Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "id_hop_dong_sequence")
	@SequenceGenerator(name = "id_hop_dong_sequence", sequenceName = "id_hop_dong_sequence")
    private int id;

    @Column(name = "ngay_tao")
    private Date ngayTao;

    @Column(name = "ngay_het_han")
    private Date ngayHetHan;

    @Column(name="ghi_chu")
    private String ghiChu;

    @Column(name="gia")
    private float gia;

    @ManyToOne(targetEntity = CongTy.class)
    @JoinColumn(name = "ma_cong_ty")
    private CongTy congTy;

    @ManyToOne(targetEntity = ToaNha.class)
    @JoinColumn(name="ma_toa_nha")
    private ToaNha toaNha;

    @OneToMany(targetEntity = PhongSuDung.class,mappedBy = "hopDong",cascade = CascadeType.ALL)
    private List<PhongSuDung> dsPhongSuDung;
    
    @OneToMany(targetEntity = DichVuSuDung.class,mappedBy = "dv",cascade = CascadeType.ALL)
    private List<DichVuSuDung> dvSuDung;

	public List<DichVuSuDung> getDvSuDung() {
		return dvSuDung;
	}

	public void setDvSuDung(List<DichVuSuDung> dvSuDung) {
		this.dvSuDung = dvSuDung;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getNgayTao() {
		return ngayTao;
	}

	public void setNgayTao(Date ngayTao) {
		this.ngayTao = ngayTao;
	}

	public Date getNgayHetHan() {
		return ngayHetHan;
	}

	public void setNgayHetHan(Date ngayHetHan) {
		this.ngayHetHan = ngayHetHan;
	}

	public String getGhiChu() {
		return ghiChu;
	}

	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}

	public float getGia() {
		return gia;
	}

	public void setGia(float gia) {
		this.gia = gia;
	}

	public CongTy getCongTy() {
		return congTy;
	}

	public void setCongTy(CongTy congTy) {
		this.congTy = congTy;
	}

	public ToaNha getToaNha() {
		return toaNha;
	}

	public void setToaNha(ToaNha toaNha) {
		this.toaNha = toaNha;
	}

	

	public List<PhongSuDung> getDsPhongSuDung() {
		return dsPhongSuDung;
	}

	public void setDsPhongSuDung(List<PhongSuDung> dsPhongSuDung) {
		this.dsPhongSuDung = dsPhongSuDung;
	}
    
    
}
