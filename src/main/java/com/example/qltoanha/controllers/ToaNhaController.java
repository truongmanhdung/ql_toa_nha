package com.example.qltoanha.controllers;

import com.example.qltoanha.models.entity.CongTy;
import com.example.qltoanha.models.entity.ToaNha;
import com.example.qltoanha.repository.ToaNhaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping(path = "/toanha", produces = "application/json")
public class ToaNhaController {
    @Autowired
    private ToaNhaRepository repo;

    @GetMapping
    public List<ToaNha> getAll(){
        return (List<ToaNha>) repo.findAll();
    }
    
    @GetMapping("/index={i}")
    public List<ToaNha> getPage(@PathVariable("i") int index){
        return (List<ToaNha>) repo.findAllInPage(index);
    }
    
    @GetMapping("/phongban={i}")
    public List<ToaNha> getByPhongBan(@PathVariable("i") int index){
        return (List<ToaNha>) repo.findByPhongBan(index);
    }
    
    @GetMapping("/{id}")
    public ToaNha getById(@PathVariable("id") int id){
        Optional<ToaNha> x = repo.findById(id);
        if(x.isPresent()){
            return x.get();
        }
        return null;
    }
    @PostMapping
    public ToaNha create(@RequestBody ToaNha x){
        return repo.save(x);
    }
    @PutMapping("/{id}")
    public ToaNha update(@RequestBody ToaNha x,@PathVariable("id") int id){
        Optional<ToaNha> t = repo.findById(id);
        if(t.isPresent()){
            ToaNha toaNha = t.get();
            toaNha.setName(x.getName());
            toaNha.setDiaChi(x.getDiaChi());
            toaNha.setDescription(x.getDescription());
            return repo.save(toaNha);
        }
        return null;
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") int id){
        repo.deleteById(id);
    }
    
    @GetMapping("/query/search={keyword}")
    public List<ToaNha> search(@PathVariable("keyword") String keyword){
        return (List<ToaNha>) repo.findAllByNameContainingOrDiaChiContainingOrDescriptionContaining(keyword,keyword,keyword);
    }
}
