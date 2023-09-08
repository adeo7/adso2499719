package com.sena.adso2499719.adso2499719.interfaces;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.sena.adso2499719.adso2499719.dtos.MateriaDataTableDto;
import com.sena.adso2499719.adso2499719.entities.Materia;



public interface IMateriaService {
	
	
	Page<MateriaDataTableDto> getDataTable (Pageable pageable, String textoBusqueda);
	
	Materia save(Materia materia);
	 
	 void update (Long id, Materia materia);
	 
	 void delete(Long id);
	 
	 List<Materia>getAll();
	 
	 Materia getById(Long id);
}
