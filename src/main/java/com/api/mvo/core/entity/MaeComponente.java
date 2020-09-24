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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Clase que representa a la entidad componente.
 * 
 * @author jcatangu
 * @version: 23/09/2020
 */
@Entity
@Table(name = "MAE_COMPONENTE")
@NamedQueries({ @NamedQuery(name = "MaeComponente.findAll", query = "SELECT m FROM MaeComponente m") })
public class MaeComponente implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * ID. Interno que Identifica la Llave Primaria de componente.
	 */
	@Id
	@Basic(optional = false)
	@NotNull
	@Column(name = "ID_COMPONENTE")
	private Long idComponente;

	/**
	 * Descripción de Componente.
	 */
	@Size(max = 100)
	@Column(name = "DES_COMPONENTE")
	private String desComponente;

	/**
	 * Estado del registro. 1 = Activo, 0=Inactivo.
	 */
	@Basic(optional = false)
	@NotNull
	@Column(name = "EST_REGISTRO")
	private short estRegistro;
	
	/**
	 * Area de Conocimiento del Componente.
	 */
	@JoinColumn(name = "ARE_CON_COMPONENTE", referencedColumnName = "ID_AREA_CONOCIMIENTO")
	@ManyToOne
	private MaeAreaConocimiento areConComponente;

	public MaeComponente() {
	}

	public MaeComponente(Long idComponente) {
		this.idComponente = idComponente;
	}

	public MaeComponente(Long idComponente, short estRegistro) {
		this.idComponente = idComponente;
		this.estRegistro = estRegistro;
	}

	public Long getIdComponente() {
		return idComponente;
	}

	public void setIdComponente(Long idComponente) {
		this.idComponente = idComponente;
	}

	public String getDesComponente() {
		return desComponente;
	}

	public void setDesComponente(String desComponente) {
		this.desComponente = desComponente;
	}

	public short getEstRegistro() {
		return estRegistro;
	}

	public void setEstRegistro(short estRegistro) {
		this.estRegistro = estRegistro;
	}

	public MaeAreaConocimiento getAreConComponente() {
		return areConComponente;
	}

	public void setAreConComponente(MaeAreaConocimiento areConComponente) {
		this.areConComponente = areConComponente;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (idComponente != null ? idComponente.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof MaeComponente)) {
			return false;
		}
		MaeComponente other = (MaeComponente) object;
		if ((this.idComponente == null && other.idComponente != null)
				|| (this.idComponente != null && !this.idComponente.equals(other.idComponente))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.api.mvo.core.entity.MaeComponente[ idComponente=" + idComponente + " ]";
	}

}
