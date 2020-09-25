package com.api.mvo.core.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.mvo.core.dto.CompetenciaDto;
import com.api.mvo.core.services.CompetenciaService;

@RestController
@RequestMapping("/competencia")
public class CompetenciaController {

	@Autowired
	CompetenciaService service;

	@GetMapping()
	public ResponseEntity<Object> listAll() throws Exception {
		List<CompetenciaDto> dtos = service.listarCompetencias();
		if (dtos == null || dtos.size() <= 0) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<Object>(dtos, HttpStatus.OK);
		}
	}

	@GetMapping("/{idCompetencia}")
	public ResponseEntity<Object> listById(@PathVariable("idCompetencia") long id) throws Exception {
		CompetenciaDto dto = service.listarId(id);
		if (dto == null) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<Object>(dto, HttpStatus.OK);
		}
	}

	@PostMapping()
	public ResponseEntity<Object> save(@RequestBody CompetenciaDto competencia) throws Exception {
		if (competencia != null) {
			service.save(competencia);
			return new ResponseEntity<Object>(competencia, HttpStatus.CREATED);
		} else {
			return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping(path = { "/{idCompetencia}" })
	public ResponseEntity<Object> editar(@RequestBody CompetenciaDto competencia,
			@PathVariable("idCompetencia") long id) throws Exception {
		if (competencia != null) {
			competencia.setIdCompetencia(id);
			service.update(competencia);
			return new ResponseEntity<Object>(competencia, HttpStatus.OK);
		} else {
			return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
