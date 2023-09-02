package com.sena.adso2499719.adso2499719.interfaces;

import java.util.List;
import java.util.Optional;

import com.sena.adso2499719.adso2499719.entities.Materia;



public interface IMateriaService {
	Materia save(Materia materia);
	 
	 void update (Long id, Materia materia);
	 
	 void delete(Long id);
	 
	 List<Materia>getAll();
	 
	 Optional<Materia>getById(Long id);
}
