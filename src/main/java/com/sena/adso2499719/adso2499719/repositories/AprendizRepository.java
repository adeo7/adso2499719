package com.sena.adso2499719.adso2499719.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sena.adso2499719.adso2499719.dtos.AprendizDataTableDto;
import com.sena.adso2499719.adso2499719.entities.Aprendiz;

@Repository
public interface AprendizRepository extends JpaRepository<Aprendiz, Long> {

	@Query(value="SELECT id,\r\n"
			+ "nombres,\r\n"
			+ " apellido,\r\n"
			+ " Gr.nombre AS Grado\r\n"
			+ " FROM aprendices\r\n"
			+ " INNER JOIN grados AS Gr ON Gr.id=aprendices.grado_id "
			+ "WHERE CONCAT(A.nombres,A.apellidos,Gr.nombre)LIKE CONCAT('%', :textobu,'%') ", nativeQuery = true)
	Page<AprendizDataTableDto> getDataTable(Pageable pageable, @Param("textobu" ) String textoBusqueda);
}
