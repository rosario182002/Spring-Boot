package com.example.demo.controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.modelo.Producto;
import com.example.demo.services.ServiciosProductos;





@RestController
@RequestMapping("/producto")
public class ControladorProducto {

	@Autowired
    private ServiciosProductos productoService;

    // Obtener todos los productos
    @GetMapping
    public ResponseEntity<List<Producto>> obtenerTodosLosProductos() {
        List<Producto> productos = productoService.obtenerTodosLosProductos();
        return  ResponseEntity.ok(productos);
    }

    // Obtener un producto por su ID
    @GetMapping("/{id}")
    public ResponseEntity<Producto> obtenerProductoPorId(@PathVariable Integer id) {
        Producto producto = productoService.obtenerProductoPorId(id);
        if (producto != null) {
            return  ResponseEntity.ok(producto);
        } else {
            return  ResponseEntity.notFound().build();
        }
    }

    // Crear un nuevo producto
    @PostMapping
    public ResponseEntity<Producto> crearProducto(@RequestBody Producto producto) {
        Producto productoCreado = productoService.crearProducto(producto);
        return ResponseEntity.ok(productoCreado); // 
    }

    // Actualizar un producto existente
    @PutMapping("/{id}")
    public ResponseEntity<Producto> actualizarProducto(@PathVariable Integer id, @RequestBody Producto producto) {
        Producto productoActualizado = productoService.actualizarProducto(id, producto);
        if (productoActualizado != null) {
            return  ResponseEntity.ok(productoActualizado);
        } else {
            return  ResponseEntity.notFound().build();
        }
    }

    // Eliminar un producto por su ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarProducto(@PathVariable Integer id) {
        productoService.eliminarProducto(id);
        return  ResponseEntity.noContent().build();
    }

    // Buscar productos por nombre
    @GetMapping("/{nombre}")
    public ResponseEntity<List<Producto>> buscarProductosPorNombre(@PathVariable String nombre) {
        List<Producto> productos = productoService.buscarProductosPorNombre(nombre);
        return  ResponseEntity.ok(productos);
    }

    // Buscar productos por rango de precios
    @GetMapping("/{minPrecio}/{maxPrecio}")
    public ResponseEntity<List<Producto>> buscarProductosPorRangoDePrecio(@PathVariable Float minPrecio, @PathVariable Float maxPrecio) {
        List<Producto> productos = productoService.buscarProductosPorRangoDePrecio(minPrecio, maxPrecio);
        return  ResponseEntity.ok(productos);
    }

    // Insertar o actualizar una lista de productos
    @PostMapping("/guardarLista")
    public ResponseEntity<List<Producto>> guardarListaDeProductos(@RequestBody List<Producto> productos) {
        List<Producto> productosGuardados = productoService.guardarListaDeProductos(productos);
        return  ResponseEntity.ok(productosGuardados);
}
}
