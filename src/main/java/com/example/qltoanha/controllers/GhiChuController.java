package com.example.qltoanha.controllers;

import com.example.qltoanha.models.entity.GhiChu;
import com.example.qltoanha.models.entity.NhanVienCongTy;
import com.example.qltoanha.repository.GhiChuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/ghichu")
public class GhiChuController {
    @Autowired
    private GhiChuRepository repo;

    @GetMapping
    public List<GhiChu> getAll(){
        return (List<GhiChu>) repo.findAll();
    }
    
    @GetMapping("/nv={id}")
    public List<GhiChu> getAll(@PathVariable("id") int id){
        return (List<GhiChu>) repo.findAllByNhanVien(id);
    }
    
    @GetMapping("/nv={id}/index={index}")
    public List<GhiChu> getPage(@PathVariable("id") int id, @PathVariable("index") int index){
        return (List<GhiChu>) repo.findAllInPage(id, index);
    }
    
    @GetMapping("/nv={id}/search={s}")
    public List<GhiChu> search(@PathVariable("id") int id, @PathVariable("s") String x){
        return (List<GhiChu>) repo.findAllByLiDo(id, x);
    }
    @GetMapping("/{id}")
    public GhiChu getById(@PathVariable("id") int id){
        Optional<GhiChu> x = repo.findById(id);
        if(x.isPresent()){
            return  x.get();
        }
        return null;
    }
    @PostMapping
    public GhiChu create(@RequestBody GhiChu x){
        return repo.save(x);
    }
    @PutMapping("/{id}")
    public GhiChu update(@RequestBody GhiChu ph, @PathVariable("id") int id){
        Optional<GhiChu> p = repo.findById(id);
        if(p.isPresent()){
            GhiChu x = p.get();
            x.setLyDo(ph.getLyDo());
            x.setNgayTao(ph.getNgayTao());
            x.setStatus(ph.getStatus());

            return repo.save(x);
        }
        return null;
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") int id){
        repo.deleteById(id);
    }
}
