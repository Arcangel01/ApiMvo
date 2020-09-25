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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Clase que representa a la entidad conocimiento a medir.
 * 
 * @author jcatangu
 * @version: 23/09/2020
 */
@Entity
@Table(name = "MAE_CONOCIMIENTO_MEDIR")
@NamedQueries({ @NamedQuery(name = "MaeConocimientoMedir.findAll", query = "SELECT m FROM MaeConocimientoMedir m") })
public class MaeConocimientoMedir implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * ID. Interno que Identifica la Llave Primaria de conocieminto a Medir.
	 */
	@Id
	@Basic(optional = false)
	@NotNull
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MAE_CONOCIMIENTO_MEDIR_SEQ")
	@SequenceGenerator(name = "MAE_CONOCIMIENTO_MEDIR_SEQ", sequenceName = "MAE_CONOCIMIENTO_MEDIR_SEQ", allocationSize = 1)
	@Column(name = "ID_CONOCIMIENTO_MEDIR")
	private Long idConocimientoMedir;

	/**
	 * Descripción de Conocimiento a Medir.
	 */
	@Size(max = 100)
	@Column(name = "DES_CONOCIMIENTO_MEDIR")
	private String desConocimientoMedir;

	/**
	 * Competencia del conocimiento a Medir.
	 */
	@Column(name = "COM_CONOCIMIENTO_MEDIR")
	private Long comConocimientoMedir;

	/**
	 * Estado del registro. 1 = Activo, 0=Inactivo.
	 */
	@Basic(optional = false)
	@NotNull
	@Column(name = "EST_REGISTRO")
	private short estRegistro;

	@JoinColumn(name = "ID_CONOCIMIENTO_MEDIR", referencedColumnName = "ID_COMPETENCIA", insertable = false, updatable = false)
	@OneToOne(optional = false)
	private MaeCompetencia maeCompetencia;

	public MaeConocimientoMedir() {
	}

	public MaeConocimientoMedir(Long idConocimientoMedir) {
		this.idConocimientoMedir = idConocimientoMedir;
	}

	public MaeConocimientoMedir(Long idConocimientoMedir, short estRegistro) {
		this.idConocimientoMedir = idConocimientoMedir;
		this.estRegistro = estRegistro;
	}

	public Long getIdConocimientoMedir() {
		return idConocimientoMedir;
	}

	public void setIdConocimientoMedir(Long idConocimientoMedir) {
		this.idConocimientoMedir = idConocimientoMedir;
	}

	public String getDesConocimientoMedir() {
		return desConocimientoMedir;
	}

	public void setDesConocimientoMedir(String desConocimientoMedir) {
		this.desConocimientoMedir = desConocimientoMedir;
	}

	public Long getComConocimientoMedir() {
		return comConocimientoMedir;
	}

	public void setComConocimientoMedir(Long comConocimientoMedir) {
		this.comConocimientoMedir = comConocimientoMedir;
	}

	public short getEstRegistro() {
		return estRegistro;
	}

	public void setEstRegistro(short estRegistro) {
		this.estRegistro = estRegistro;
	}

	public MaeCompetencia getMaeCompetencia() {
		return maeCompetencia;
	}

	public void setMaeCompetencia(MaeCompetencia maeCompetencia) {
		this.maeCompetencia = maeCompetencia;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (idConocimientoMedir != null ? idConocimientoMedir.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof MaeConocimientoMedir)) {
			return false;
		}
		MaeConocimientoMedir other = (MaeConocimientoMedir) object;
		if ((this.idConocimientoMedir == null && other.idConocimientoMedir != null)
				|| (this.idConocimientoMedir != null && !this.idConocimientoMedir.equals(other.idConocimientoMedir))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.api.mvo.core.entity.MaeConocimientoMedir[ idConocimientoMedir=" + idConocimientoMedir + " ]";
	}

}
