package com.udistrital.oas.web.app.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.udistrital.oas.web.app.POJO.EquipoPOJO;
import com.udistrital.oas.web.app.model.Equipo;
import com.udistrital.oas.web.app.service.EquipoService;

@CrossOrigin
@RestController
public class EquipoController {
	private EquipoService equipoService;

	public EquipoController(EquipoService equipoService) {
		
		this.equipoService = equipoService;
	}
	
	@PostMapping(value = { "registro/equipo" })
	public ResponseEntity registroEquipo(@RequestBody EquipoPOJO equipoPOJO) {

		Equipo newEquipo1 = new Equipo();
		newEquipo1.setNombre(equipoPOJO.getNombre1());
		newEquipo1.setCiudad(equipoPOJO.getCiudad1().toLowerCase());
		newEquipo1.setCorreo(equipoPOJO.getCorreo1().toLowerCase());
		Equipo newEquipo2 = new Equipo();
		newEquipo2.setNombre(equipoPOJO.getNombre2());
		newEquipo2.setCiudad(equipoPOJO.getCiudad2().toLowerCase());
		newEquipo2.setCorreo(equipoPOJO.getCorreo2().toLowerCase());
		Equipo newEquipo3 = new Equipo();
		newEquipo3.setNombre(equipoPOJO.getNombre3());
		newEquipo3.setCiudad(equipoPOJO.getCiudad3().toLowerCase());
		newEquipo3.setCorreo(equipoPOJO.getCorreo3().toLowerCase());
		Equipo newEquipo4 = new Equipo();
		newEquipo4.setNombre(equipoPOJO.getNombre4());
		newEquipo4.setCiudad(equipoPOJO.getCiudad4().toLowerCase());
		newEquipo4.setCorreo(equipoPOJO.getCorreo4().toLowerCase());
		equipoService.save(newEquipo1);
		equipoService.save(newEquipo2);
		equipoService.save(newEquipo3);
		equipoService.save(newEquipo4);
		return new ResponseEntity(HttpStatus.CREATED);
	}
}
