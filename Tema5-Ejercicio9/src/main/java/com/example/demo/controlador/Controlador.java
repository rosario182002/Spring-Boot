package com.example.demo.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.modelo.Empleado;
import com.example.demo.modelo.Oficina;
import com.example.demo.service.EmpleadoServicio;
import com.example.demo.service.OficinaServicio;

@Controller
public class Controlador {
	@Autowired
	private EmpleadoServicio empleadoServicio;
	
	private OficinaServicio oficinaServicio;
	
	 @GetMapping("/empleados")
	    public String verTodosEmpleados(Model model) {
	        model.addAttribute("empleados", empleadoServicio.obtenerEmpleados());
	        return "index";
	    }
	 @GetMapping("/form-empleado")
	 public String mostrarFormularioEmpleado(Model model) {
	     model.addAttribute("empleado", new Empleado());
	     return "empleadoform";
	 }

	 @PostMapping("/guardar-empleado")
	 public String guardarEmpleado(@ModelAttribute Empleado empleado) {
	     empleadoServicio.crearEmpleado(empleado);
	     return "redirect:/empleados/lista";
	 }
	 @GetMapping("/lista-oficina")
	 public String mostrarListaOficinas(Model model) {
	     List<Oficina> oficinas = oficinaServicio.obtenerOficinas();
	     model.addAttribute("oficinas", oficinas);
	     return "oficinas-lista";
	 }
	 
	 @GetMapping("/form-oficina")
	 public String mostrarFormularioOficina(Model model) {
	     model.addAttribute("oficina", new Oficina());
	     model.addAttribute("empleados", empleadoServicio.obtenerEmpleados());
	     return "oficina-form";
	 }

	 @PostMapping("/guardar-oficina")
	 public String guardarOficina(@ModelAttribute Oficina oficina, List<Integer> empleadosIds) {
		 Oficina nuevaOficina = oficinaServicio.crearOficina(oficina);

		    // Asignar empleados a la oficina si hay IDs seleccionados
		    if (empleadosIds != null && !empleadosIds.isEmpty()) {
		        for (Integer id : empleadosIds) {
		            Empleado empleado = empleadoServicio.obtenerEmpleadoPorId(id);
		            if (empleado != null) {
		                empleado.setOficina(nuevaOficina); // Asignamos la oficina
		                empleadoServicio.actualizarEmpleado(empleado.getId(), empleado);
		            }
		        }
		    }
	     // Redirigir a la lista de oficinas
	     return "redirect:/oficinas/lista";
	 }
	 @GetMapping("/{id}/empleados")
	 public String verEmpleadosDeOficina(@PathVariable Integer id, Model model) {
	     Oficina oficina = oficinaServicio.obtenerOficinaPorId(id);
	     if (oficina != null) {
	         model.addAttribute("empleados", oficina.getEmpleados());
	     }
	     return "empleados-oficina";
	 }


}
