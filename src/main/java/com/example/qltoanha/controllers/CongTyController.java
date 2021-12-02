package com.example.qltoanha.controllers;

import com.example.qltoanha.models.entity.CongTy;
import com.example.qltoanha.models.entity.NhanVienCongTy;
import com.example.qltoanha.repository.CongTyRepository;
import org.hibernate.Session;
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

    @GetMapping("/query/search={keyword}")
    public List<CongTy> search(@PathVariable("keyword") String keyword){
        return (List<CongTy>) repo.findAllByTenCongTyContainingOrDiaChiContainingOrMaSoThueContainingOrLinhVucContainingOrSdtContaining(keyword,keyword,keyword,keyword,keyword);
    }

    @GetMapping("/filter/less={keyword}")
    public List<CongTy> filterVonDieuLeLessThanEqual(@PathVariable("keyword") int keyword){
        return (List<CongTy>) repo.findAllByVonDieuLeIsLessThanEqual(keyword);
    }

    @GetMapping("/filter/greater={keyword}")
    public List<CongTy> filterVonDieuLeGreaterThanEqual(@PathVariable("keyword") int keyword){
        return (List<CongTy>) repo.findAllByVonDieuLeIsGreaterThanEqual(keyword);
    }

    @GetMapping("/filter/start={x}&&end{y}")
    public List<CongTy> filterVonDieuLeInRange(@PathVariable("x") int x,@PathVariable("y") int y){
        return (List<CongTy>) repo.findAllByVonDieuLeIsGreaterThanEqualAndVonDieuLeIsLessThanEqual(x,y);
    }
}
