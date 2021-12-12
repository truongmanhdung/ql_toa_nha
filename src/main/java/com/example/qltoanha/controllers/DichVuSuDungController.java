package com.example.qltoanha.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.qltoanha.models.entity.DichVuSuDung;
import com.example.qltoanha.repository.DVSuDungRepository;

@RestController
@CrossOrigin("*")
@RequestMapping("/dichvusudung")
public class DichVuSuDungController {
	@Autowired
	private DVSuDungRepository repo;
	@GetMapping
	public List<DichVuSuDung> getAll() {
		return (List<DichVuSuDung>) repo.findAll();
	}
	@PostMapping
	public DichVuSuDung create(DichVuSuDung dv) {
		return repo.save(dv);
	}
	@PutMapping("/{id}")
	public DichVuSuDung update(DichVuSuDung dv, @PathVariable("id") int id) {
		Optional<DichVuSuDung> exist = repo.findById(id);
		if(exist.isEmpty()) {
			DichVuSuDung d = exist.get();
			d.setGia(dv.getGia());
			d.setGiamGia(dv.getGiamGia());
			d.setSoLuong(dv.getSoLuong());
			return repo.save(d);
		}
		return null;
	}
	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id")int id) {
		repo.deleteById(id);
	}
	

}
