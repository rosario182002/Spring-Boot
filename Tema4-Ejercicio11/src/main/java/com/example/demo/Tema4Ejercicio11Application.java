package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.modelo.Empleado;
import com.example.demo.modelo.Oficina;
import com.example.demo.servicio.EmpleadoServicio;
import com.example.demo.servicio.OficinaServicio;

import java.util.List;
import java.util.Map;

@SpringBootApplication
public class Tema4Ejercicio11Application implements CommandLineRunner {

    @Autowired
    private EmpleadoServicio empleadoServicio;

    @Autowired
    private OficinaServicio oficinaServicio;

    public static void main(String[] args) {
        SpringApplication.run(Tema4Ejercicio11Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        // Crear oficinas
        Oficina oficina1 = new Oficina();
        oficina1.setUbicacion("Madrid");
        oficina1.setTelefono("123456789");
        oficinaServicio.obtenerOficina(oficina1);

        Oficina oficina2 = new Oficina();
        oficina2.setUbicacion("Barcelona");
        oficina2.setTelefono("987654321");
        oficinaServicio.obtenerOficina(oficina2);

        // Crear empleados
        Empleado empleado1 = new Empleado();
        empleado1.setNombre("Juan Perez");
        empleado1.setPuesto("Desarrollador");
        empleado1.setEmail("juan.perez@example.com");
        empleado1.setOficina(oficina1);
        empleadoServicio.obtenerEmpleado(empleado1);

        Empleado empleado2 = new Empleado();
        empleado2.setNombre("Maria Gomez");
        empleado2.setPuesto("Analista");
        empleado2.setEmail("maria.gomez@example.com");
        empleado2.setOficina(oficina2);
        empleadoServicio.obtenerEmpleado(empleado2);

        Empleado empleado3 = new Empleado();
        empleado3.setNombre("Luis Fernandez");
        empleado3.setPuesto("Desarrollador");
        empleado3.setEmail("luis.fernandez@example.com");
        empleado3.setOficina(oficina1);
        empleadoServicio.obtenerEmpleado(empleado3);

        // Consultar todos los empleados
        List<Empleado> empleados = empleadoServicio.listaEmpleados();
        System.out.println("Todos los empleados: " + empleados);

        // Consultar empleados por puesto
        List<Empleado> desarrolladores = empleadoServicio.EmpleadosPuesto("Desarrollador");
        System.out.println("Empleados con puesto 'Desarrollador': " + desarrolladores);

        // Consultar empleado por ID
       // Empleado empleadoConsultado = empleadoServicio.insertarEmpleado(empleado1.getId());
        //System.out.println("Empleado consultado por ID: " + empleadoConsultado);

        // Actualizar empleado
        //empleadoConsultado.setNombre("Juan Actualizado");
        //empleadoServicio.actualizarEmpleado(empleadoConsultado.getId(), empleadoConsultado);
        //System.out.println("Empleado actualizado: " + empleadoServicio.insertarEmpleado(empleadoConsultado.getId()));

        // Actualizar solo el teléfono de la oficina de un empleado
        oficina1.setTelefono("111222333");
        oficinaServicio.obtenerOficina(oficina1);
        System.out.println("Teléfono actualizado de la oficina: " + oficinaServicio.obtenerOficinaPorId(oficina1.getId()));

        // Contar empleados en una oficina
        long conteoEmpleados = oficinaServicio.contarEmpleados(oficina1.getId());
        System.out.println("Número de empleados en la oficina 1: " + conteoEmpleados);

        // Obtener mapa de oficinas con número de empleados
        Map<Integer, Long> mapaEmpleados = oficinaServicio.MapNumeroEmpleados(oficina1.getId());
        System.out.println("Mapa de oficinas con número de empleados: " + mapaEmpleados);

        // Eliminar un empleado
        empleadoServicio.borrarEmpleado(empleado3.getId());
        System.out.println("Empleado eliminado. Lista actualizada: " + empleadoServicio.listaEmpleados());

        // Eliminar una oficina
        oficinaServicio.eliminarOficina(oficina2.getId());
        System.out.println("Oficina eliminada. Lista actualizada: " + oficinaServicio.obtenerOficinaPorId(oficina2.getId()));

        // Listar oficinas con más de N empleados (ejemplo: más de 1 empleado)
        if (conteoEmpleados > 1) {
            System.out.println("Oficinas con más de 1 empleado: Oficina 1");
        }
    }
}
