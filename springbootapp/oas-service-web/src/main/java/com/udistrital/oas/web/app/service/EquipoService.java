package com.udistrital.oas.web.app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.udistrital.oas.web.app.model.Equipo;
import com.udistrital.oas.web.app.model.Partido;
import com.udistrital.oas.web.app.repository.EquipoRepository;

@Service
public class EquipoService {
	private final EquipoRepository equipoRepository;

	public EquipoService(EquipoRepository equipoRepository) {

		this.equipoRepository = equipoRepository;
	}
	
	public void save(Equipo equipo) {
		equipoRepository.save(equipo);
	}
	
	public List<Equipo> findAll(){
		return equipoRepository.findAll();
	}
	
	public Equipo findById(Integer id) {
		return equipoRepository.findByIdEquipo(id);
	}
}
