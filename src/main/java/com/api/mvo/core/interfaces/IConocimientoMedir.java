package com.api.mvo.core.interfaces;

import java.util.List;

import com.api.mvo.core.dto.ConocimientoMedirDto;


/**
 * Interfaz donde se declaran los metodos a usar para el crud con jpa.
 * 
 * @author jcatangu
 * @date: 24/09/2020
 */
public interface IConocimientoMedir {

	/**
	 * 
	 * @return
	 */
	public List<ConocimientoMedirDto> listarConocimientoMedir();

	/**
	 * 
	 * @return
	 */
	public ConocimientoMedirDto listarId(long id);

	public boolean save(ConocimientoMedirDto dto);

	public boolean update(ConocimientoMedirDto dto);
}
