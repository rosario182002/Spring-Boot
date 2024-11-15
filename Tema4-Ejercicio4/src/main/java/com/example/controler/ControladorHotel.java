package com.example.controler;

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

import com.example.modelo.Hotel;
import com.example.servicio.ServicioHotel;

@RestController
@RequestMapping("/hoteles")
public class ControladorHotel {

	@Autowired
    private ServicioHotel hotelService;

    @PostMapping
    public ResponseEntity<Hotel> crearHotel(@RequestBody Hotel hotel) {
        return ResponseEntity.ok(hotelService.guardarHotel(hotel));
    }

    @GetMapping
    public ResponseEntity<List<Hotel>> obtenerTodosLosHoteles() {
        return ResponseEntity.ok(hotelService.obtenerTodosLosHoteles());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Hotel> obtenerHotelPorId(@PathVariable Long id) {
        return hotelService.obtenerHotelPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Hotel> actualizarHotel(@PathVariable Long id, @RequestBody Hotel hotelDetalles) {
        return hotelService.obtenerHotelPorId(id).map(hotel -> {
            hotel.setNombre(hotelDetalles.getNombre());
            hotel.setDireccion(hotelDetalles.getDireccion());
            hotel.setEstrellas(hotelDetalles.getEstrellas());
            hotel.setTelefono(hotelDetalles.getTelefono());
            hotel.setPaginaWeb(hotelDetalles.getPaginaWeb());
            return ResponseEntity.ok(hotelService.actualizarHotel(hotel));
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarHotelPorId(@PathVariable Long id) {
        hotelService.eliminarHotelPorId(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/estrellas/{min}/{max}")
    public ResponseEntity<List<Hotel>> obtenerHotelesPorRangoEstrellas(@PathVariable int min, @PathVariable int max) {
        return ResponseEntity.ok(hotelService.obtenerHotelesPorRangoEstrellas(min, max));
    }

    @GetMapping("/telefono/{telefono}")
    public ResponseEntity<Hotel> obtenerHotelPorTelefono(@PathVariable String telefono) {
        return hotelService.obtenerHotelPorTelefono(telefono)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/nombre/{nombre}")
    public ResponseEntity<Void> eliminarHotelesPorNombre(@PathVariable String nombre) {
        hotelService.eliminarHotelesPorNombre(nombre);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/lista")
    public ResponseEntity<List<Hotel>> crearListaDeHoteles(@RequestBody List<Hotel> hoteles) {
        return ResponseEntity.ok(hotelService.guardarListaDeHoteles(hoteles));
    }
	
	
}
