package com.example.qltoanha.controllers;

import com.example.qltoanha.models.entity.NhanVienCongTy;
import com.example.qltoanha.repository.NVCongTyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping(path = "/nvcongty", produces = "application/json")
public class NhanVienCongTyController {
    @Autowired
    private NVCongTyRepository repo;

    @GetMapping
    public List<NhanVienCongTy> getAll(){
        return (List<NhanVienCongTy>) repo.findAll();
    }
    
    @GetMapping("/cty={id}")
    public List<NhanVienCongTy> getAll(@PathVariable("id") int id){
        return (List<NhanVienCongTy>) repo.findAllByCongTy(id);
    }
    
    @GetMapping("/cty={id}/index={index}")
    public List<NhanVienCongTy> getPage(@PathVariable("id") int id, @PathVariable("index") int index){
        return (List<NhanVienCongTy>) repo.findAllInPage(id, index);
    }
    
    @GetMapping("/cty={id}/search={s}")
    public List<NhanVienCongTy> search(@PathVariable("id") int id, @PathVariable("s") String x){
        return (List<NhanVienCongTy>) repo.findAllByTen(id, x);
    }
    
    @GetMapping("/{id}")
    public NhanVienCongTy getById(@PathVariable("id") int id){
        Optional<NhanVienCongTy> x = repo.findById(id);
        if(x.isPresent()){
            return  x.get();
        }
        return null;
    }
    @PostMapping
    public NhanVienCongTy create(@RequestBody NhanVienCongTy x){
        return repo.save(x);
    }
    @PutMapping("/{id}")
    public NhanVienCongTy update(@RequestBody NhanVienCongTy ph, @PathVariable("id") int id){
        Optional<NhanVienCongTy> p = repo.findById(id);
        if(p.isPresent()){
            NhanVienCongTy x = p.get();
            x.setCmt(ph.getCmt());
            x.setTen(ph.getTen());
            x.setSdt(ph.getSdt());
            x.setNgaySinh(ph.getNgaySinh());
            return repo.save(x);
        }
        return null;
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") int id){
        repo.deleteById(id);
    }
}
