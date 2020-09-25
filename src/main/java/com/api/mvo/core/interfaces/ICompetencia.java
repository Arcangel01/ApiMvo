package com.api.mvo.core.interfaces;

import java.util.List;

import com.api.mvo.core.dto.CompetenciaDto;

/**
 * Interfaz donde se declaran los metodos a usar para el crud.
 * 
 * @author jcatangu
 * @date: 24/09/2020
 */
public interface ICompetencia {

	/**
	 * 
	 * @return
	 */
	public List<CompetenciaDto> listarCompetencias();

	/**
	 * 
	 * @return
	 */
	public CompetenciaDto listarId(long id);

	public boolean save(CompetenciaDto dto);

	public boolean update(CompetenciaDto dto);

}
