package com.example.demo.controles;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloRestController {

	@GetMapping("/hola")
	public String hello() {
		return "Hello";
	}
	
	@GetMapping("/hola/{name}")
	public String helloName(@PathVariable String name) {
		return "Hello" + name;
	}
}
