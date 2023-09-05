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

	@Query(value="SELECT\r\n"
			+ "A.id,\r\n"
			+ "A.nombres,\r\n"
			+ "A.apellidos,\r\n"
			+ "Gr.nombre as grado\r\n"
			+ "FROM aprendices AS A\r\n"
			+ "INNER JOIN grados AS Gr ON Gr.id=A.grado_id\r\n"
			+ "WHERE CONCAT(A.nombres,A.apellidos,Gr.nombre)LIKE CONCAT('%', :textobu,'%');")
	Page<AprendizDataTableDto> getDataTable(Pageable pageable, @Param("textobu" )String textoBusqueda);
}
