package com.sena.adso2499719.adso2499719.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sena.adso2499719.adso2499719.entities.Especialidad;
import com.sena.adso2499719.adso2499719.interfaces.IEspecialidadServices;

@RestController
@RequestMapping("api/especialidad")
public class EpecialidadController {

	@Autowired
	private IEspecialidadServices service;
	
	@GetMapping
	public ResponseEntity<?>getAll(){
		return ResponseEntity.ok(service.getAll());
	}
	
	@GetMapping("{id}")
	public ResponseEntity<?>getById(@PathVariable Long id){
		return ResponseEntity.ok(service.getById(id));
	}
	

	public ResponseEntity<?>save(@RequestBody Especialidad especialidad){
		return ResponseEntity.ok(service.save(especialidad));
	}
	
	public ResponseEntity<?>update(@PathVariable Long id, @RequestBody Especialidad especialidad){
		service.update(id, especialidad);
		return ResponseEntity.ok("Especilidad actualizada");
	}
	
	public ResponseEntity<?>delete(@PathVariable Long id){
		service.delete(id);
		return ResponseEntity.ok("Especialidad eliminada");
	}
	
	
	
}
