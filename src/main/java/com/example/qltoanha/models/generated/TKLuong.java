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
        this.setDiaChi(nv.getDiaChi());
        this.setSdt(nv.getSdt());
        this.setViTri(nv.getViTri());
        this.setLuong(luong);
    }
}
