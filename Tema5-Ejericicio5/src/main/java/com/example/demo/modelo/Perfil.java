package com.example.demo.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="perfil")
public class Perfil {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(nullable = false)
	private String bio;
	
	@Column
	private String estado;
	
	public Perfil() {
		
	}
	
	public Perfil(Integer id, String bio, String estado) {
		super();
		this.id = id;
		this.bio = bio;
		this.estado = estado;
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	 @Override
	    public String toString() {
	        return "Perfil{" +
	                "id=" + id +
	                ", bio='" + bio + '\'' +
	                ", estado='" + estado + '\'' +
	                '}';
	    }
	
	
}
