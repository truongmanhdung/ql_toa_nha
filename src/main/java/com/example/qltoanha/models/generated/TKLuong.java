package com.example.qltoanha.models.generated;

import com.example.qltoanha.models.entity.NhanVienToaNha;
import lombok.*;

@Getter
@Setter
public class TKLuong extends NhanVienToaNha {
    private int luong;

    public TKLuong(NhanVienToaNha nv, int luong){
        this.setMaNv(nv.getMaNv());
        this.setBac(nv.getBac());
        this.setTen(nv.getTen());
        this.setNgaySinh(nv.getNgaySinh());
        this.setDiaChi(nv.getDiaChi());
        this.setSdt(nv.getSdt());
        this.setLuong(luong);
    }

	public int getLuong() {
		return luong;
	}

	public void setLuong(int luong) {
		this.luong = luong;
	}
}
