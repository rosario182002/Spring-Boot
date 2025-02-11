package com.example.demo.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


import com.example.demo.service.EmpleadoServicio;

@Controller
public class Controlador {
	@Autowired
	private EmpleadoServicio empleadoServicio;
	
	
	 @GetMapping("/empleados")
	    public String verTodosEmpleados(Model model) {
	        model.addAttribute("empleados", empleadoServicio.listaEmpleados());
	        return "index";
	    }

}
