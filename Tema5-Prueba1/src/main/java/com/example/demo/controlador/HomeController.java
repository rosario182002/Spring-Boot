package com.example.demo.controlador;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.modelo.User;




@Controller
public class HomeController {

	@GetMapping("/")
	public String home(Model model) {
	 model.addAttribute("mensaje", "Bienvenido a Thymeleaf");	
	 model.addAttribute("mensaje1", "Rosario Delgado Moreno");
	 model.addAttribute("nombre2", "<b>Rosario</b>");
	 model.addAttribute("role", "model"); //Esto lo que hace es pasar el role a admin
	 
	 String[] nombres = new String[] {"Ana","Josema","Lucia","Inma","Ángel"};
	
	 model.addAttribute("nombres", nombres);
	 
	
	 
	 return "home";
	}
	
	@GetMapping("/index")
	public String index() {
		return "index"; //esto hace que coja la página html
	}
	
	
	
	@GetMapping("/form")
	public String form(Model model) {
		model.addAttribute("user", new User());
		return "form";
	}

	@PostMapping("/form")
	public String obtenerFormulario(@ModelAttribute User user, Model model) {
		model.addAttribute("mensaje", "Formulario enviado con exito");
		model.addAttribute("user", user);//envia el usuario de vuelta
		return "result";
	}
	

}
