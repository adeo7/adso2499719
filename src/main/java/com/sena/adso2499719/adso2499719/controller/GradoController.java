package com.sena.adso2499719.adso2499719.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.sena.adso2499719.adso2499719.entities.Grado;
import com.sena.adso2499719.adso2499719.implementantion.GradoService;

@RestController
@RequestMapping("api/grado")
public class GradoController {

	@Autowired
	private GradoService service;
	
	@GetMapping
	public ResponseEntity<?>getAll(){
		return ResponseEntity.ok(service.getAll());
	}
	
	@GetMapping("{id}")
	public ResponseEntity<?>getById(@PathVariable Long id){
		return ResponseEntity.ok(service.getById(id));
	}
	

	public ResponseEntity<?>save(@RequestBody Grado grado){
		return ResponseEntity.ok(service.save( grado));
	}
	
	public ResponseEntity<?>update(@PathVariable Long id, @RequestBody Grado grado){
		service.update(id, grado);
		return ResponseEntity.ok("grado actualizado");
	}
	
	public ResponseEntity<?>delete(@PathVariable Long id){
		service.delete(id);
		return ResponseEntity.ok("grado eliminado");
	}
}
