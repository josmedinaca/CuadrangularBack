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

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "partido")
@Getter
@Setter
//Mapeo de base de datos 
public class Partido {
	@Id
	@SequenceGenerator(name = "PARTIDO_PARTIDOID_GENERATOR", sequenceName = "public.partido_id_partido_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PARTIDO_PARTIDOID_GENERATOR")
	@Column(name = "id_partido")
	private Integer idPartido;
	
	@Column(name = "goles_local")
	private Integer golesLocal;
	
	@Column(name = "goles_adversario")
	private Integer golesAdversario;
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_equi_local")
	private Equipo EquiLocal;
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_equi_adversario")
	private Equipo EquiAdversario;
	
}
