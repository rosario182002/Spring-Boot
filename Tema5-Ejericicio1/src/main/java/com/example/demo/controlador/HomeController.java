package com.example.demo.controlador;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.modelo.Cliente;
import com.example.demo.modelo.Direccion;
import com.example.demo.servicio.ClienteServicio;
import org.springframework.ui.Model;




@Controller
@RequestMapping("/clientes")
public class HomeController {

    @Autowired
    private ClienteServicio clienteServicio;

    @GetMapping
    public String listarClientes(Model model) {
        model.addAttribute("clientes", clienteServicio.obtenerTodosLosClientes());
        return "index";
    }

    @GetMapping("/detalles")
    public String detalles(@RequestParam Long id, Model model) {
        Cliente cliente = clienteServicio.obtenerClientePorId(id);
        model.addAttribute("cliente", cliente);
        return "cliente-detalle";
    }

    @GetMapping("/formulario")
    public String formulario(Model model) {
        model.addAttribute("cliente", new Cliente());
        model.addAttribute("direccion", new Direccion()); //Necesitas pasar tambien un objeto Dirección
        return "cliente-formulario";
    }

    @PostMapping("/guardarCliente")
    public String guardarCliente(@ModelAttribute Cliente cliente, @ModelAttribute Direccion direccion) {
        cliente.setDireccion(direccion); //Asignas la direccion al cliente
        clienteServicio.guardarCliente(cliente);
        return "redirect:/clientes";
    }

    @GetMapping("/ciudad")
    public String buscarPorCiudad(@RequestParam String ciudad, Model model) {
        model.addAttribute("clientes", clienteServicio.buscarClientesPorCiudad(ciudad));
        return "ciudad";
    }
}