/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.api.mvo.core.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Clase que representa a la entidad grado.
 * 
 * @author jcatangu
 * @version: 23/09/2020
 */
@Entity
@Table(name = "MAE_GRADO")
@NamedQueries({ @NamedQuery(name = "MaeGrado.findAll", query = "SELECT m FROM MaeGrado m") })
public class MaeGrado implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * ID. Interno que Identifica la Llave Primaria del dato maestro de grado.
	 */
	@Id
	@Basic(optional = false)
	@NotNull
	@Column(name = "ID_GRADO")
	private Long idGrado;

	/**
	 * Descripción del grado.
	 */
	@Size(max = 20)
	@Column(name = "DES_GRADO")
	private String desGrado;

	/**
	 * Estado del registro. 1 = Activo, 0=Inactivo.
	 */
	@Basic(optional = false)
	@NotNull
	@Column(name = "EST_REGISTRO")
	private short estRegistro;

	public MaeGrado() {
	}

	public MaeGrado(Long idGrado) {
		this.idGrado = idGrado;
	}

	public MaeGrado(Long idGrado, short estRegistro) {
		this.idGrado = idGrado;
		this.estRegistro = estRegistro;
	}

	public Long getIdGrado() {
		return idGrado;
	}

	public void setIdGrado(Long idGrado) {
		this.idGrado = idGrado;
	}

	public String getDesGrado() {
		return desGrado;
	}

	public void setDesGrado(String desGrado) {
		this.desGrado = desGrado;
	}

	public short getEstRegistro() {
		return estRegistro;
	}

	public void setEstRegistro(short estRegistro) {
		this.estRegistro = estRegistro;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (idGrado != null ? idGrado.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof MaeGrado)) {
			return false;
		}
		MaeGrado other = (MaeGrado) object;
		if ((this.idGrado == null && other.idGrado != null)
				|| (this.idGrado != null && !this.idGrado.equals(other.idGrado))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.api.mvo.core.entity.MaeGrado[ idGrado=" + idGrado + " ]";
	}

}
