package com.sena.adso2499719.adso2499719.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sena.adso2499719.adso2499719.dtos.GradoDataTableDto;
import com.sena.adso2499719.adso2499719.entities.Grado;

@Repository
public interface GradoRepository extends JpaRepository<Grado, Long>{
@Query(value="SELECT "
		+ " id "
		+ " nombre "
		+ " jornada "
		+ " salon "
		+ " FROM grados AS g "
		+ " WHERE CONCAT(g.nombre)LIKE CONCAT('%', :textobu,'%') ", nativeQuery = true)
Page<GradoDataTableDto>getDataTable(Pageable pageable, @Param("textobu" )String textoBusqueda);
}
