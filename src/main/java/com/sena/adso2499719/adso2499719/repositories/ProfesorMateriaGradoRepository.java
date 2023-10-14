package com.sena.adso2499719.adso2499719.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sena.adso2499719.adso2499719.dtos.ProfesorMateriaGradoDto;
import com.sena.adso2499719.adso2499719.entities.ProfesorMateriaGrado;

@Repository
public interface ProfesorMateriaGradoRepository extends JpaRepository<ProfesorMateriaGrado, Long>{
	
	@Query(value="SELECT \r\n"
			+ "id,\r\n"
			+ "mt.nombre AS materia,\r\n"
			+ "g.nombre AS grado\r\n"
			+ " FROM adso2499719.aprendices;\r\n"
			+ "SELECT pmg.id FROM profesores_materias_grados AS pmg\r\n"
			+ "INNER JOIN materias mt ON mt.id= pmg.materia_id\r\n"
			+ "INNER JOIN grados g ON g.id =pmg.grado_id\r\n"
			+ "WHERE pmg.profesor_id= :profesorId", nativeQuery = true)
	List<ProfesorMateriaGradoDto>getData(Long profesorId);
	
}
