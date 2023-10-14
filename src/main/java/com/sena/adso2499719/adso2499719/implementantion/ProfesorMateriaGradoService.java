package com.sena.adso2499719.adso2499719.implementantion;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.sena.adso2499719.adso2499719.dtos.MateriaDataTableDto;
import com.sena.adso2499719.adso2499719.dtos.ProfesorMateriaGradoDto;
import com.sena.adso2499719.adso2499719.entities.ProfesorMateriaGrado;
import com.sena.adso2499719.adso2499719.interfaces.IProfesorMateriaGradoService;
import com.sena.adso2499719.adso2499719.repositories.ProfesorMateriaGradoRepository;

@Service
public class ProfesorMateriaGradoService implements IProfesorMateriaGradoService{
	
	@Autowired
	private ProfesorMateriaGradoRepository repository;

	@Override
	public ProfesorMateriaGrado save(ProfesorMateriaGrado PMGrado) {
		
		return repository.save(PMGrado);
	}

	@Override
	public void delete(Long id) {
		repository.deleteById(id);
		
	}

	@Override
	public List<ProfesorMateriaGradoDto> getData(Long profesorId) {
		
		return repository.getData(profesorId);
	}
	

}
