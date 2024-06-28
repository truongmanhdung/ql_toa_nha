package com.example.qltoanha.models.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name="tbl_ghi_chu")
@Getter
@Setter
public class GhiChu {
    @Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "id_ghi_chu_sequence")
	@SequenceGenerator(name = "id_ghi_chu_sequence", sequenceName = "id_ghi_chu_sequence")
    @Column(name="id")
    private int id;

    @Column(name="ngay_tao")
    private Date ngayTao;
    
    @Column(name="status")
    private String status;

    public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Column(name="ly_do")
    private String lyDo;

    @ManyToOne(targetEntity = NhanVienToaNha.class)
    @JoinColumn(name = "ma_nv")
    private NhanVienToaNha nhanVien;
    
 
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

	public String getLyDo() {
		return lyDo;
	}

	public void setLyDo(String lyDo) {
		this.lyDo = lyDo;
	}

//	public NhanVienToaNha getNhanVien() {
//		return nhanVien;
//	}
//
//	public void setNhanVien(NhanVienToaNha nhanVien) {
//		this.nhanVien = nhanVien;
//	}
    
}
