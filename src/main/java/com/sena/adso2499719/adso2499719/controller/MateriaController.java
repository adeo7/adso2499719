package com.sena.adso2499719.adso2499719.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sena.adso2499719.adso2499719.entities.Grado;
import com.sena.adso2499719.adso2499719.entities.Materia;
import com.sena.adso2499719.adso2499719.implementantion.MateriaService;
import com.sena.adso2499719.adso2499719.repositories.MateriaRepository;

@RestController
@RequestMapping("api/Materia")
public class MateriaController {
	
	@Autowired
	private MateriaService service;
	
	@GetMapping
	public ResponseEntity<?>getAll(){
		return ResponseEntity.ok(service.getAll());
	}
	
	@GetMapping("{id}")
	public ResponseEntity<?>getById(@PathVariable Long id){
		return ResponseEntity.ok(service.getById(id));
	}
	

	public ResponseEntity<?>save(@RequestBody Materia materia){
		return ResponseEntity.ok(service.save( materia));
	}
	
	public ResponseEntity<?>update(@PathVariable Long id, @RequestBody  Materia materia){
		service.update(id, materia);
		return ResponseEntity.ok("materia actualizada");
	}
	
	public ResponseEntity<?>delete(@PathVariable Long id){
		service.delete(id);
		return ResponseEntity.ok("materia eliminada");
	}
}
