package com.udistrital.oas.web.app.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "equipo")
@Getter
@Setter
//Mapeo de base de datos 
public class Equipo {
	@Id
	@SequenceGenerator(name = "EQUIPO_EQUIPOID_GENERATOR", sequenceName = "public.equipo_id_equipo_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "EQUIPO_EQUIPOID_GENERATOR")
	@Column(name = "id_equipo")
	private Integer idEquipo;
	
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "ciudad")
	private String ciudad;
	
	@Column(name = "correo")
	private String correo;
	
	@JsonIgnore
	@OneToMany(mappedBy="EquiLocal", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Partido> partidoL;
	
	@JsonIgnore
	@OneToMany(mappedBy="EquiAdversario", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Partido> partidoAd;
	
	
	@JsonIgnore
	@OneToMany(mappedBy="equipo", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Puntuacion> puntuacion;	
}
