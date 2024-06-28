package com.example.qltoanha.models.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import org.springframework.lang.Nullable;

import java.util.List;

@Data
@Entity
@Table(name="tbl_dich_vu")
@Getter
@Setter
public class DichVu {
    @Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "id_dich_vu_sequence")
	@SequenceGenerator(name = "id_dich_vu_sequence", sequenceName = "id_dich_vu_sequence")
    @Column(name="id")
    private int id;

    @Column(name="ten")
    @Nullable
    private String tenDv;

    @Column(name="loai")
    private String loaiDv;

    @Column(name="don_gia")
    private int donGia;

//    @OneToMany(targetEntity = DichVuSuDung.class,mappedBy = "dichVu",cascade = CascadeType.ALL)
//    private List<DichVuSuDung> dsDichVuSuDung;
    
    @ManyToOne(targetEntity = PhongBan.class)
    @JoinColumn(name = "ma_phong_ban")
    private PhongBan phongBan;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTenDv() {
		return tenDv;
	}

	public void setTenDv(String tenDv) {
		this.tenDv = tenDv;
	}

	public String getLoaiDv() {
		return loaiDv;
	}

	public void setLoaiDv(String loaiDv) {
		this.loaiDv = loaiDv;
	}

	public int getDonGia() {
		return donGia;
	}

	public void setDonGia(int donGia) {
		this.donGia = donGia;
	}

//	public List<DichVuSuDung> getDsDichVuSuDung() {
//		return dsDichVuSuDung;
//	}
//
//	public void setDsDichVuSuDung(List<DichVuSuDung> dsDichVuSuDung) {
//		this.dsDichVuSuDung = dsDichVuSuDung;
//	}

	public PhongBan getPhongBan() {
		return phongBan;
	}

	public void setPhongBan(PhongBan phongBan) {
		this.phongBan = phongBan;
	}
    

}
