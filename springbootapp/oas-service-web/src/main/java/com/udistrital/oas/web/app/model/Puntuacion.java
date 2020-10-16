package com.udistrital.oas.web.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "puntuacion")
@Getter
@Setter
//Mapeo de base de datos 
public class Puntuacion {

	@Id
	@SequenceGenerator(name = "PUNTUACION_PUNTUACIONID_GENERATOR", sequenceName = "public.puntuacion_id_puntuacion_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PUNTUACION_PUNTUACIONID_GENERATOR")
	@Column(name = "id_puntuacion")
	private Integer idPuntuacion;
	
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_equipo")
	private Equipo equipo;
	

	@Column(name = "puntuacion")
	private Integer puntuacion;
}
