package com.nathan.spring_api.controller;

//import java.util.HashMap;
import java.util.List;
//import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nathan.spring_api.entity.Employe;
import com.nathan.spring_api.repository.EmployeRepository;


@RestController
@RequestMapping("/api/v1")
public class EmployeController {

	@Autowired
	EmployeRepository employeRepository;
	
	@GetMapping("/employees")
	public List<Employe> getAllEmploye(){
		List<Employe> all = employeRepository.findAll();
		return all;
	}
	
	@GetMapping("/employees/{id}")
	public ResponseEntity<Employe> getEmployeById(@PathVariable(value = "id") Integer id) {
		Employe employe = employeRepository.findById(id).orElse(null);
		
		return (employe == null) ? ResponseEntity.notFound().build() : ResponseEntity.ok(employe);

	}
	
	@PostMapping("/employees")
	public Employe create(@RequestBody Employe employe) {
		Employe saved = employeRepository.save(employe);
		return saved;
	}
	
	@PutMapping("/employees/{id}")
	public ResponseEntity<Employe> update(@PathVariable(value = "id") Integer id, @RequestBody Employe employeUpdate){
		Employe employe = employeRepository.findById(id).orElse(null);
		
		if(employe == null) {
			ResponseEntity.notFound().build();
		}
		employe.setEmail(employeUpdate.getEmail());
		employe.setNom(employeUpdate.getNom());
		employe.setTelephone(employeUpdate.getTelephone());
		employe.setVille(employeUpdate.getVille());
		
		final Employe updated = employeRepository.save(employe);
		return ResponseEntity.ok(updated);
	}
	
	@DeleteMapping("/employees/{id}")
	public ResponseEntity<Employe> delete(@PathVariable(value = "id") Integer id){
		Employe employe = employeRepository.findById(id).orElse(null);
		if(employe == null) {
			return ResponseEntity.notFound().build();
		}
		employeRepository.delete(employe);
		
		return ResponseEntity.ok(employe);

	}
	
//	@DeleteMapping("/employees/{id}")
//	public Map<String, Boolean> delete(@PathVariable(value = "id") Integer id){
//		Employe employe = employeRepository.findById(id).get();
//		employeRepository.delete(employe);
//		Map<String, Boolean> response = new HashMap<>();
//		
//		response.put("deleted", Boolean.TRUE);
//		
//		return response;
//	}
	
	
	
	
}
