package com.sena.adso2499719.adso2499719.interfaces;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.sena.adso2499719.adso2499719.dtos.MateriaDataTableDto;
import com.sena.adso2499719.adso2499719.dtos.ProfesorMateriaGradoDto;
import com.sena.adso2499719.adso2499719.entities.ProfesorMateriaGrado;


public interface IProfesorMateriaGradoService {
	
	ProfesorMateriaGrado save(ProfesorMateriaGrado PMGrado);
	 
	 void delete(Long id);
	 
	 List<ProfesorMateriaGradoDto>getData(Long prifesorId);
	 
}
