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
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.sena.adso2499719.adso2499719.entities.Materia;
import com.sena.adso2499719.adso2499719.implementantion.MateriaService;

@RestController
@RequestMapping("api/Materia")
public class MateriaController {
	
	@Autowired
	private MateriaService service;
	
	
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
		return ResponseEntity.ok(service.getAll());
	}
	
	@GetMapping("{id}")
	public ResponseEntity<?>getById(@PathVariable Long id){
		return ResponseEntity.ok(service.getById(id));
	}
	
	@PutMapping
	public ResponseEntity<?>save(@RequestBody Materia materia){
		return ResponseEntity.ok(service.save( materia));
	}
	@PutMapping("{id}")
	public ResponseEntity<?>update(@PathVariable Long id, @RequestBody  Materia materia){
		service.update(id, materia);
		return ResponseEntity.ok("materia actualizada");
	}
	@DeleteMapping("{id}")
	public ResponseEntity<?>delete(@PathVariable Long id){
		service.delete(id);
		return ResponseEntity.ok("materia eliminada");
	}
}
