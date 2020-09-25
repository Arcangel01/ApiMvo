package com.api.mvo.core.interfaces;

import java.util.List;

import com.api.mvo.core.dto.AreaConocimientoDto;

/**
 * Interfaz donde se declaran los metodos a usar para el crud.
 * 
 * @author jcatangu
 * @date: 24/09/2020
 */
public interface IAreaConocimiento {

	/**
	 * 
	 * @return
	 */
	public List<AreaConocimientoDto> listarAreaConocimiento();

	/**
	 * 
	 * @return
	 */
	public AreaConocimientoDto listarId(long id);

	public AreaConocimientoDto save(AreaConocimientoDto dto);

	public AreaConocimientoDto update(AreaConocimientoDto dto);
	
	public boolean updateState(AreaConocimientoDto dto);
	
}
