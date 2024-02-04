package it.cefi.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
// controller che carica tutte le prime pagine 
@Controller
public class HomeController {

	@GetMapping
	public String index() {
		return "index";
	}


	@GetMapping("/a")
	public String database() {
		
		return "database";
	}
	
	@GetMapping("/r")
	public String reg() {
		return "registra";
	}
	
	@GetMapping("/z")
	public String mod() {
		return "modifica";
	}
	
	@GetMapping("/rp")
	public String rigioca() {
		return "riprova";
	}
	
}
