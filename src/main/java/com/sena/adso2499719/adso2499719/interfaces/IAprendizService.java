package com.sena.adso2499719.adso2499719.interfaces;

import java.util.List;
import java.util.Optional;

import com.sena.adso2499719.adso2499719.entities.Aprendiz;


public interface IAprendizService {
	
 Aprendiz save(Aprendiz aprendiz);
	 
	 void update (Long id, Aprendiz aprendiz);
	 
	 void delete(Long id);
	 
	 List<Aprendiz>getAll();
	 
	 Optional<Aprendiz>getById(Long id);
}
