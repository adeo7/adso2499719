package com.sena.adso2499719.adso2499719.interfaces;

import java.util.List;
import java.util.Optional;

import com.sena.adso2499719.adso2499719.entities.Grado;



public interface IGradoService {
	
	Grado save(Grado grado);
	 
	 void update (Long id, Grado grado);
	 
	 void delete(Long id);
	 
	 List<Grado>getAll();
	 
	 Optional<Grado>getById(Long id);
}
