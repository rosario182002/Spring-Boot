package com.example.demo.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class HomeController {

	@GetMapping("/")
	public String home(Model model) {
	 model.addAttribute("mensaje", "Bienvenido a Thymeleaf");	
	 model.addAttribute("mensaje1", "Rosario Delgado Moreno");
	 model.addAttribute("nombre2", "<b>Rosario</b>");
	 
	 return "home";
	}
}
