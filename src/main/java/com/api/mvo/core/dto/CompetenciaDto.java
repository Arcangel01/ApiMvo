package com.api.mvo.core.dto;

/**
 * Objeto que representa a la clase MaeCompetencia.
 * 
 * @author jcatangu
 * @date: 24/09/2020
 */
public class CompetenciaDto {

	/**
	 * ID. que Identifica la Llave Primaria de competencia.
	 */
	private Long idCompetencia;

	/**
	 * Descripción de competencia.
	 */
	private String descripcion;

	/**
	 * Estado del registro. 1 = Activo, 0=Inactivo.
	 */
	private short estado;

	public CompetenciaDto() {
	}

	public Long getIdCompetencia() {
		return idCompetencia;
	}

	public void setIdCompetencia(Long idCompetencia) {
		this.idCompetencia = idCompetencia;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public short getEstado() {
		return estado;
	}

	public void setEstado(short estado) {
		this.estado = estado;
	}

}
