package com.sena.adso2499719.adso2499719.interfaces;

import java.util.List;
import java.util.Optional;

import com.sena.adso2499719.adso2499719.entities.Especialidad;

public interface IEspecialidadServices {

	 Especialidad save(Especialidad especialidad);
	 
	 void update (Long id, Especialidad especialidad);
	 
	 void delete(Long id);
	 
	 List<Especialidad>getAll();
	 
	 Optional<Especialidad>getById(Long id);
}
