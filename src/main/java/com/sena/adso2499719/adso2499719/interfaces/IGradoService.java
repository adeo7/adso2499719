package com.sena.adso2499719.adso2499719.interfaces;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.sena.adso2499719.adso2499719.dtos.GradoDataTableDto;
import com.sena.adso2499719.adso2499719.entities.Grado;



public interface IGradoService {
	
	Page<GradoDataTableDto> getDataTable (Pageable pageable, String textoBusqueda);
	
	Grado save(Grado grado);
	 
	 void update (Long id, Grado grado);
	 
	 void delete(Long id);
	 
	 List<Grado>getAll();
	 
	Grado getById(Long id);
}
