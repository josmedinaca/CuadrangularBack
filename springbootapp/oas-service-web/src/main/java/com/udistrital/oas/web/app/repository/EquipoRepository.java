package com.udistrital.oas.web.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.udistrital.oas.web.app.model.Equipo;
//JpaRepository
public interface EquipoRepository extends JpaRepository<Equipo, Integer>  {
	Equipo findByIdEquipo(Integer idEquipo);
	
	
	
}
