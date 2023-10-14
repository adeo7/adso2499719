package com.sena.adso2499719.adso2499719.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sena.adso2499719.adso2499719.dtos.ApiResponseDto;
import com.sena.adso2499719.adso2499719.dtos.ProfesorMateriaGradoDto;
import com.sena.adso2499719.adso2499719.entities.ProfesorMateriaGrado;
import com.sena.adso2499719.adso2499719.implementantion.ProfesorMateriaGradoService;

@RestController
@RequestMapping("api/PMG")
@CrossOrigin("*")
public class ProfesorMateriaGradoController { 
	
	@Autowired
	private ProfesorMateriaGradoService service;
	
	@GetMapping("{profesorId}")
	public ResponseEntity<ApiResponseDto<List<ProfesorMateriaGradoDto>>>getData(@PathVariable Long profesorId){
		
		try {
			return ResponseEntity.ok(
					new ApiResponseDto<List<ProfesorMateriaGradoDto>>("datos obtenidos", true, service.getData(profesorId))
					);
		} catch (Exception e) {
			return ResponseEntity.internalServerError().body(
					new ApiResponseDto<List<ProfesorMateriaGradoDto>>(e.getMessage(), false, null)
					);
		}
	
	}
	
	@PostMapping
	public ResponseEntity< ApiResponseDto<ProfesorMateriaGrado>>save(@RequestBody ProfesorMateriaGrado PMGrado){
		try {
			return ResponseEntity.ok(
					new ApiResponseDto<ProfesorMateriaGrado>("datos guardados", true, service.save(PMGrado))
					);
		} catch (Exception e) {
			return ResponseEntity.internalServerError().body(
					new ApiResponseDto<ProfesorMateriaGrado>(e.getMessage(), false,null)
					);
		}
		
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<ApiResponseDto<ProfesorMateriaGrado>>delete(@PathVariable Long id){
		try {
			service.delete(id);
			return ResponseEntity.ok(
					new ApiResponseDto<ProfesorMateriaGrado>("Datos Eliminados", true, null)
					);
		} catch (Exception e) {
			return ResponseEntity.internalServerError().body(
					new ApiResponseDto<ProfesorMateriaGrado>(e.getMessage(), false,null)
					);
		}
	}
	
}
