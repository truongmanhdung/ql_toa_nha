package com.example.qltoanha.models.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Data
@Entity
@Table(name="tbl_luong_vi_tri")
@Getter
@Setter
public class LuongViTri {
    @Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "id_luont_vt_sequence")
	@SequenceGenerator(name = "id_luong_vt_sequence", sequenceName = "id_luong_vt_sequence")
    @Column(name = "id")
    private int id;

    @Column(name = "vi_tri")
    private String viTri;

    @Column(name="luong")
    private int luong;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getViTri() {
		return viTri;
	}

	public void setViTri(String viTri) {
		this.viTri = viTri;
	}

	public int getLuong() {
		return luong;
	}

	public void setLuong(int luong) {
		this.luong = luong;
	}
    
}
