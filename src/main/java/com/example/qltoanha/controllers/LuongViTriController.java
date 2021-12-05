package com.example.qltoanha.controllers;

import com.example.qltoanha.models.entity.LuongViTri;
import com.example.qltoanha.repository.LuongViTriRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping(path = "/luongvitri", produces = "application/json")
public class LuongViTriController {

    @Autowired
    private LuongViTriRepository repo;

    @GetMapping
    public List<LuongViTri> getAll(){
        return (List<LuongViTri>) repo.findAll();
    }

    @GetMapping("/{id}")
    public LuongViTri getById(@PathVariable("id") int id){
        Optional<LuongViTri> x = repo.findById(id);
        if(x.isPresent()){
            return x.get();
        }
        return null;
    }

    @PostMapping
    public LuongViTri create(@RequestBody LuongViTri l){
        return repo.save(l);
    }

    @PutMapping("/{id}")
    public LuongViTri update(@RequestBody LuongViTri l, @PathVariable("id") int id){
        Optional<LuongViTri> x = repo.findById(id);
        if(x.isPresent()){
            LuongViTri exist = x.get();
            exist.setViTri(l.getViTri());
            exist.setLuong(l.getLuong());
            return repo.save(exist);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") int id){
        repo.deleteById(id);
    }
}
