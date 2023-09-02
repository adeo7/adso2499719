package com.sena.adso2499719.adso2499719.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sena.adso2499719.adso2499719.entities.Profesor;
import com.sena.adso2499719.adso2499719.implementantion.ProfesorService;

@RestController
@RequestMapping("api/profesor")
public class ProfesorController {
	@Autowired 
	private ProfesorService service;
	
	@GetMapping
	public ResponseEntity<?>getAll(){
		return ResponseEntity.ok(service.getAll());
	}
	
	@GetMapping("{id}")
	public ResponseEntity<?>getById(@PathVariable Long id){
		return ResponseEntity.ok(service.getById(id));
	}
	

	public ResponseEntity<?>save(@RequestBody Profesor profesor){
		return ResponseEntity.ok(service.save( profesor));
	}
	
	public ResponseEntity<?>update(@PathVariable Long id, @RequestBody Profesor profesor){
		service.update(id, profesor);
		return ResponseEntity.ok("profesor actualizado");
	}
	
	public ResponseEntity<?>delete(@PathVariable Long id){
		service.delete(id);
		return ResponseEntity.ok("profesor eliminado");
	}
}
