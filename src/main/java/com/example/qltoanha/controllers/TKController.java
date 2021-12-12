package com.example.qltoanha.controllers;

import com.example.qltoanha.models.entity.GhiChu;
import com.example.qltoanha.models.entity.NhanVienToaNha;
import com.example.qltoanha.models.generated.TKLuong;
import com.example.qltoanha.repository.GhiChuRepository;
import com.example.qltoanha.repository.NVToaNhaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
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
    
	@GetMapping("/luong/{start}&&{end}&&toanha={id}&&phongban={p}")
    public List<TKLuong> getAllLuongNv(@PathVariable("id") int id,@PathVariable("p") int p,@PathVariable("start") @DateTimeFormat(pattern = "yyyy-MM-dd")Date start, @PathVariable("end") @DateTimeFormat(pattern = "yyyy-MM-dd") Date end) throws ParseException{
        List<NhanVienToaNha> dsNv = (List<NhanVienToaNha>) nvToaNhaRepository.findByPhongBan(p,id);
        List<TKLuong> bangLuong = new ArrayList<TKLuong>();
        for(NhanVienToaNha x : dsNv){
            int luong = 0,thuong = 0,phat = 0,thang = 0;
            phat = ghiChuRepo.countStatusByNhanVien(x.getMaNv(),"phat", start, end);
            thuong = ghiChuRepo.countStatusByNhanVien(x.getMaNv(),"thuong", start, end);
            luong = x.getLuongViTri().getLuong() * x.getBac() - phat * 50000 + thuong * 100000;
            TKLuong y = new TKLuong(x,luong,thang);
            bangLuong.add(y);
        }
        if(bangLuong.isEmpty()) return null;
        return bangLuong;
    }
	
    @GetMapping("/luong/{id}/{start}&&{end}&&toanha={toaNha}")
    public TKLuong getLuongNv(@PathVariable("toaNha") int toaNha,@PathVariable("id")int id, @PathVariable("start") @DateTimeFormat(pattern = "yyyy-MM-dd") Date s,@PathVariable("start")@DateTimeFormat(pattern = "yyyy-MM-dd") Date e) throws ParseException{
        Optional<NhanVienToaNha> x = nvToaNhaRepository.findById(id);
        if(x.isPresent()){
            NhanVienToaNha y = x.get();
            int luong = 0,thuong = 0,phat = 0,thang = 0;
            phat = ghiChuRepo.countStatusByNhanVien(y.getMaNv(),"phat", s, e);
            thuong = ghiChuRepo.countStatusByNhanVien(y.getMaNv(),"thuong", s, e);
            luong = y.getLuongViTri().getLuong() * y.getBac() - phat * 50000 + thuong * 100000;
            return new TKLuong(y,luong,thang);
        }
        return null;
    }
}
