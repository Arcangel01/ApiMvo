package com.api.mvo.core.dto;

/**
 * Objeto que representa a la clase MaeConocimientoMedir.
 * 
 * @author jcatangu
 * @date: 24/09/2020
 */
public class ConocimientoMedirDto {

	/**
	 * ID. que Identifica la Llave Primaria de conocimiento a medir.
	 */
	private Long id;

	/**
	 * Descripción de Conocimiento a Medir.
	 */
	private String descripcion;

	/**
	 * Id competencia del conocimiento a Medir.
	 */
	private Long idCompetencia;

	/**
	 * Competencia del conocimiento a Medir.
	 */
	private String competencia;

	/**
	 * Estado del registro. 1 = Activo, 0=Inactivo.
	 */
	private short estado;

	public ConocimientoMedirDto() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Long getIdCompetencia() {
		return idCompetencia;
	}

	public void setIdCompetencia(Long idCompetencia) {
		this.idCompetencia = idCompetencia;
	}

	public String getCompetencia() {
		return competencia;
	}

	public void setCompetencia(String competencia) {
		this.competencia = competencia;
	}

	public short getEstado() {
		return estado;
	}

	public void setEstado(short estado) {
		this.estado = estado;
	}

}
