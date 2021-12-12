package com.example.qltoanha.models.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name="tbl_nv_toa_nha")
@Getter
@Setter
public class NhanVienToaNha {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ma_NV")
    private int maNv;

    @Column(name="ten")
    private String ten;

    @Column(name="ngay_sinh")
    private String ngaySinh;

    @Column(name="dia_chi")
    private String diaChi;

    @Column(name="SDT")
    private String sdt;

    @Column(name="bac")
    private int bac;

    @OneToOne(targetEntity = LuongViTri.class)
    private LuongViTri luongViTri;

    @ManyToOne(targetEntity = PhongBan.class)
    @JoinColumn(name = "ma_phong_ban")
    private PhongBan phongBan;

    @OneToMany(targetEntity = GhiChu.class,mappedBy = "nhanVien",cascade = CascadeType.ALL)
    private List<GhiChu> ghiChu;

//    @OneToMany(targetEntity = HopDong.class,mappedBy = "nhanVienToaNha",cascade = CascadeType.ALL)
//    private List<HopDong> dsHopDong;

	public int getMaNv() {
		return maNv;
	}

	public void setMaNv(int maNv) {
		this.maNv = maNv;
	}

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public String getNgaySinh() {
		return ngaySinh;
	}

	public void setNgaySinh(String ngaySinh) {
		this.ngaySinh = ngaySinh;
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

	public int getBac() {
		return bac;
	}

	public void setBac(int bac) {
		this.bac = bac;
	}

	public LuongViTri getLuongViTri() {
		return luongViTri;
	}

	public void setLuongViTri(LuongViTri luongViTri) {
		this.luongViTri = luongViTri;
	}

	public PhongBan getPhongBan() {
		return phongBan;
	}

	public void setPhongBan(PhongBan phongBan) {
		this.phongBan = phongBan;
	}

	public List<GhiChu> getGhiChu() {
		return ghiChu;
	}

	public void setGhiChu(List<GhiChu> ghiChu) {
		this.ghiChu = ghiChu;
	}
//
//	public List<HopDong> getDsHopDong() {
//		return dsHopDong;
//	}
//
//	public void setDsHopDong(List<HopDong> dsHopDong) {
//		this.dsHopDong = dsHopDong;
//	}
    
}
