package com.example.qltoanha.controllers;

import com.example.qltoanha.models.entity.HopDong;
import com.example.qltoanha.models.entity.Phong;
import com.example.qltoanha.repository.HopDongRepository;
import com.example.qltoanha.repository.PhongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping(path="/hopdong",produces = "application/json")
public class HopDongController {
    @Autowired
    private HopDongRepository repo;

    @GetMapping
    public List<HopDong> getAll(){
        return (List<HopDong>) repo.findAll();
    }
    
    @GetMapping("/toanha={id}/index={i}")
    public List<HopDong> getPage(@PathVariable(name = "i") int index,@PathVariable(name = "id") int id){
        return (List<HopDong>) repo.findAllInPageByToaNha(id,index);
    }
    
    @GetMapping("/toanha={id}/search={i}")
    public List<HopDong> getPage(@PathVariable("i") @DateTimeFormat(pattern = "yyyy-MM-dd") Date index, @PathVariable(name = "id") int id){
        return (List<HopDong>) repo.searchByToaNha(id, index);
    }
    
    @GetMapping("/toanha={id}")
    public List<HopDong> getAllByToaNha(@PathVariable("id") int id){
        return (List<HopDong>) repo.findAllByToaNha(id);
    }
    @GetMapping("/{id}")
    public HopDong getById(@PathVariable("id") int id){
        Optional<HopDong> x = repo.findById(id);
        if(x.isPresent()){
            return  x.get();
        }
        return null;
    }
    @PostMapping
    public HopDong create(@RequestBody HopDong x){
        return repo.save(x);
    }
    @PutMapping("/{id}")
    public HopDong update(@RequestBody HopDong ph, @PathVariable("id") int id){
        Optional<HopDong> p = repo.findById(id);
        if(p.isPresent()){
            HopDong x = p.get();
            x.setNgayTao(ph.getNgayTao());
            x.setGia(ph.getGia());
            x.setCongTy(ph.getCongTy());
            x.setGhiChu(ph.getGhiChu());
            x.setNgayHetHan(ph.getNgayHetHan());
            x.setToaNha(ph.getToaNha());
            x.setDsPhongSuDung(ph.getDsPhongSuDung());
            return repo.save(x);
        }
        return null;
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") int id){
        repo.deleteById(id);
    }
    
    
}
