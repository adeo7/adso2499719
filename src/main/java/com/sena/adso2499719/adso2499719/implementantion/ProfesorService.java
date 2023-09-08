package com.sena.adso2499719.adso2499719.implementantion;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.sena.adso2499719.adso2499719.dtos.ProfesoresDataTableDto;
import com.sena.adso2499719.adso2499719.entities.Profesor;
import com.sena.adso2499719.adso2499719.interfaces.IProfesorService;
import com.sena.adso2499719.adso2499719.repositories.ProfesorRepository;
@Service
public class ProfesorService implements IProfesorService{
	
	@Autowired
	private ProfesorRepository repository;
	
	@Override
	public Profesor save(Profesor profesor) {
		profesor.setCreateAt(LocalDateTime.now());
		return repository.save(profesor);
	}

	@Override
	public void update(Long id, Profesor profesor) {
		Optional<Profesor>profesorBDot=repository.findById(id);
		if (profesorBDot.isEmpty()) {
			return;
		}
		Profesor profesorBD=profesorBDot.get();
		profesorBD.setNombre(profesor.getNombre());
		profesorBD.setApellido(profesor.getApellido());
		profesorBD.setEspecialidad(profesor.getEspecialidad());
		profesorBD.setUpdateAt(LocalDateTime.now());
		
		repository.save(profesorBD);
		
	}

	@Override
	public void delete(Long id) {
		repository.deleteById(id);
		
	}

	@Override
	public List<Profesor> getAll() {
		return repository.findAll();
	}

	@Override
	public Profesor getById(Long id) {
		
		Optional<Profesor>profesorBDot=repository.findById(id);
		if (profesorBDot.isEmpty()) {
			return null;
		}
		Profesor profesorBD=profesorBDot.get();
		return profesorBD;
	}

	@Override
	public Page<ProfesoresDataTableDto> getDataTable (Pageable pageable, String textoBusqueda) {
		return repository.getDataTable(pageable, textoBusqueda);
	}

}
