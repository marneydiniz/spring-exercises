package br.com.marney.springexercises.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calc")
public class CalcController {
	
	@GetMapping("/add/{n1}/{n2}")
	public Long add(@PathVariable Long n1, @PathVariable Long n2) {
		return n1 + n2;
	}
	
	@GetMapping("/sub")
	public Long sub(@RequestParam(name = "n1") Long n1, @RequestParam (name = "n2")Long n2) {
		return n1 - n2;
	}

}
