package com.udistrital.oas.web.app.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.udistrital.oas.web.app.POJO.PartidoPOJO;
import com.udistrital.oas.web.app.model.Equipo;
import com.udistrital.oas.web.app.model.Partido;
import com.udistrital.oas.web.app.service.EquipoService;
import com.udistrital.oas.web.app.service.PartidoService;

@CrossOrigin
@RestController
public class PartidoController {
	
	private PartidoService partidoService;
	private EquipoService equipoService;
	

	
	public PartidoController(PartidoService partidoService, EquipoService equipoService) {
		this.partidoService = partidoService;
		this.equipoService = equipoService;
	}



	@GetMapping(value = { "registro/partido" })
	public ResponseEntity registroPartido() {
		List<Equipo> equipos= equipoService.findAll();
		List<Partido> partidos = new ArrayList<Partido>();
		for (int i = 0; i < equipos.size(); i++) {
			for (int j = 0; j < 4; j++) {
				if(i==j) {
					j+=1;
				}
				if(j==4) {
					break;
				}
				Partido newPartido= new Partido();
				newPartido.setEquiLocal(equipos.get(i));
				newPartido.setEquiAdversario(equipos.get(j));
				partidoService.save(newPartido);
				partidos.add(newPartido);
				//System.out.println(i+"+"+j);
			}
		}
		return new ResponseEntity(partidos,HttpStatus.OK);
	}
	
	@PostMapping(value = { "update/partido" })
	public ResponseEntity updatePartido(@RequestBody PartidoPOJO partidoPOJO) {
		for (int i = 0; i < partidoPOJO.getId().length; i++) {
			Partido existingPartido = partidoService.findByIdPartido(partidoPOJO.getId()[i]);
			existingPartido.setGolesLocal(partidoPOJO.getGolesLocal()[i]);
			existingPartido.setGolesAdversario(partidoPOJO.getGolesAdv()[i]);
			partidoService.save(existingPartido);
		}
		
		return new ResponseEntity(HttpStatus.OK);
	}
}
