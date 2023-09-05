package com.sena.adso2499719.adso2499719.interfaces;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.sena.adso2499719.adso2499719.dtos.EspecialidadDataTableDto;
import com.sena.adso2499719.adso2499719.entities.Especialidad;

public interface IEspecialidadServices {
	
	Page<EspecialidadDataTableDto> getDataTable (Pageable pageable, String textoBusqueda);

	 Especialidad save(Especialidad especialidad);
	 
	 void update (Long id, Especialidad especialidad) throws Exception;
	 
	 void delete(Long id) throws Exception;
	 
	 List<Especialidad>getAll();
	 
	 Especialidad getById(Long id) throws Exception;
}
