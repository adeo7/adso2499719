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
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sena.adso2499719.adso2499719.dtos.ApiResponseDto;
import com.sena.adso2499719.adso2499719.entities.Profesor;
import com.sena.adso2499719.adso2499719.implementantion.ProfesorService;


@RestController
@RequestMapping("api/profesor")
@CrossOrigin("*")
public class ProfesorController {
	@Autowired 
	private ProfesorService service;
	
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
	public ResponseEntity<ApiResponseDto<List<Profesor>>>getAll(){
		try {
			return ResponseEntity.ok(
					new ApiResponseDto<List<Profesor>>("Datos obtenidos", true,service.getAll())
					);
		} catch (Exception e) {
			return ResponseEntity.internalServerError().body(
					new ApiResponseDto<List<Profesor>>(e.getMessage(), false,null)
					);
		}
		
	}
	
	@GetMapping("{id}")
	public ResponseEntity<ApiResponseDto<Profesor>>getById(@PathVariable Long id){
		try {
			return ResponseEntity.ok(
					new ApiResponseDto<Profesor>("Datos obtenidos", true, service.getById(id))
					);
		} catch (Exception e) {
			return ResponseEntity.internalServerError().body(
					new ApiResponseDto<Profesor>(e.getMessage(), false,null)
					);
		}
		
	}
	
	@PostMapping
	public ResponseEntity<ApiResponseDto<Profesor>>save(@RequestBody Profesor profesor){
		try {
			return ResponseEntity.ok(
					new ApiResponseDto<Profesor>("Datos Guardados", true, service.save(profesor))
					);
		} catch (Exception e) {
			return ResponseEntity.internalServerError().body(
					new ApiResponseDto<Profesor>(e.getMessage(), false,null)
					);
		}
		
	}
	@PutMapping("{id}")
	public ResponseEntity<ApiResponseDto<Profesor>>update(@PathVariable Long id, @RequestBody Profesor profesor){
		try {
			service.update(id, profesor);
			return ResponseEntity.ok(
					new ApiResponseDto<Profesor>("Datos Actualizados", true, null)
					);
		} catch (Exception e) {
			return ResponseEntity.internalServerError().body(
					new ApiResponseDto<Profesor>(e.getMessage(), false,null)
					);
		}
	}
	@DeleteMapping("{id}")
	public ResponseEntity<ApiResponseDto<Profesor>>delete(@PathVariable Long id){
		try {
			service.delete(id);
			return ResponseEntity.ok(
					new ApiResponseDto<Profesor>("Datos Eliminados", true, null)
					);
		} catch (Exception e) {
			return ResponseEntity.internalServerError().body(
					new ApiResponseDto<Profesor>(e.getMessage(), false,null)
					);
		}
	}
}
