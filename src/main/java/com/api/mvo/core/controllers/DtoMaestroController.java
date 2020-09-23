package com.api.mvo.core.controllers;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.mvo.core.dto.MaestroDto;
import com.api.mvo.core.entity.Dtomaestro;
import com.api.mvo.core.services.DtoMaestroService;

@RestController
@RequestMapping("/")
public class DtoMaestroController {

	@Autowired
	DtoMaestroService service;

	@GetMapping("/master")
	public ResponseEntity<Object> listAll() {
		List<Dtomaestro> list = service.listAll();
		if (list == null || list.size() == 0) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<Object>(list, HttpStatus.OK);
		}
	}

	@GetMapping("/master/{idmaestro}")
	public ResponseEntity<Object> listaById(@PathVariable("idmaestro") BigDecimal id) throws Exception {
		MaestroDto dto = service.findById(id);
		if (dto == null) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<Object>(dto, HttpStatus.OK);
		}
	}
}
