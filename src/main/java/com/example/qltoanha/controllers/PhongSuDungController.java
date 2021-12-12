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
import com.example.qltoanha.models.entity.PhongSuDung;
import com.example.qltoanha.repository.DVSuDungRepository;
import com.example.qltoanha.repository.PhongSuDungRepository;

@RestController
@CrossOrigin("*")
@RequestMapping("/phongsudung")
public class PhongSuDungController {
	@Autowired
	private PhongSuDungRepository repo;
	@GetMapping
	public List<PhongSuDung> getAll() {
		return (List<PhongSuDung>) repo.findAll();
	}
	
	@GetMapping("id={id}")
	public List<PhongSuDung> getByToaNha(@PathVariable("id") int id) {
		return (List<PhongSuDung>) repo.findAllByToaNha(id);
	}
	@PostMapping
	public PhongSuDung create(PhongSuDung dv) {
		return repo.save(dv);
	}
	@PutMapping("/{id}")
	public PhongSuDung update(PhongSuDung dv, @PathVariable("id") int id) {
		Optional<PhongSuDung> exist = repo.findById(id);
		if(exist.isEmpty()) {
			PhongSuDung d = exist.get();
			d.setGhiChu(dv.getGhiChu());
			d.setNgayBatDau(dv.getNgayBatDau());
			d.setGiamGia(dv.getGiamGia());
//			d.setDsDichVuSuDung(dv.getDsDichVuSuDung());
			return repo.save(d);
		}
		return null;
	}
	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id")int id) {
		repo.deleteById(id);
	}
}
