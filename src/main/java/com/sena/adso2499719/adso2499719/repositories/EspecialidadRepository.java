package com.sena.adso2499719.adso2499719.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sena.adso2499719.adso2499719.dtos.EspecialidadDataTableDto;
import com.sena.adso2499719.adso2499719.entities.Especialidad;

@Repository
public interface EspecialidadRepository extends JpaRepository<Especialidad, Long>{
	
	@Query(value="SELECT * FROM especialidades AS esp"
			+ "WHERE CONCAT(esp.nombre)LIKE CONCAT('%', :textobu,'%');")
	Page<EspecialidadDataTableDto>getDataTable(Pageable pageable, @Param("textobu" )String textoBusqueda);
}
