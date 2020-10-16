package com.udistrital.oas.web.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.udistrital.oas.web.app.model.Partido;

public interface PartidoRepository extends JpaRepository<Partido, Integer> {
	Partido findByIdPartido(Integer idPartido);
}
