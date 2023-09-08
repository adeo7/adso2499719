package com.sena.adso2499719.adso2499719.interfaces;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.sena.adso2499719.adso2499719.dtos.AprendizDataTableDto;
import com.sena.adso2499719.adso2499719.entities.Aprendiz;


public interface IAprendizService {
	
	Page<AprendizDataTableDto> getDataTable (Pageable pageable, String textoBusqueda);
	
	Aprendiz save(Aprendiz aprendiz);
	 
	 void update (Long id, Aprendiz aprendiz);
	 
	 void delete(Long id);
	 
	 List<Aprendiz>getAll();
	 
	 Aprendiz getById(Long id);
}
