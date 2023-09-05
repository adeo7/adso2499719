package com.sena.adso2499719.adso2499719.implementantion;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.sena.adso2499719.adso2499719.dtos.EspecialidadDataTableDto;
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
	public void update(Long id, Especialidad especialidad) throws Exception{
		Optional <Especialidad> especialidadBDpt=repository.findById(id);
		if (especialidadBDpt.isEmpty()) {
			 throw new Exception("no se encontro el registro");
		}
		Especialidad especialidadBD=especialidadBDpt.get();
		especialidadBD.setNombre(especialidad.getNombre());
		especialidadBD.setUpdateAt(LocalDateTime.now());
		
		repository.save(especialidadBD);
	}

	@Override
	public void delete(Long id) throws Exception {
		Optional<Especialidad> especia =repository.findById(id);
		if (especia.isEmpty()) {
		throw new Exception("no se encontro el registro");
		}
		repository.deleteById(id);
		
	}

	@Override
	public List<Especialidad> getAll() {
		
		return repository.findAll();
	}

	@Override
	public Especialidad getById(Long id) throws Exception{
		Optional<Especialidad> especia =repository.findById(id);
		if (especia.isEmpty()) {
		throw new Exception("no se encontro el registro");
		}
		return especia.get();
	}


	@Override
	public Page<EspecialidadDataTableDto> getDataTable(Pageable pageable, String textoBusqueda) {
		return repository.getDataTable(pageable, textoBusqueda);
	}


}
