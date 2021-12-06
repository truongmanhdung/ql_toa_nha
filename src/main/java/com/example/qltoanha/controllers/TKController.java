package com.example.qltoanha.controllers;

import com.example.qltoanha.models.entity.GhiChu;
import com.example.qltoanha.models.entity.NhanVienToaNha;
import com.example.qltoanha.models.generated.TKLuong;
import com.example.qltoanha.repository.GhiChuRepository;
import com.example.qltoanha.repository.NVToaNhaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping(path = "/thongke", produces = "application/json")
public class TKController {
	
    @Autowired
    private NVToaNhaRepository nvToaNhaRepository;
    
    @Autowired
    private GhiChuRepository ghiChuRepo;

    @GetMapping("/luong/{start}&&{end}")
    public List<TKLuong> getAllLuongNv(@PathVariable("start") @DateTimeFormat(pattern = "yyyy-MM-dd")Date start, @PathVariable("end") @DateTimeFormat(pattern = "yyyy-MM-dd") Date end){
        List<NhanVienToaNha> dsNv = (List<NhanVienToaNha>) nvToaNhaRepository.findAll();
        List<TKLuong> bangLuong = new ArrayList<TKLuong>();
        for(NhanVienToaNha x : dsNv){
            int luong = 0,thuong = 0,phat = 0;
            List<GhiChu> note = (List<GhiChu>) ghiChuRepo.findAll();
            for(GhiChu g : note){
            	if(g.getNhanVien().getMaNv() == x.getMaNv()) {
	                if(g.getNgayTao().compareTo(start) <= 0 && g.getNgayTao().compareTo(end) >= 0) {
	                    if (g.getLyDo() == "phat") phat++;
	                    if (g.getLyDo() == "thuong") thuong++;
	                }
            	}
            }
            luong = x.getLuongViTri().getLuong() * x.getBac() - phat * 50000 + thuong * 100000;
            TKLuong y = new TKLuong(x,luong);
            bangLuong.add(y);
        }
        if(bangLuong.isEmpty()) return null;
        return bangLuong;
    }

    @GetMapping("/luong/{id}/{start}&&{end}")
    public TKLuong getLuongNv(@PathVariable("id")int id, @PathVariable("start") @DateTimeFormat(pattern = "yyyy-MM-dd") Date start,@PathVariable("start")@DateTimeFormat(pattern = "yyyy-MM-dd") Date end){
        Optional<NhanVienToaNha> x = nvToaNhaRepository.findById(id);
        if(x.isPresent()){
            NhanVienToaNha y = x.get();
            int luong = 0,thuong = 0,phat = 0;
            List<GhiChu> note = (List<GhiChu>) ghiChuRepo.findAll();
            for(GhiChu g : note){
            	if(g.getNhanVien().getMaNv() == y.getMaNv()) {
            		 if(g.getNgayTao().compareTo(start) <= 0 && g.getNgayTao().compareTo(end) >= 0) {
 	                    if (g.getLyDo() == "phat") phat++;
 	                    if (g.getLyDo() == "thuong") thuong++;
 	                }
            	}
            }
            luong = y.getLuongViTri().getLuong() * y.getBac() - phat * 50000 + thuong * 100000;
            return new TKLuong(y,luong);
        }
        return null;
    }
}
