package com.sena.adso2499719.adso2499719.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.sena.adso2499719.adso2499719.dtos.MateriaDataTableDto;
import com.sena.adso2499719.adso2499719.entities.Materia;

@Repository
public interface MateriaRepository extends JpaRepository<Materia, Long>{
	
	@Query(value=" SELECT "
			+ " id, "
			+ " nombre "
			+ " FROM materias AS m "
			+ "  WHERE CONCAT(m.nombre)LIKE CONCAT('%', :textobu,'%') ", nativeQuery = true)
	Page<MateriaDataTableDto>getDataTable(Pageable pageable, @Param("textobu" )String textoBusqueda);
}
