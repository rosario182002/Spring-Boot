package com.example.demo.repositorio;

import java.util.List;

import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.modelo.Producto;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class RepositorioProducto {
	@PersistenceContext
    private EntityManager entityManager;

    // Método para obtener la lista de todos los productos
    public List<Producto> getProductos() {
        Query<Producto> query = (Query<Producto>) entityManager.createQuery("SELECT p FROM Producto p", Producto.class);
        return query.getResultList();
    }

    // Método para insertar un nuevo producto
    public Producto insertarProducto(Producto producto) {
        entityManager.persist(producto);
        return producto;
    }

    // Método para obtener un producto por su ID
    public Producto obtenerProductoPorId(int id) {
        return entityManager.find(Producto.class, id);
    }

    // Método para eliminar un producto por su ID
    public void eliminarProducto(int id) {
        Producto producto = entityManager.find(Producto.class, id);
        if (producto != null) {
            entityManager.remove(producto);
        }
    }

    // Método para actualizar los datos de un producto
    public Producto actualizarProducto(int id, Producto producto) {
        Producto productoExistente = entityManager.find(Producto.class, id);
        if (productoExistente != null) {
            productoExistente.setNombre(producto.getNombre());
            productoExistente.setPrecio(producto.getPrecio());
            return entityManager.merge(productoExistente);
        }
        return null;
    }

    // Método para buscar productos por nombre (contiene el texto del nombre)
    public List<Producto> getProductosPorNombre(String nombre) {
        Query<Producto> query = (Query<Producto>) entityManager.createQuery(
                "SELECT p FROM Producto p WHERE p.nombre LIKE :nombre", Producto.class);
        query.setParameter("nombre", "%" + nombre + "%");
        return query.getResultList();
    }

    // Método para buscar productos por rango de precios
    public List<Producto> getProductosPorRangoDePrecio(float minPrecio, float maxPrecio) {
        Query<Producto> query = (Query<Producto>) entityManager.createQuery(
                "SELECT p FROM Producto p WHERE p.precio BETWEEN :minPrecio AND :maxPrecio", Producto.class);
        query.setParameter("minPrecio", minPrecio);
        query.setParameter("maxPrecio", maxPrecio);
        return query.getResultList();
    }

    // Método para insertar o actualizar una lista de productos
    public List<Producto> guardarListaDeProductos(List<Producto> productos) {
        for (Producto producto : productos) {
            if (producto.getId() == null) {
                entityManager.persist(producto);  // Insertar producto nuevo
            } else {
                entityManager.merge(producto);  // Actualizar producto existente
            }
        }
        return productos;
    }
}
