package com.example.qltoanha.controllers;

import com.example.qltoanha.models.entity.GhiChu;
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
            return repo.save(x);
        }
        return null;
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") int id){
        repo.deleteById(id);
    }
}
