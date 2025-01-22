package com.example.demo.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.modelo.Estudiante;
import com.example.demo.repositorio.RepositorioEstudiante;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ServicioEstudiante implements InterfazServiEstudiante {

	@Autowired
	public RepositorioEstudiante repositorio;
	
	@Override
	public List<Estudiante> obtenerEstudiantes(){
		return repositorio.obtenerEstudiantes();
	}
}
