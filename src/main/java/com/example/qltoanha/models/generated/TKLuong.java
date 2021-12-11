package com.example.qltoanha.models.generated;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.example.qltoanha.models.entity.NhanVienToaNha;
import lombok.*;

@Getter
@Setter
public class TKLuong extends NhanVienToaNha {
	
    private int luong;
	
	private int thang;
	
    public TKLuong(NhanVienToaNha nv, int luong, int thang){
        this.setMaNv(nv.getMaNv());
        this.setBac(nv.getBac());
        this.setTen(nv.getTen());
        this.setNgaySinh(nv.getNgaySinh());
        this.setDiaChi(nv.getDiaChi());
        this.setSdt(nv.getSdt());
        this.setLuongViTri(nv.getLuongViTri());
        this.setPhongBan(nv.getPhongBan());
        this.setLuong(luong);
        this.setGhiChu(nv.getGhiChu());
    }

	public int getThang() {
		return thang;
	}

	public void setThang(int thang) {
		this.thang = thang;
	}

	public int getLuong() {
		return luong;
	}

	public void setLuong(int luong) {
		this.luong = luong;
	}
}
