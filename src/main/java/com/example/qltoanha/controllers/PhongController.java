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
    
    @GetMapping("/toanha={ii}/index={i}")
    public List<Phong> getAllInPageByToaNha(@PathVariable("i") int index, @PathVariable("ii") int id){
        return (List<Phong>) repo.findAllInPageByToaNha(id, index);
    }
    
    @GetMapping("/toanha={ii}")
    public List<Phong> getAllByToaNha(@PathVariable("ii") int id){
        return (List<Phong>) repo.findAllPhongByToaNha(id);
    }
    
    @GetMapping("/index={ii}")
    public List<Phong> getPage(@PathVariable("ii") int id){
        return (List<Phong>) repo.findAllPage(id);
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
    
    @GetMapping("/search={key}")
    public List<Phong>search(@PathVariable("key") String key) {
    	return repo.findAllByNameContaining(key);
    }
    
    @GetMapping("/filter/less={price}")
    public List<Phong>filterLess(@PathVariable("price") int price){
    	return repo.findAllByPriceIsLessThanEqual(price);
    }
    
    @GetMapping("/filter/greater={price}")
    public List<Phong>filterGreater(@PathVariable("price") int price){
    	return repo.findAllByPriceIsGreaterThanEqual(price);
    }
    
    @GetMapping("/filter/less={price}&&greater={price2}")
    public List<Phong>filterLess(@PathVariable("price") int price, @PathVariable("price2") int price2){
    	return repo.findAllByPriceIsLessThanEqualAndPriceIsGreaterThanEqual(price, price2);
    }
}
