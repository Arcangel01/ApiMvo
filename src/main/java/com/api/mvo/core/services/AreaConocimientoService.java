package com.api.mvo.core.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.mvo.core.dto.AreaConocimientoDto;
import com.api.mvo.core.entity.MaeAreaConocimiento;
import com.api.mvo.core.interfaces.IAreaConocimiento;
import com.api.mvo.core.repository.AreaConocimientoRepository;

@Service
public class AreaConocimientoService implements IAreaConocimiento {

	private MaeAreaConocimiento conocimiento;

	private List<MaeAreaConocimiento> areaConocimientos;

	private List<AreaConocimientoDto> conocimientoDtos;

	@Autowired
	AreaConocimientoRepository repository;

	@Override
	public List<AreaConocimientoDto> listarAreaConocimiento() {
		areaConocimientos = repository.findAll();
		conocimientoDtos = new ArrayList<>();
		try {
			if (areaConocimientos != null) {
				for (MaeAreaConocimiento conocimiento : areaConocimientos) {

					AreaConocimientoDto dto = new AreaConocimientoDto();
					dto.setIdArea(conocimiento.getIdAreaConocimiento());
					dto.setNombreArea(conocimiento.getNomAreaConocimiento());
					dto.setDescripcion(conocimiento.getDesAreaConocimiento());
					dto.setEstado(conocimiento.getEstRegistro());
					conocimientoDtos.add(dto);
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return conocimientoDtos;
	}

	@Override
	public AreaConocimientoDto listarId(long id) {
		conocimiento = repository.findByIdAreaConocimiento(id);
		AreaConocimientoDto dto = new AreaConocimientoDto();
		try {
			if (conocimiento != null) {
				dto.setIdArea(conocimiento.getIdAreaConocimiento());
				dto.setNombreArea(conocimiento.getNomAreaConocimiento());
				dto.setDescripcion(conocimiento.getDesAreaConocimiento());
				dto.setEstado(conocimiento.getEstRegistro());
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return dto;
	}

	@Override
	public AreaConocimientoDto save(AreaConocimientoDto dto) {
		try {
			if (dto != null) {
				conocimiento = new MaeAreaConocimiento(dto.getNombreArea(), dto.getDescripcion(), dto.getEstado());
				repository.save(conocimiento);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return dto;
	}

	@Override
	public AreaConocimientoDto update(AreaConocimientoDto dto) {
		try {
			conocimiento = new MaeAreaConocimiento();
			conocimiento.setIdAreaConocimiento(dto.getIdArea());
			conocimiento.setNomAreaConocimiento(dto.getNombreArea());
			conocimiento.setDesAreaConocimiento(dto.getDescripcion());
			conocimiento.setEstRegistro(dto.getEstado());
			repository.save(conocimiento);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return dto;
	}

	@Override
	public boolean updateState(AreaConocimientoDto dto) {
		try {
			conocimiento = new MaeAreaConocimiento();
			if (dto.getEstado() >= 0 || dto.getEstado() <= 1) {
				conocimiento.setIdAreaConocimiento(dto.getIdArea());
				conocimiento.setNomAreaConocimiento(dto.getNombreArea());
				conocimiento.setDesAreaConocimiento(dto.getDescripcion());
				conocimiento.setEstRegistro(dto.getEstado());
				repository.save(conocimiento);
			} else {
				return false;
			}
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}