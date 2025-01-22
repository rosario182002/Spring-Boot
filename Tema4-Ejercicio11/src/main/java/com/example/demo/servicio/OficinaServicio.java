package com.example.demo.servicio;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.modelo.Oficina;
import com.example.demo.repositorio.OficinaRepositorio;

import jakarta.transaction.Transactional;

@Service
public class OficinaServicio implements OficinaServicioInterfaz {

    @Autowired
    private OficinaRepositorio oficinaRepositorio;

    @Transactional
    @Override
    public void obtenerOficina(Oficina oficina) {
        oficinaRepositorio.obtenerOficina(oficina);
    }

    @Override
    public Oficina obtenerOficinaPorId(Integer id) {
        return oficinaRepositorio.obtenerOficinaPorId(id);
    }

    @Transactional
    @Override
    public Boolean eliminarOficina(Integer id) {
        Oficina oficina = oficinaRepositorio.obtenerOficinaPorId(id);
        if (oficina != null) {
            oficinaRepositorio.borrarOficina(oficina);
            return true;
        }
        return false;
    }

    @Override
    public long contarEmpleados(Integer id) {
        return oficinaRepositorio.contarEmpleados(id);
    }

    @Override
    public Map<Integer, Long> MapNumeroEmpleados(Integer id) {
        Oficina oficina = oficinaRepositorio.obtenerOficinaPorId(id);
        Map<Integer, Long> mapa = new HashMap<>();
        mapa.put(id, (long) oficina.getEmpleados().size());
        return mapa;
    }
}
