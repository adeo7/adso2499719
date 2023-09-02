package com.sena.adso2499719.adso2499719.interfaces;

import java.util.List;
import java.util.Optional;

import com.sena.adso2499719.adso2499719.entities.Profesor;



public interface IProfesorService {
	
	Profesor save(Profesor profesor);
	 
	 void update (Long id, Profesor profesor);
	 
	 void delete(Long id);
	 
	 List<Profesor>getAll();
	 
	 Optional<Profesor>getById(Long id);
}
