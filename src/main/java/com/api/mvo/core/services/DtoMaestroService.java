package com.api.mvo.core.services;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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

	public List<MaestroDto> listAll() {

		List<Dtomaestro> dtomaestros = repository.findAll();
		List<MaestroDto> dtos = new ArrayList<>();

		for (Dtomaestro maestroDto : dtomaestros) {
			MaestroDto dto = new MaestroDto();
			dto.setId(maestroDto.getIdmaestro());
			dto.setCreado(maestroDto.getCreadopor());
			dto.setActualizadopor(maestroDto.getActualizadopor());
			dto.setEstado(maestroDto.getEstado());
			dto.setFechacreado(maestroDto.getFechacreado().toString());
			dto.setFechaactualizado(maestroDto.getFechaactualizado().toString());
			dtos.add(dto);
		}
		return dtos;
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

	public boolean save(MaestroDto s) {
		SimpleDateFormat formatoDelTexto = new SimpleDateFormat();
		Date fecha = null;
		Date fecha2 = null;
		try {
			fecha = formatoDelTexto.parse(s.getFechacreado());
			fecha2 = formatoDelTexto.parse(s.getFechaactualizado());

				Dtomaestro dtomaestro = new Dtomaestro();
				dtomaestro.setIdmaestro(s.getId());
				dtomaestro.setCreadopor(s.getCreado());
				dtomaestro.setActualizadopor(s.getActualizadopor());
				dtomaestro.setEstado(s.getEstado());
				dtomaestro.setFechacreado(fecha);
				dtomaestro.setFechaactualizado(fecha2);
				repository.save(dtomaestro);

			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
