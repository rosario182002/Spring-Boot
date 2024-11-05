package com.example.demo.controles;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class PalindromoController {

		@GetMapping("/validar-palindromo/{palabra}")
		public String palindromo(@PathVariable String palabra) {
			String mensaje ="La palabra " + palabra;
			if(isPalindromo(palabra)) {
				return mensaje + "es un palíndromo";
			}else {
				return mensaje + "NO un palíndromo";
			}
			
		}
		private boolean isPalindromo(String palabra) {
			int length = palabra.length();
			for(int i =0; i<length /2; i++) {
				if(palabra.charAt(i)!=palabra.charAt(length - i -1)) {
					return false;
				}
			}
			return true;
		}
	}
	
