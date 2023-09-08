package com.sena.adso2499719.adso2499719.implementantion;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.sena.adso2499719.adso2499719.dtos.AprendizDataTableDto;
import com.sena.adso2499719.adso2499719.entities.Aprendiz;
import com.sena.adso2499719.adso2499719.interfaces.IAprendizService;
import com.sena.adso2499719.adso2499719.repositories.AprendizRepository;

@Service
public class AprendizService implements IAprendizService {
	
	@Autowired
	private AprendizRepository repository;
	@Override
	public Aprendiz save(Aprendiz aprendiz) {
		aprendiz.setCreateAt(LocalDateTime.now());
		return repository.save(aprendiz);
	}

	@Override
	public void update(Long id, Aprendiz aprendiz) {
	
		Optional<Aprendiz>aprendozBDot=repository.findById(id);
		if (aprendozBDot.isEmpty()) {
			return;
		}
		Aprendiz aprendizBD=aprendozBDot.get();
		aprendizBD.setApellido(aprendiz.getApellido());
		aprendizBD.setNombre(aprendiz.getNombre());
		aprendizBD.setGrado(aprendiz.getGrado());
		aprendizBD.setUpdateAt(LocalDateTime.now());
		
		repository.save(aprendizBD);
		
		
	}

	@Override
	public void delete(Long id) {
		
		repository.deleteById(id);
		
	}

	@Override
	public List<Aprendiz> getAll() {
		
		return repository.findAll();
	}

	@Override
	public Aprendiz getById(Long id) {
		
		Optional<Aprendiz>aprendizBDot=repository.findById(id);
		if (aprendizBDot.isEmpty()) {
			return null;
		}
		Aprendiz aprendizBD=aprendizBDot.get();
		return aprendizBD;
	}

	@Override
	public Page<AprendizDataTableDto> getDataTable(Pageable pageable, String textoBusqueda) {
		return repository.getDataTable(pageable, textoBusqueda);
	}

}
