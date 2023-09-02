package com.sena.adso2499719.adso2499719.implementantion;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.adso2499719.adso2499719.entities.Especialidad;
import com.sena.adso2499719.adso2499719.interfaces.IEspecialidadServices;
import com.sena.adso2499719.adso2499719.repositories.EspecialidadRepository;
@Service
public class EspecialidadServices implements IEspecialidadServices {
	
	
	@Autowired
	private EspecialidadRepository repository;
	
	/*guardar*/
	@Override
	public Especialidad save(Especialidad especialidad) {
		especialidad.setCreateAt(LocalDateTime.now());
		return repository.save(especialidad);
	}

	
	@Override
	public void update(Long id, Especialidad especialidad) {
		Optional <Especialidad> especialidadBDpt=repository.findById(id);
		if (especialidadBDpt.isEmpty()) {
			return;
		}
		Especialidad especialidadBD=especialidadBDpt.get();
		especialidadBD.setNombre(especialidad.getNombre());
		especialidadBD.setUpdateAt(LocalDateTime.now());
		
		repository.save(especialidadBD);
	}

	@Override
	public void delete(Long id) {
		repository.deleteById(id);
		
	}

	@Override
	public List<Especialidad> getAll() {
		
		return repository.findAll();
	}

	@Override
	public Optional<Especialidad> getById(Long id) {
		return repository.findById(id);
	}


}
