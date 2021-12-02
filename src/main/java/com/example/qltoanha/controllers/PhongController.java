package com.example.qltoanha.controllers;

import com.example.qltoanha.models.entity.Phong;
import com.example.qltoanha.repository.PhongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping(path="/phong",produces = "application/json")
public class PhongController {
    @Autowired
    private PhongRepository repo;

    @GetMapping
    public List<Phong> getAll(){
        return (List<Phong>) repo.findAll();
    }
    @GetMapping("/{id}")
    public Phong getById(@PathVariable("id") int id){
        Optional<Phong> x = repo.findById(id);
        if(x.isPresent()){
            return  x.get();
        }
        return null;
    }
    @PostMapping
    public Phong create(@RequestBody Phong x){
        return repo.save(x);
    }
    @PutMapping("/{id}")
    public Phong update(@RequestBody Phong ph, @PathVariable("id") int id){
        Optional<Phong> p = repo.findById(id);
        if(p.isPresent()){
            Phong x = p.get();
            x.setName(ph.getName());
            x.setDienTich(ph.getDienTich());
            x.setPrice(ph.getPrice());
            return repo.save(x);
        }
        return null;
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") int id){
        repo.deleteById(id);
    }
}
