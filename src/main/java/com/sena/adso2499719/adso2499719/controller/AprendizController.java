package com.sena.adso2499719.adso2499719.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sena.adso2499719.adso2499719.entities.Aprendiz;
import com.sena.adso2499719.adso2499719.implementantion.AprendizService;

@RestController
@RequestMapping("api/aprendiz")
public class AprendizController {
	
	@Autowired
	private AprendizService service;
	
	@GetMapping
	public ResponseEntity<?>getAll(){
		return ResponseEntity.ok(service.getAll());
	}
	
	@GetMapping("{id}")
	public ResponseEntity<?>getById(@PathVariable Long id){
		return ResponseEntity.ok(service.getById(id));
	}
	

	public ResponseEntity<?>save(@RequestBody Aprendiz aprendiz){
		return ResponseEntity.ok(service.save(aprendiz));
	}
	
	public ResponseEntity<?>update(@PathVariable Long id, @RequestBody Aprendiz aprendiz){
		service.update(id, aprendiz);
		return ResponseEntity.ok("Aprendiz actualizado");
	}
	
	public ResponseEntity<?>delete(@PathVariable Long id){
		service.delete(id);
		return ResponseEntity.ok("aprendiz eliminado");
	}
}
