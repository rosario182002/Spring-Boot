package com.example.demo.repositorio;

import com.example.demo.modelo.Perfil;

public interface InterRepoPerfil {


	Perfil crearGuardarPerfil(Perfil perfil);

	Perfil obtenerPorId(Integer id);

	void eliminar(Integer id);

}
