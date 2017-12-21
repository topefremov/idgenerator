package org.efremov.idgenerator.controller;

import org.efremov.idgenerator.service.IdGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GeneratorController {
	
	IdGeneratorService idGeneratorService;
	
	@Autowired
	public GeneratorController(IdGeneratorService idGeneratorService) {
		this.idGeneratorService = idGeneratorService;
	}

	@PostMapping("/id")
	public String generateId() {
		return idGeneratorService.generateId();
	}
}
