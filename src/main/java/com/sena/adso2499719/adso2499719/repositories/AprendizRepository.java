package com.sena.adso2499719.adso2499719.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sena.adso2499719.adso2499719.entities.Aprendiz;

@Repository
public interface AprendizRepository extends JpaRepository<Aprendiz, Long> {

}
