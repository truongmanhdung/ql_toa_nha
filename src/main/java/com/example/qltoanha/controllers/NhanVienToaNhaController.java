package com.example.qltoanha.controllers;

import com.example.qltoanha.models.NhanVienToaNha;
import com.example.qltoanha.models.Phong;
import com.example.qltoanha.repository.NVToaNhaRepository;
import com.example.qltoanha.repository.PhongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/nvtoanha")
@CrossOrigin("*")
public class NhanVienToaNhaController {
    @Autowired
    private NVToaNhaRepository repo;

    @GetMapping
    public List<NhanVienToaNha> getAll(){
        return (List<NhanVienToaNha>) repo.findAll();
    }
    @GetMapping("/{id}")
    public NhanVienToaNha getById(@PathVariable("id") int id){
        Optional<NhanVienToaNha> x = repo.findById(id);
        if(x.isPresent()){
            return  x.get();
        }
        return null;
    }
    @PostMapping
    public NhanVienToaNha create(@RequestBody NhanVienToaNha x){
        return repo.save(x);
    }
    @PutMapping("/{id}")
    public NhanVienToaNha update(@RequestBody NhanVienToaNha ph, @PathVariable("id") int id){
        Optional<NhanVienToaNha> p = repo.findById(id);
        if(p.isPresent()){
            NhanVienToaNha x = p.get();
            x.setTen(ph.getTen());
            x.setBac(ph.getBac());
            x.setDiaChi(ph.getDiaChi());
            x.setNgaySinh(ph.getNgaySinh());
            x.setSdt(ph.getSdt());
            x.setViTri(ph.getViTri());
            return repo.save(x);
        }
        return null;
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") int id){
        repo.deleteById(id);
    }
}
