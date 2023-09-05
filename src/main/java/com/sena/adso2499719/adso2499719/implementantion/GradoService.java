package com.sena.adso2499719.adso2499719.implementantion;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.sena.adso2499719.adso2499719.dtos.GradoDataTableDto;
import com.sena.adso2499719.adso2499719.entities.Grado;
import com.sena.adso2499719.adso2499719.interfaces.IGradoService;
import com.sena.adso2499719.adso2499719.repositories.GradoRepository;
@Service
public class GradoService implements IGradoService {

	@Autowired
	private GradoRepository repository;
	@Override
	public Grado save(Grado grado) {
		grado.setCreateAt(LocalDateTime.now());
		return repository.save(grado);
	}

	@Override
	public void update(Long id, Grado grado) {
		Optional<Grado> gradoBdot= repository.findById(id);
		if (gradoBdot.isEmpty()) {
			return;
		}
		Grado gradoBd=gradoBdot.get();
		gradoBd.setNombre(grado.getNombre());
		gradoBd.setSalon(grado.getSalon());
		gradoBd.setJornada(grado.getJornada());
		gradoBd.setUpdateAt(LocalDateTime.now());
		
		repository.save(gradoBd);
		
	}

	@Override
	public void delete(Long id) {
		repository.deleteById(id);
		
	}

	@Override
	public List<Grado> getAll() {
		
		return repository.findAll();
	}

	@Override
	public Optional<Grado> getById(Long id) {
		return repository.findById(id);
	}

	@Override
	public Page<GradoDataTableDto> getDataTable(Pageable pageable, String textoBusqueda) {
		return repository.getDataTable(pageable, textoBusqueda);
	}

}
