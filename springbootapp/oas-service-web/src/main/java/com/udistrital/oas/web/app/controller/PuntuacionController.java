package com.udistrital.oas.web.app.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.udistrital.oas.web.app.model.Partido;
import com.udistrital.oas.web.app.model.Puntuacion;
import com.udistrital.oas.web.app.service.EquipoService;
import com.udistrital.oas.web.app.service.PartidoService;
import com.udistrital.oas.web.app.service.PuntuacionService;

@CrossOrigin
@RestController
public class PuntuacionController {

	private PartidoService partidoService;
	private PuntuacionService puntuacionService;
	private EquipoService equipoService;

	public PuntuacionController(PartidoService partidoService, PuntuacionService puntuacionService,
			EquipoService equipoService) {
	
		this.partidoService = partidoService;
		this.puntuacionService = puntuacionService;
		this.equipoService = equipoService;
	}



	@GetMapping(value = { "registro/score" })
	public ResponseEntity registroScore() {
		List<Partido> partidos = partidoService.findAll();
		Integer[] myNum = {0, 0, 0, 0};
		//calcula la puntuacion de cada equipo sin empates
		for (int i = 0; i < 12; i++) {
			System.out.println(partidos.get(i).getEquiLocal().getIdEquipo());
			if (partidos.get(i).getGolesLocal() > partidos.get(i).getGolesAdversario()) {
				myNum[partidos.get(i).getEquiLocal().getIdEquipo() - 1] += 3;
				//System.out.println(partidos.get(i).getEquiLocal().getIdEquipo());
			} else if (partidos.get(i).getGolesLocal() == partidos.get(i).getGolesAdversario()) {
				myNum[partidos.get(i).getEquiLocal().getIdEquipo() - 1] += 1;
				myNum[partidos.get(i).getEquiAdversario().getIdEquipo() - 1] += 1;
			} else if(partidos.get(i).getGolesLocal() < partidos.get(i).getGolesAdversario()) {
				myNum[partidos.get(i).getEquiAdversario().getIdEquipo() - 1] += 3;
				
			}
						
		}
		for (int i = 0; i < 4; i++) {
			Puntuacion newPuntuacion = new Puntuacion();
			newPuntuacion.setEquipo(equipoService.findById(i+1));
			newPuntuacion.setPuntuacion(myNum[i]);
			puntuacionService.save(newPuntuacion);
		}
		
		
		List<Puntuacion> totalPunt =puntuacionService.findAll();
		
		for (int i = 0; i < totalPunt.size(); i++) {
	        for (int j = 0; j < totalPunt.size(); j++) {
	            if (totalPunt.get(i).getPuntuacion() >= totalPunt.get(j).getPuntuacion()) {
	            	Puntuacion x = totalPunt.get(i);
	            	totalPunt.set(i, totalPunt.get(j));
	            	totalPunt.set(j, x);
	            }
	        }
	    }
		return new ResponseEntity(totalPunt,HttpStatus.OK);
	}
	

	
}
