package com.api.mvo.core.services;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.mvo.core.dto.MaestroDto;
import com.api.mvo.core.entity.Dtomaestro;
import com.api.mvo.core.repository.DtoMaestroRepository;

@Service
public class DtoMaestroService {

	@Autowired
	DtoMaestroRepository repository;

	public List<Dtomaestro> listAll() {
		return repository.findAll();
	}

	public MaestroDto findById(BigDecimal id) {
		
		Dtomaestro dtomaestro = repository.findByIdmaestro(id);
		MaestroDto dto = new MaestroDto();
		dto.setId(dtomaestro.getIdmaestro());
		dto.setCreado(dtomaestro.getCreadopor());
		dto.setActualizadopor(dtomaestro.getActualizadopor());
		dto.setEstado(dtomaestro.getEstado());
		dto.setFechacreado(dtomaestro.getFechacreado().toString());
		dto.setFechaactualizado(dtomaestro.getFechaactualizado().toString());
		return dto;
	}

	public boolean save(Dtomaestro s) {
		try {
			if (s != null) {
				repository.save(s);
			}
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
