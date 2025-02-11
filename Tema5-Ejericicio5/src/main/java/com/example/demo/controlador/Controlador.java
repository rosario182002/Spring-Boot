package com.example.demo.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


import com.example.demo.modelo.Perfil;
import com.example.demo.modelo.Usuario;
import com.example.demo.servicio.ServicioUsuario;



@Controller
public class Controlador {
	 @Autowired
	    private ServicioUsuario usuarioServicio;

	    @GetMapping("/ver-todos-los-usuarios")
	    public String verTodosLosUsuarios(Model model) {
	        model.addAttribute("usuarios", usuarioServicio.obtenerTodosLosUsuarios());
	        return "usuarios";
	    }

	     @GetMapping("/ver-usuario/{id}")
	    public String verUsuarioForm(@PathVariable Integer id, Model model) {
	        model.addAttribute("usuario", usuarioServicio.obtenerUsuarioPorId(id));
	        return "usuario-form"; // Crearemos esta página en el Ejercicio 8
	    }
	    
	    @GetMapping("/añadir-nuevo-usuario")
	    public String mostrarFormularioUsuario(Model model) {
	        // Lógica para mostrar el formulario de usuario
	        return "usuario-form"; // Nombre de la plantilla Thymeleaf
	    }

	    @GetMapping("/primer-usuario-disponible")
	    public String mostrarPrimerUsuarioDisponible(Model model) {
	        Usuario primerUsuario = usuarioServicio.obtenerPrimerUsuarioDisponible();
	        model.addAttribute("usuario", primerUsuario);
	        return "primerUsuario";
	    }
	    
	    @PostMapping("/guardar-usuario")
	    public String guardarUsuario(@ModelAttribute Usuario usuario, String bio, String estado) {
	    
	        Perfil perfil = new Perfil();
	        perfil.setBio(bio);
	        perfil.setEstado(estado);
	        usuario.setPerfil(perfil);

	        usuarioServicio.insertarUsuario(usuario);
	        return "redirect:/ver-todos-los-usuarios";
	    }
}
