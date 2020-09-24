/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.api.mvo.core.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Clase que representa a la entidad competencia.
 * 
 * @author jcatangu
 * @version: 23/09/2020
 */
@Entity
@Table(name = "MAE_COMPETENCIA")
@NamedQueries({ @NamedQuery(name = "MaeCompetencia.findAll", query = "SELECT m FROM MaeCompetencia m") })
public class MaeCompetencia implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * ID. Interno que Identifica la Llave Primaria de la Competencia.
	 */
	@Id
	@Basic(optional = false)
	@NotNull
	@Column(name = "ID_COMPETENCIA")
	private Long idCompetencia;
	
	/**
	 * Descripción de Competencia.
	 */
	@Size(max = 100)
	@Column(name = "DES_COMPETENCIA")
	private String desCompetencia;
	
	/**
	 * Estado del registro. 1 = Activo, 0=Inactivo.
	 */
	@Basic(optional = false)
	@NotNull
	@Column(name = "EST_REGISTRO")
	private short estRegistro;
	
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "maeCompetencia")
	private MaeConocimientoMedir maeConocimientoMedir;

	public MaeCompetencia() {
	}

	public MaeCompetencia(Long idCompetencia) {
		this.idCompetencia = idCompetencia;
	}

	public MaeCompetencia(Long idCompetencia, short estRegistro) {
		this.idCompetencia = idCompetencia;
		this.estRegistro = estRegistro;
	}

	public Long getIdCompetencia() {
		return idCompetencia;
	}

	public void setIdCompetencia(Long idCompetencia) {
		this.idCompetencia = idCompetencia;
	}

	public String getDesCompetencia() {
		return desCompetencia;
	}

	public void setDesCompetencia(String desCompetencia) {
		this.desCompetencia = desCompetencia;
	}

	public short getEstRegistro() {
		return estRegistro;
	}

	public void setEstRegistro(short estRegistro) {
		this.estRegistro = estRegistro;
	}

	public MaeConocimientoMedir getMaeConocimientoMedir() {
		return maeConocimientoMedir;
	}

	public void setMaeConocimientoMedir(MaeConocimientoMedir maeConocimientoMedir) {
		this.maeConocimientoMedir = maeConocimientoMedir;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (idCompetencia != null ? idCompetencia.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof MaeCompetencia)) {
			return false;
		}
		MaeCompetencia other = (MaeCompetencia) object;
		if ((this.idCompetencia == null && other.idCompetencia != null)
				|| (this.idCompetencia != null && !this.idCompetencia.equals(other.idCompetencia))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.api.mvo.core.entity.MaeCompetencia[ idCompetencia=" + idCompetencia + " ]";
	}

}
