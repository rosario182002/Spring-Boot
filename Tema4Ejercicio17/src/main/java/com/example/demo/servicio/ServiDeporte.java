package com.example.demo.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.modelo.Deporte;
import com.example.demo.repositorio.RepoDeporte;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ServiDeporte implements InterServiDeporte {

    @Autowired
    private RepoDeporte repoDeporte;

    @Override
    public void crearDeporte(Deporte deporte) {
        repoDeporte.crearDeporte(deporte);
    }

    @Override
    public List<Deporte> obtenerTodosLosDeportes() {
        return repoDeporte.obtenerTodosLosDeportes();
    }

    @Override
    public Deporte obtenerDeportePorId(Long id) {
        return repoDeporte.buscarDeportePorId(id);
    }

    @Override
    public void eliminarDeporte(Long id) {
        Deporte deporte = repoDeporte.buscarDeportePorId(id);
        if (deporte != null) {
            repoDeporte.eliminarDeporte(deporte);
        }
    }
}
