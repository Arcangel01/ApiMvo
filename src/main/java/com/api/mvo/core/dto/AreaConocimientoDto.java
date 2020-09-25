package com.api.mvo.core.dto;

/**
 * Objeto que representa a la clase MaeAreaConocimiento.
 * 
 * @author jcatangu
 * @date: 24/09/2020
 */
public class AreaConocimientoDto {

	/**
	 * ID. que Identifica la Llave Primaria del Area de Conocimiento.
	 */
	private Long idArea;

	/**
	 * Nombre del Area de Conocimiento.
	 */
	private String nombreArea;

	/**
	 * Descripción del Area de Conocimiento.
	 */
	private String descripcion;

	/**
	 * Estado del registro del Area de conocimiento. 1 = Activo, 0=Inactivo
	 */
	private short estado;

	/**
	 * Constructor sin parametros
	 */
	public AreaConocimientoDto() {
	}

	public Long getIdArea() {
		return idArea;
	}

	public void setIdArea(Long idArea) {
		this.idArea = idArea;
	}

	public String getNombreArea() {
		return nombreArea;
	}

	public void setNombreArea(String nombreArea) {
		this.nombreArea = nombreArea;
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
