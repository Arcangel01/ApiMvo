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

import com.api.mvo.core.dto.ConocimientoMedirDto;
import com.api.mvo.core.services.ConocimientoMedirService;

@RestController
@RequestMapping("/conocimientoMedir")
public class ConocimientoMedirController {

	@Autowired
	ConocimientoMedirService service;
	
	@GetMapping()
	public ResponseEntity<Object> listAll() throws Exception {
		List<ConocimientoMedirDto> dtos = service.listarConocimientoMedir();
		if (dtos == null || dtos.size() <= 0) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<Object>(dtos, HttpStatus.OK);
		}
	}
	
	@GetMapping("/{idConocimientoMedir}")
	public ResponseEntity<Object> listById(@PathVariable("idConocimientoMedir") long id) throws Exception {
		ConocimientoMedirDto medirDto = service.listarId(id);
		if (medirDto == null) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<Object>(medirDto, HttpStatus.OK);
		}
	}
	
	@PostMapping()
	public ResponseEntity<Object> save(@RequestBody ConocimientoMedirDto medirDto) throws Exception {
		if (medirDto != null) {
			service.save(medirDto);
			return new ResponseEntity<Object>(medirDto, HttpStatus.CREATED);
		} else {
			return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping(path = { "/{idConocimientoMedir}" })
	public ResponseEntity<Object> editar(@RequestBody ConocimientoMedirDto medirDto,
			@PathVariable("idConocimientoMedir") long id) throws Exception {
		if (medirDto != null) {
			medirDto.setIdCompetencia(id);
			service.update(medirDto);
			return new ResponseEntity<Object>(medirDto, HttpStatus.OK);
		} else {
			return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
