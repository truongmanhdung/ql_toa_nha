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
    
	@GetMapping("/luong/{start}&&{end}&&toanha={id}")
    public List<TKLuong> getAllLuongNv(@PathVariable("id") int id,@PathVariable("start") @DateTimeFormat(pattern = "yyyy-MM-dd")Date start, @PathVariable("end") @DateTimeFormat(pattern = "yyyy-MM-dd") Date end) throws ParseException{
        List<NhanVienToaNha> dsNv = (List<NhanVienToaNha>) nvToaNhaRepository.findAllByToaNha(id);
        List<TKLuong> bangLuong = new ArrayList<TKLuong>();
        for(NhanVienToaNha x : dsNv){
            int luong = 0,thuong = 0,phat = 0,thang = 0;
            List<GhiChu> note = x.getGhiChu();
            if(!note.isEmpty()) {
            for(GhiChu g : note){
   
	                if(g.getNgayTao().after(start) && g.getNgayTao().before(end)) {
	                	if(g.getStatus() != null) {
	                    if (g.getStatus().trim().toLowerCase() == "phat") phat++;
	                    if (g.getStatus().trim().toLowerCase() == "thuong") thuong++;}
	                  
            	}
            }
            }
            luong = x.getLuongViTri().getLuong() * x.getBac() - phat * 50000 + thuong * 100000;
            TKLuong y = new TKLuong(x,luong,thang);
            bangLuong.add(y);
            
        }
        if(bangLuong.isEmpty()) return null;
        return bangLuong;
    }
	
	@GetMapping("/luong/{start}&&{end}&&toanha={id}&&search={s}")
	public List<TKLuong> search(@PathVariable("id") int id,@PathVariable("s") String key,@PathVariable("start") @DateTimeFormat(pattern = "yyyy-MM-dd")Date start, @PathVariable("end") @DateTimeFormat(pattern = "yyyy-MM-dd") Date end) throws ParseException{
        List<NhanVienToaNha> dsNv = (List<NhanVienToaNha>) nvToaNhaRepository.searchByToaNha(id, key);
        List<TKLuong> bangLuong = new ArrayList<TKLuong>();
        for(NhanVienToaNha x : dsNv){
            int luong = 0,thuong = 0,phat = 0,thang = 0;
            List<GhiChu> note = x.getGhiChu();
            for(GhiChu g : note){
//            	if(g.getNhanVien().getMaNv() == x.getMaNv()) {
//            		Date date = new SimpleDateFormat("yyyy-MM-dd").parse(g.getNgayTao());
	                if(g.getNgayTao().compareTo(start) <= 0 && g.getNgayTao().compareTo(end) >= 0) {
	                    if (g.getStatus().toLowerCase() == "phat") phat++;
	                    if (g.getStatus().toLowerCase() == "thuong") thuong++;
//	                }
	                  
//                    Calendar cal = Calendar.getInstance();
//                    cal.setTime(date);
//                    thang += cal.get(Calendar.MONTH);
            	}
            }
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
//		 Date start = new SimpleDateFormat("yyyy-MM-dd").parse(s);
//		 Date end = new SimpleDateFormat("yyyy-MM-dd").parse(e);

        if(x.isPresent()){
            NhanVienToaNha y = x.get();
            int luong = 0,thuong = 0,phat = 0,thang = 0;
            List<GhiChu> note = y.getGhiChu();
            if(!note.isEmpty()) {
            for(GhiChu g : note){
//            		String[] tmp = g.getNgayTao().split(" ");
//            	if(g.getNhanVien().getMaNv() == y.getMaNv()) {
            		 Date date = new SimpleDateFormat("yyyy-MM-dd").parse(g.getNgayTao().toString());
            		 if(g.getNgayTao().after(s) && g.getNgayTao().before(e)) {
 	                    if (g.getStatus().trim().equals("phat")) phat += 1;
 	                    if (g.getStatus().trim().toLowerCase() == "thuong") thuong += 1;
 	                }
//        		 Calendar cal = Calendar.getInstance();
//                 cal.setTime(date);
//                 thang += cal.get(Calendar.MONTH);
//            	}
            }
            }
            luong = y.getLuongViTri().getLuong() * y.getBac() - phat * 50000 + thuong * 100000;
            return new TKLuong(y,luong,thang);
        }
        return null;
    }
}
