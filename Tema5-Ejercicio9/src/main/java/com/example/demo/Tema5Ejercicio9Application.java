package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.modelo.Empleado;
import com.example.demo.modelo.Oficina;
import com.example.demo.service.EmpleadoServicio;
import com.example.demo.service.OficinaServicio;


@SpringBootApplication
public class Tema5Ejercicio9Application implements CommandLineRunner {

    @Autowired
    private EmpleadoServicio empleadoServicio;

    @Autowired
    private OficinaServicio oficinaServicio;

	public static void main(String[] args) {
		SpringApplication.run(Tema5Ejercicio9Application.class, args);
	}

		 @Override
		    public void run(String... args) throws Exception {
			// Crear empleados
				Empleado emp1 = new Empleado("Juan Pérez", "Desarrollador", "juan@gmail.com");
				Empleado emp2 = new Empleado("Ana López", "Diseñadora", "ana@gmail.com");
				Empleado emp3 = new Empleado("Carlos Gómez", "Gerente", "carlos@gmail.com");
				Empleado emp4 = new Empleado("María Fernández", "Marketing", "maria@gmail.com");
				Empleado emp5 = new Empleado("Luis Ramírez", "Soporte Técnico", "luis@gmail.com");
				Empleado emp6 = new Empleado("Sofía Martínez", "Marketing", "sofia@gmail.com");

				// Crear oficinas
				Oficina oficina1 = new Oficina("Madrid", 911234567, null);
				Oficina oficina2 = new Oficina("Barcelona", 931234567, null);
				Oficina oficina3 = new Oficina("Valencia", 961234567, null);

				List<Empleado> empleados1 = new ArrayList<>();
				List<Empleado> empleados2 = new ArrayList<>();
				List<Empleado> empleados3 = new ArrayList<>();

				empleados1.add(emp1);
				empleados1.add(emp2);

				empleados2.add(emp3);
				empleados2.add(emp4);

				empleados3.add(emp5);
				empleados3.add(emp6);

				oficina1.setEmpleados(empleados1);
				oficina2.setEmpleados(empleados2);
				oficina3.setEmpleados(empleados3);

				oficinaServicio.crearOficina(oficina1);
				oficinaServicio.crearOficina(oficina2);
				oficinaServicio.crearOficina(oficina3);

				List<Oficina> oficinasConN = oficinaServicio.obtenerOficinasConMasDeNEmpleados(1);
				for (Oficina oficina : oficinasConN) {
					System.out.println(oficina);
				}
				
			/*	List<Empleado> puestoEspecifico = oficinaServicio.obtenerNumeroEmpleadosOficina("aaa");

				if (puestoEspecifico.size() > 0) {
					for (Empleado empleado : puestoEspecifico) {
						System.out.println(empleado);
					}
				} else {
					System.out.println("No hay ningún empleado con ese puesto");
				}
*/
			}

}
