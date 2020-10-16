package com.udistrital.oas.web.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.udistrital.oas.web.app.model.Puntuacion;

public interface PuntuacionRepository extends JpaRepository<Puntuacion, Integer> {
	Puntuacion findByIdPuntuacion(Integer idPuntuacion);
	
	
}
