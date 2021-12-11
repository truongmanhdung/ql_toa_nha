package com.example.qltoanha.controllers;

import com.example.qltoanha.models.entity.DichVu;
import com.example.qltoanha.models.entity.NhanVienToaNha;
import com.example.qltoanha.repository.DichVuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping(path = "/dichvu",produces = "application/json")
public class DichVuController {

    @Autowired
    private DichVuRepository repo;

    @GetMapping
    public List<DichVu> getAll(){
        return (List<DichVu>) repo.findAll();
    }
    
    @GetMapping("/index={i}")
    public List<DichVu> getPage(@PathVariable("i") int index){
        return (List<DichVu>) repo.findAllInPage(index);
    }
    
    @GetMapping("/toanha={i}")
    public List<DichVu> getAllByToaNha(@PathVariable("i") int index){
        return (List<DichVu>) repo.findAllByToaNha(index);
    }
    
    @GetMapping("/toanha={i}/index={ii}")
    public List<DichVu> getAllByToaNha(@PathVariable("i") int id,@PathVariable("ii") int index){
        return (List<DichVu>) repo.findAllInPage(id, index);
    }

    @GetMapping("/{id}")
    public DichVu getById(@PathVariable("id") int id){
        Optional<DichVu> x = repo.findById(id);
        if(x.isPresent()){
            return x.get();
        }
        return null;
    }

    @PostMapping
    public DichVu create(@RequestBody DichVu dv){
        return repo.save(dv);
    }

    @PutMapping("{id}")
    public DichVu update(@RequestBody DichVu dv, @PathVariable("id") int id){
        Optional<DichVu> x = repo.findById(id);
        if(x.isPresent()){
            DichVu exist = x.get();
            exist.setDonGia(dv.getDonGia());
            exist.setLoaiDv(dv.getLoaiDv());
            exist.setTenDv(dv.getTenDv());
            return repo.save(exist);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") int id){
        repo.deleteById(id);
    }

    @GetMapping("/search={keyword}")
    public List<DichVu> search(@PathVariable("keyword") String keyword){
        return (List<DichVu>) repo.findAllByTenDvContainingIgnoreCaseOrLoaiDvIgnoreCase(keyword,keyword);
    }

    @GetMapping("/filter/less={keyword}")
    public List<DichVu> filterLessThanEqual(@PathVariable("keyword") int keyword){
        return (List<DichVu>) repo.findAllByDonGiaIsLessThanEqual(keyword);
    }

    @GetMapping("/filter/greatter={keyword}")
    public List<DichVu> filterGreaterThanEqual(@PathVariable("keyword") int keyword){
        return (List<DichVu>) repo.findAllByDonGiaIsGreaterThanEqual(keyword);
    }

    @GetMapping("/filter/start={keyword}&&end={y}")
    public List<DichVu> filterInRange(@PathVariable("keyword") int keyword,@PathVariable("y") int y){
        return (List<DichVu>) repo.findAllByDonGiaIsLessThanEqualAndDonGiaIsGreaterThanEqual(keyword,y);
    }
}
