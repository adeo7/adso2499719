package com.sena.adso2499719.adso2499719.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sena.adso2499719.adso2499719.entities.Especialidad;
import com.sena.adso2499719.adso2499719.interfaces.IEspecialidadServices;

@RestController
@RequestMapping("api/especialidad")
public class EpecialidadController {

	@Autowired
	private IEspecialidadServices service;
	
	
	@GetMapping("datatable")
	public ResponseEntity<Page<?>>dataTable(@RequestParam(name= "page" )Integer page,
			@RequestParam(name ="size")Integer size,
			@RequestParam(name ="column_order")String columnOrder,
			@RequestParam(name ="column_direction")String columnDirection,
			@RequestParam(name ="search", required=false)String search){
		List<Order>orders= new ArrayList<>();
		
		if (columnDirection.equals("ASC")) {
			orders.add(
					new Order (Direction.ASC, columnOrder)
					);
		}else {
			orders.add(
					new Order (Direction.DESC, columnOrder)
					);
		}
		
		if (search==null) {
			search="";
		}
		return ResponseEntity.ok(service.getDataTable(PageRequest.of(page, size,Sort.by(orders)), search));
	}
	
	
	@GetMapping
	public ResponseEntity<?>getAll(){
		try {
			return ResponseEntity.ok(service.getAll());	
		} catch (Exception e) {
			return ResponseEntity.internalServerError().body("no se puedo optener los registros");
		}
	}
	
	@GetMapping("{id}")
	public ResponseEntity<?>getById(@PathVariable Long id){
		try {
			return ResponseEntity.ok(service.getById(id));
		} catch (Exception e) {
			return ResponseEntity.internalServerError().body("no se puedo optener los registros");
		}
		
	}
	

	public ResponseEntity<?>save(@RequestBody Especialidad especialidad){
		try {
			return ResponseEntity.ok(service.save(especialidad));
		} catch (Exception e) {
			return ResponseEntity.internalServerError().body("no se puedo optener los registros");
		}
		
	}
	
	public ResponseEntity<?>update(@PathVariable Long id, @RequestBody Especialidad especialidad){
		try {
			service.update(id, especialidad);
			return ResponseEntity.ok("Especilidad actualizada");
		} catch (Exception e) {
			return ResponseEntity.internalServerError().body("no se puedo optener los registros");
		}
		
	}
	
	public ResponseEntity<?>delete(@PathVariable Long id){
		try {
			service.delete(id);
			return ResponseEntity.ok("Especialidad eliminada");
		} catch (Exception e) {
			return ResponseEntity.internalServerError().body("no se puedo optener los registros");
		}
		
	}
	
	
	
}
