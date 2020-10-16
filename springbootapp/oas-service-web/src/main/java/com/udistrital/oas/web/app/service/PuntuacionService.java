package com.udistrital.oas.web.app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.udistrital.oas.web.app.model.Puntuacion;
import com.udistrital.oas.web.app.repository.PuntuacionRepository;

@Service
public class PuntuacionService {
	private final PuntuacionRepository puntuacionRepository;

	public PuntuacionService(PuntuacionRepository puntuacionRepository) {

		this.puntuacionRepository = puntuacionRepository;
	}
	public void save(Puntuacion puntuacion) {
		puntuacionRepository.save(puntuacion);
	}
	
	public List<Puntuacion> findAll(){
		return puntuacionRepository.findAll();
	}
	
}
