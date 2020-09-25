package com.api.mvo.core.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.mvo.core.dto.CompetenciaDto;
import com.api.mvo.core.entity.MaeCompetencia;
import com.api.mvo.core.interfaces.ICompetencia;
import com.api.mvo.core.repository.CompetenciaRepository;

@Service
public class CompetenciaService implements ICompetencia {

	private MaeCompetencia competencia;

	private List<MaeCompetencia> competencias;

	private List<CompetenciaDto> competenciaDtos;

	@Autowired
	CompetenciaRepository repository;

	@Override
	public List<CompetenciaDto> listarCompetencias() {
		competencias = repository.findAll();
		competenciaDtos = new ArrayList<>();
		try {
			if (competencias != null) {
				for (MaeCompetencia comp : competencias) {
					CompetenciaDto dto = new CompetenciaDto();
					dto.setIdCompetencia(comp.getIdCompetencia());
					dto.setDescripcion(comp.getDesCompetencia());
					dto.setEstado(comp.getEstRegistro());
					competenciaDtos.add(dto);
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return competenciaDtos;
	}

	@Override
	public CompetenciaDto listarId(long id) {
		competencia = repository.findByIdCompetencia(id);
		CompetenciaDto dto = new CompetenciaDto();
		try {
			if (competencia != null) {
				dto.setIdCompetencia(competencia.getIdCompetencia());
				dto.setDescripcion(competencia.getDesCompetencia());
				dto.setEstado(competencia.getEstRegistro());
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return dto;
	}

	@Override
	public boolean save(CompetenciaDto dto) {
		try {
			if (dto == null) {
				return false;
			} else {
				competencia = new MaeCompetencia(dto.getDescripcion(), dto.getEstado());
				competencia.setDesCompetencia(dto.getDescripcion());
				competencia.setEstRegistro(dto.getEstado());
				repository.save(competencia);
				return true;
			}
		} catch (Exception e) {
			return false;
		}

	}

	@Override
	public boolean update(CompetenciaDto dto) {
		try {
			if (dto == null) {
				return false;
			} else {
				competencia = new MaeCompetencia();
				competencia.setIdCompetencia(dto.getIdCompetencia());
				competencia.setDesCompetencia(dto.getDescripcion());
				competencia.setEstRegistro(dto.getEstado());
				repository.save(competencia);
				return true;
			}
		} catch (Exception e) {
			return false;
		}
	}

}
