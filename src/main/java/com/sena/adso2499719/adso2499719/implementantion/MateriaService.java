package com.sena.adso2499719.adso2499719.implementantion;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.sena.adso2499719.adso2499719.dtos.MateriaDataTableDto;
import com.sena.adso2499719.adso2499719.entities.Materia;
import com.sena.adso2499719.adso2499719.interfaces.IMateriaService;
import com.sena.adso2499719.adso2499719.repositories.MateriaRepository;
@Service
public class MateriaService implements IMateriaService{

	@Autowired
	private MateriaRepository repository;
	@Override
	public Materia save(Materia materia) {
		materia.setCreateAt(LocalDateTime.now());
		return repository.save(materia);
	}

	@Override
	public void update(Long id, Materia materia) {
	Optional<Materia> materiaBDot=repository.findById(id);
	if (materiaBDot.isEmpty()) {
		return;
	}
	Materia materiaBD=materiaBDot.get();
	materiaBD.setNombre(materia.getNombre());
	materiaBD.setUpdateAt(LocalDateTime.now());
	
	repository.save(materiaBD);
		
	}

	@Override
	public void delete(Long id) {
		repository.deleteById(id);		
	}

	@Override
	public List<Materia> getAll() {
		return repository.findAll();
	}

	@Override
	public Materia getById(Long id) {
		Optional<Materia> materiaBDot=repository.findById(id);
		if (materiaBDot.isEmpty()) {
			return null;
		}
		Materia materiaBD=materiaBDot.get();
		
		return materiaBD;
	}

	@Override
	public Page<MateriaDataTableDto> getDataTable(Pageable pageable, String textoBusqueda) {
		return repository.getDataTable(pageable, textoBusqueda);
	}

}
