package com.example.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.modelo.Producto;
import com.example.repositorio.RepositorioProducto;

@Service
public class ServiciosProductos {
	@Autowired
    private RepositorioProducto repositorioProducto;

    // Método para obtener todos los productos
    public List<Producto> obtenerTodosLosProductos() {
        return repositorioProducto.getProductos();
    }

    // Método para obtener un producto por su ID sin Optional
    public Producto obtenerProductoPorId(int id) {
        return repositorioProducto.obtenerProductoPorId(id);
    }

    // Método para insertar un nuevo producto
    public Producto crearProducto(Producto producto) {
        return repositorioProducto.insertarProducto(producto);
    }

    // Método para actualizar un producto existente
    public Producto actualizarProducto(int id, Producto producto) {
        return repositorioProducto.actualizarProducto(id, producto);
    }

    // Método para eliminar un producto por su ID
    public void eliminarProducto(int id) {
        repositorioProducto.eliminarProducto(id);
    }

    // Método para buscar productos por nombre (contiene el texto del nombre)
    public List<Producto> buscarProductosPorNombre(String nombre) {
        return repositorioProducto.getProductosPorNombre(nombre);
    }

    // Método para buscar productos por rango de precios
    public List<Producto> buscarProductosPorRangoDePrecio(float minPrecio, float maxPrecio) {
        return repositorioProducto.getProductosPorRangoDePrecio(minPrecio, maxPrecio);
    }

    // Método para insertar o actualizar una lista de productos
    public List<Producto> guardarListaDeProductos(List<Producto> productos) {
        return repositorioProducto.guardarListaDeProductos(productos);
    }
}
