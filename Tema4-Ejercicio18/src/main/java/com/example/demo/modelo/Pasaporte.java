package com.example.demo.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "pasaporte")
public class Pasaporte {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Integer id;
	
	@Column
	private String numero;
	
	@OneToOne
	@JoinColumn(name = "id_persona")
	private Persona persona;
	
	public Pasaporte() {
		
	}

	public Pasaporte(Integer id, String numero, Persona persona) {
		super();
		this.id = id;
		this.numero = numero;
		this.persona = persona;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Persona getPersonas() {
		return persona;
	}

	public void setPersonas(Persona persona) {
		this.persona = persona;
	}


	
	

}
