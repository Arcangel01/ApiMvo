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

import com.api.mvo.core.dto.AreaConocimientoDto;
import com.api.mvo.core.services.AreaConocimientoService;

@RestController
@RequestMapping("/areaConocimiento")
public class AreaConocimientoController {

	@Autowired
	AreaConocimientoService service;

	@GetMapping()
	public ResponseEntity<Object> listAll() throws Exception {

		List<AreaConocimientoDto> dtos = service.listarAreaConocimiento();
		if (dtos == null || dtos.size() <= 0) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<Object>(dtos, HttpStatus.OK);
		}
	}

	@GetMapping("/{idArea}")
	public ResponseEntity<Object> listaById(@PathVariable("idArea") long id) throws Exception {
		AreaConocimientoDto dto = service.listarId(id);
		if (dto == null) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<Object>(dto, HttpStatus.OK);
		}
	}

	@PostMapping()
	public ResponseEntity<Object> save(@RequestBody AreaConocimientoDto conocimientoDto) throws Exception {
		if (conocimientoDto != null) {
			service.save(conocimientoDto);
			return new ResponseEntity<Object>(conocimientoDto, HttpStatus.CREATED);
		} else {
			return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping(path = { "/{idArea}" })
	public ResponseEntity<Object> editar(@RequestBody AreaConocimientoDto conocimientoDto,
			@PathVariable("idArea") long id) throws Exception {
		if (conocimientoDto != null) {
			conocimientoDto.setIdArea(id);
			service.update(conocimientoDto);
			return new ResponseEntity<Object>(conocimientoDto, HttpStatus.OK);
		} else {
			return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
