package com.sena.adso2499719.adso2499719.interfaces;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.sena.adso2499719.adso2499719.dtos.ProfesoresDataTableDto;
import com.sena.adso2499719.adso2499719.entities.Profesor;



public interface IProfesorService {
	
	Page<ProfesoresDataTableDto> getDataTable (Pageable pageable, String textoBusqueda);
	
	Profesor save(Profesor profesor);
	 
	 void update (Long id, Profesor profesor);
	 
	 void delete(Long id);
	 
	 List<Profesor>getAll();
	 
	 Optional<Profesor>getById(Long id);
}
