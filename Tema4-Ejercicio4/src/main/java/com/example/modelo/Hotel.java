package com.example.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "hotel")
public class Hotel {
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @Column(nullable = false, unique = true)
	    private String nombre;

	    @Column(nullable = false)
	    private String direccion;

	 
	    @Column(nullable = false)
	    private int estrellas;

	    @Column(nullable = false)
	    private String telefono;

	    private String paginaWeb;
	    

		public Hotel(Long id, String nombre, String direccion, int estrellas, String telefono, String paginaWeb) {
			super();
			this.id = id;
			this.nombre = nombre;
			this.direccion = direccion;
			this.estrellas = estrellas;
			this.telefono = telefono;
			this.paginaWeb = paginaWeb;
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}

		public String getDireccion() {
			return direccion;
		}

		public void setDireccion(String direccion) {
			this.direccion = direccion;
		}

		public int getEstrellas() {
			return estrellas;
		}

		public void setEstrellas(int estrellas) {
			this.estrellas = estrellas;
		}

		public String getTelefono() {
			return telefono;
		}

		public void setTelefono(String telefono) {
			this.telefono = telefono;
		}

		public String getPaginaWeb() {
			return paginaWeb;
		}

		public void setPaginaWeb(String paginaWeb) {
			this.paginaWeb = paginaWeb;
		}
	    
	    
	    
}
