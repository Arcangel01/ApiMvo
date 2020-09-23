package com.api.mvo.core.dto;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

/*
 * 
 */
public class MaestroDto {

	/*
	 * 
	 */
	private BigDecimal id;

	/*
	 * 
	 */
	private BigInteger estado;

	/*
	 * 
	 */
	private BigInteger creado;

	/*
	 * 
	 */
	private String fechacreado;

	/*
	 * 
	 */
	private BigInteger actualizadopor;

	/*
	 * 
	 */
	private String fechaactualizado;

	public MaestroDto() {
		super();
	}

	public MaestroDto(BigDecimal id, BigInteger estado, BigInteger creado, String fechacreado, BigInteger actualizadopor,
			String fechaactualizado) {
		super();
		this.id = id;
		this.estado = estado;
		this.creado = creado;
		this.fechacreado = fechacreado;
		this.actualizadopor = actualizadopor;
		this.fechaactualizado = fechaactualizado;
	}

	public BigDecimal getId() {
		return id;
	}

	public BigInteger getEstado() {
		return estado;
	}

	public void setEstado(BigInteger estado) {
		this.estado = estado;
	}

	public void setId(BigDecimal id) {
		this.id = id;
	}

	public BigInteger getCreado() {
		return creado;
	}

	public void setCreado(BigInteger creado) {
		this.creado = creado;
	}

	public String getFechacreado() {
		return fechacreado;
	}

	public void setFechacreado(String fechacreado) {
		this.fechacreado = fechacreado;
	}

	public BigInteger getActualizadopor() {
		return actualizadopor;
	}

	public void setActualizadopor(BigInteger actualizadopor) {
		this.actualizadopor = actualizadopor;
	}

	public String getFechaactualizado() {
		return fechaactualizado;
	}

	public void setFechaactualizado(String fechaactualizado) {
		this.fechaactualizado = fechaactualizado;
	}

}
