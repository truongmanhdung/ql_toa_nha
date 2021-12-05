package com.example.qltoanha.models.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name="tbl_cong_ty")
@Getter
@Setter
public class CongTy {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="ten_cong_ty")
    private String tenCongTy;

    @Column(name="ma_so_thue")
    private String maSoThue;

    @Column(name="von_dieu_le")
    private int vonDieuLe;

    @Column(name="linh_vuc")
    private String linhVuc;

    @Column(name="dia_chi")
    private String diaChi;

    @Column(name="SDT")
    private String sdt;

//    @OneToMany(targetEntity = NhanVienCongTy.class,mappedBy = "congTy",cascade = CascadeType.ALL)
//    private List<NhanVienCongTy> listNv;
//
//    @OneToMany(targetEntity = HopDong.class,mappedBy = "congTy", cascade = CascadeType.ALL)
//    private List<HopDong> dsHopDong;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTenCongTy() {
		return tenCongTy;
	}

	public void setTenCongTy(String tenCongTy) {
		this.tenCongTy = tenCongTy;
	}

	public String getMaSoThue() {
		return maSoThue;
	}

	public void setMaSoThue(String maSoThue) {
		this.maSoThue = maSoThue;
	}

	public int getVonDieuLe() {
		return vonDieuLe;
	}

	public void setVonDieuLe(int vonDieuLe) {
		this.vonDieuLe = vonDieuLe;
	}

	public String getLinhVuc() {
		return linhVuc;
	}

	public void setLinhVuc(String linhVuc) {
		this.linhVuc = linhVuc;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getSdt() {
		return sdt;
	}

	public void setSdt(String sdt) {
		this.sdt = sdt;
	}

//	public List<NhanVienCongTy> getListNv() {
//		return listNv;
//	}
//
//	public void setListNv(List<NhanVienCongTy> listNv) {
//		this.listNv = listNv;
//	}
//
//	public List<HopDong> getDsHopDong() {
//		return dsHopDong;
//	}
//
//	public void setDsHopDong(List<HopDong> dsHopDong) {
//		this.dsHopDong = dsHopDong;
//	}
    
}
