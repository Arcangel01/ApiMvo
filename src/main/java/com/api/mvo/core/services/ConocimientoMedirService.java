package com.api.mvo.core.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.mvo.core.dto.ConocimientoMedirDto;
import com.api.mvo.core.entity.MaeConocimientoMedir;
import com.api.mvo.core.interfaces.IConocimientoMedir;
import com.api.mvo.core.repository.ConocimientoMedirRepository;

@Service
public class ConocimientoMedirService implements IConocimientoMedir {

	private MaeConocimientoMedir conocimientoMedir;

	private List<MaeConocimientoMedir> listaConocimientoMedir;

	private List<ConocimientoMedirDto> conocimientosMedirDto;

	@Autowired
	ConocimientoMedirRepository repository;

	@Override
	public List<ConocimientoMedirDto> listarConocimientoMedir() {
		listaConocimientoMedir = repository.findAll();
		conocimientosMedirDto = new ArrayList<>();
		try {
			if (listaConocimientoMedir != null) {
				for (MaeConocimientoMedir conocimiento : listaConocimientoMedir) {
					ConocimientoMedirDto dto = new ConocimientoMedirDto();
					dto.setId(conocimiento.getIdConocimientoMedir());
					dto.setDescripcion(conocimiento.getDesConocimientoMedir());
					dto.setIdCompetencia(conocimiento.getComConocimientoMedir());
					dto.setCompetencia(conocimiento.getMaeCompetencia().getDesCompetencia());
					dto.setEstado(conocimiento.getEstRegistro());
					conocimientosMedirDto.add(dto);
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return conocimientosMedirDto;
	}

	@Override
	public ConocimientoMedirDto listarId(long id) {
		conocimientoMedir = repository.findByIdConocimientoMedir(id);
		ConocimientoMedirDto dto = new ConocimientoMedirDto();
		try {
			if (conocimientoMedir != null) {
				dto.setId(conocimientoMedir.getIdConocimientoMedir());
				dto.setDescripcion(conocimientoMedir.getDesConocimientoMedir());
				dto.setIdCompetencia(conocimientoMedir.getComConocimientoMedir());
				dto.setCompetencia(conocimientoMedir.getMaeCompetencia().getDesCompetencia());
				dto.setEstado(conocimientoMedir.getEstRegistro());
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return dto;
	}

	@Override
	public boolean save(ConocimientoMedirDto dto) {
		try {
			if (dto == null) {
				return false;
			} else {
				conocimientoMedir = new MaeConocimientoMedir();
				conocimientoMedir.setDesConocimientoMedir(dto.getDescripcion());
				conocimientoMedir.setComConocimientoMedir(dto.getIdCompetencia());
				conocimientoMedir.setEstRegistro(dto.getEstado());
				repository.save(conocimientoMedir);
				return true;
			}
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean update(ConocimientoMedirDto dto) {
		try {
			if (dto == null) {
				return false;
			} else {
				conocimientoMedir = new MaeConocimientoMedir();
				conocimientoMedir.setIdConocimientoMedir(dto.getId());
				conocimientoMedir.setDesConocimientoMedir(dto.getDescripcion());
				conocimientoMedir.setComConocimientoMedir(dto.getIdCompetencia());
				conocimientoMedir.setEstRegistro(dto.getEstado());
				repository.save(conocimientoMedir);
				return true;
			}
		} catch (Exception e) {
			return false;
		}
	}

}
