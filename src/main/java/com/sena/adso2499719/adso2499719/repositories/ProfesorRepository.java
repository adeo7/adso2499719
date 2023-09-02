package com.sena.adso2499719.adso2499719.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sena.adso2499719.adso2499719.entities.Profesor;

@Repository
public interface ProfesorRepository extends JpaRepository<Profesor, Long>{

}
