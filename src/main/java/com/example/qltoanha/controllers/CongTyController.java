package com.example.qltoanha.controllers;

import com.example.qltoanha.models.CongTy;
import com.example.qltoanha.repository.CongTyRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/congty",produces = "application/json")
@CrossOrigin("*")
public class CongTyController {

    private final CongTyRepository repo;

    public CongTyController(CongTyRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public List<CongTy> getAll(){
        return (List<CongTy>) repo.findAll();
    }

    @GetMapping("/{id}")
    public CongTy getById(@PathVariable("id") int id){
        Optional<CongTy> congTy = repo.findById(id);
        if(congTy.isPresent()){
            return congTy.get();
        }
        return null;
    }

    @PostMapping
    public CongTy create(@RequestBody CongTy congTy){
        return repo.save(congTy);
    }

    @PutMapping("/{id}")
    public CongTy update(@RequestBody CongTy congTy, @PathVariable("id") int id){
        Optional<CongTy> x = repo.findById(id);
        if(x.isPresent()){
            CongTy congTyExist = x.get();
            congTyExist.setTenCongTy(congTy.getTenCongTy());
            congTyExist.setDiaChi(congTy.getDiaChi());
            congTyExist.setSdt(congTy.getSdt());
            congTyExist.setLinhVuc(congTy.getLinhVuc());
            congTyExist.setMaSoThue(congTy.getMaSoThue());
            congTyExist.setVonDieuLe(congTy.getVonDieuLe());
            repo.save(congTyExist);
            return congTyExist;
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") int id){
        repo.deleteById(id);
    }

    @GetMapping("/query?{keyword}")
    public List<CongTy> search(@Param("keyword") String keyword){
        return repo.search(keyword);
    }
}
