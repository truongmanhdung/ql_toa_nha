package com.example.qltoanha.controllers;

import com.example.qltoanha.models.entity.PhongBan;
import com.example.qltoanha.repository.PhongBanRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/phongban",produces = "application/json")
@CrossOrigin("*")
public class PhongBanController {
    private final PhongBanRepository repo;

    public PhongBanController(PhongBanRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public List<PhongBan> getAll(){
        return (List<PhongBan>) repo.findAll();
    }

    @GetMapping("/{id}")
    public PhongBan getById(@PathVariable("id") int id){
        Optional<PhongBan> congTy = repo.findById(id);
        if(congTy.isPresent()){
            return congTy.get();
        }
        return null;
    }

    @PostMapping
    public PhongBan create(@RequestBody PhongBan congTy){
        return repo.save(congTy);
    }

    @PutMapping("/{id}")
    public PhongBan update(@RequestBody PhongBan congTy, @PathVariable("id") int id){
        Optional<PhongBan> x = repo.findById(id);
        if(x.isPresent()){
            PhongBan congTyExist = x.get();
            congTyExist.setTen(congTy.getTen());
            congTyExist.setToaNha(congTy.getToaNha());
            congTyExist.setDvPhuTrach(congTy.getDvPhuTrach());
            repo.save(congTyExist);
            return congTyExist;
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") int id){
        repo.deleteById(id);
    }

}
