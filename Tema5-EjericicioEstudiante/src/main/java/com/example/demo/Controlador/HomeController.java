package com.example.demo.Controlador;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.modelo.Curso;
import com.example.demo.modelo.Estudiante;
import com.example.demo.servicio.Servicio;

@Controller
@RequestMapping("/")
public class HomeController {

	@Autowired
	private Servicio servicio;

	@GetMapping("/cursos")
	public String index() {
		return "index";
	}

	@GetMapping("/cursos/listado")
	public String listado(Model model) {
		model.addAttribute("cursos", servicio.obtenerTodosCursos());
		return "cursos-lista";

	}

	@GetMapping("/cursos/crear")
	public String altaCurso(Model model) {
		model.addAttribute("curso", new Curso());
		return "cursos-formulario";
	}

	@PostMapping("/cursos/guardar")
	public String guardarCurso(@ModelAttribute Curso curso, Model model) {

		servicio.crearActualizarCurso(curso);

		return "redirect:/cursos/listado";
	}

	@GetMapping("/estudiantes/crear")
	public String altaEstudiante(Model model) {
		model.addAttribute("cursos", servicio.obtenerTodosCursos());
		model.addAttribute("estudiante", new Estudiante());

		return "estudianteFormulario";

	}

	@PostMapping("/estudiantes/guardar")
	public String guardarEstudiantes(@RequestParam("nombre") String nombre, @RequestParam("email") String email,
			@RequestParam(value = "cursos", required = false) List<Integer> cursoIds, Model model) {

		Estudiante estu = new Estudiante();
		estu.setNombre(nombre);
		estu.setEmail(email);

		List<Curso> cursosSeleccionados = new ArrayList<>();
		if (cursoIds != null) {
			for (Integer cursoId : cursoIds) {
				Curso curso = servicio.cursoId(cursoId);
				if (curso != null) {
					cursosSeleccionados.add(curso);
				}
			}
		}
		estu.setCursos(cursosSeleccionados);
		servicio.crearActualizarEstudiante(estu);

		return "redirect:/cursos/listado";
	}
	
	
	@GetMapping("/estudiantes/buscar")
		public String buscarDeporte() {
			return "estudiante-buscar";
		}
	
	
	@GetMapping("/buscador")
	public String buscarEstudiantes(@RequestParam(name = "nombre", required = false) String nombre, Model model) {
		List <Estudiante> estudiantes = null; //Inicializa a null
		
		if(nombre != null && !nombre.isEmpty()) {
			estudiantes = servicio.buscarEstudiantePorNombre(nombre);
		}
		model.addAttribute("estudiantes", estudiantes);
		model.addAttribute("nombreBuscado", nombre);
		return "estudiante-buscar";
	}
}

	
