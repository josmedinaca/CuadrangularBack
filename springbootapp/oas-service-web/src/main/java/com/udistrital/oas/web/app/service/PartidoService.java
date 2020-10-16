package com.udistrital.oas.web.app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.udistrital.oas.web.app.model.Partido;
import com.udistrital.oas.web.app.repository.PartidoRepository;

@Service
public class PartidoService {
	private final PartidoRepository partidoRepository;

	public PartidoService(PartidoRepository partidoRepository) {
		this.partidoRepository = partidoRepository;
	}
	
	public void save(Partido partido) {
		partidoRepository.save(partido);
	}
	
	public List<Partido> findAll() {
		return partidoRepository.findAll();
	}
	
	public Partido findByIdPartido(Integer id) {
		return partidoRepository.findByIdPartido(id);
	}
	
}
