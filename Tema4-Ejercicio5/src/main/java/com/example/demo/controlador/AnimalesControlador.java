package com.example.demo.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.modelo.Animal;
import com.example.demo.servicio.AnimalesServicio;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/animales")
public class AnimalesControlador {

    @Autowired
    private AnimalesServicio animalServicio;

    @PostMapping
    public ResponseEntity<Animal> crearAnimal(@RequestBody Animal animal) {
        Animal animalCreado = animalServicio.crearAnimal(animal);
        return ResponseEntity.ok(animalCreado);
    }

    @GetMapping
    public ResponseEntity<List<Animal>> obtenerTodosLosAnimales() {
        List<Animal> animales = animalServicio.obtenerTodosLosAnimales();
        return ResponseEntity.ok(animales);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Animal> obtenerAnimalPorId(@PathVariable Long id) {
        return animalServicio.obtenerAnimalPorId(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Optional<Animal>> actualizarAnimal(@PathVariable Long id, @RequestBody Animal detallesAnimal) {
        Optional<Animal> animalActualizado = animalServicio.actualizarAnimal(id, detallesAnimal);
        return ResponseEntity.ok(animalActualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarAnimal(@PathVariable Long id) {
    	animalServicio.eliminarAnimal(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/especie/{especie}")
    public ResponseEntity<List<Animal>> obtenerAnimalesPorEspecie(@PathVariable String especie) {
        List<Animal> animales = animalServicio.obtenerAnimalesPorEspecie(especie);
        return ResponseEntity.ok(animales);
    }

    @GetMapping("/edad/{edad}")
    public ResponseEntity<List<Animal>> obtenerAnimalesPorEdad(@PathVariable int edad) {
        List<Animal> animales = animalServicio.obtenerAnimalesPorEdad(edad);
        return ResponseEntity.ok(animales);
    }

    @GetMapping("/recientes/{anyo}")
    public ResponseEntity<List<Animal>> obtenerAnimalesRecientes(@PathVariable int fechaIngreso) {
        List<Animal> animales = animalServicio.obtenerAnimalesRecientes(fechaIngreso);
        return ResponseEntity.ok(animales);
    }
}

