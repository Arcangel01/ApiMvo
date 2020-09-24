/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.api.mvo.core.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Clase que representa a la entidad area de conocimiento.
 * 
 * @author jcatangu
 * @version: 23/09/2020
 */
@Entity
@Table(name = "MAE_AREA_CONOCIMIENTO")
@NamedQueries({ @NamedQuery(name = "MaeAreaConocimiento.findAll", query = "SELECT m FROM MaeAreaConocimiento m") })
public class MaeAreaConocimiento implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * ID. Interno que Identifica la Llave Primaria del Area de Conocimiento.
	 */
	@Id
	@Basic(optional = false)
	@NotNull
	@Column(name = "ID_AREA_CONOCIMIENTO")
	private Long idAreaConocimiento;

	/**
	 * Nombre del Area de Conocimiento.
	 */
	@Size(max = 100)
	@Column(name = "NOM_AREA_CONOCIMIENTO")
	private String nomAreaConocimiento;

	/**
	 * Descripción del Area de Conocimiento.
	 */
	@Size(max = 400)
	@Column(name = "DES_AREA_CONOCIMIENTO")
	private String desAreaConocimiento;

	/**
	 * Estado del registro del Area de conocimiento. 1 = Activo, 0=Inactivo
	 */
	@Basic(optional = false)
	@NotNull
	@Column(name = "EST_REGISTRO")
	private short estRegistro;

	@OneToMany(mappedBy = "areConComponente")
	private Collection<MaeComponente> maeComponenteCollection;

	public MaeAreaConocimiento() {
	}

	public MaeAreaConocimiento(Long idAreaConocimiento) {
		this.idAreaConocimiento = idAreaConocimiento;
	}

	public MaeAreaConocimiento(Long idAreaConocimiento, short estRegistro) {
		this.idAreaConocimiento = idAreaConocimiento;
		this.estRegistro = estRegistro;
	}

	public Long getIdAreaConocimiento() {
		return idAreaConocimiento;
	}

	public void setIdAreaConocimiento(Long idAreaConocimiento) {
		this.idAreaConocimiento = idAreaConocimiento;
	}

	public String getNomAreaConocimiento() {
		return nomAreaConocimiento;
	}

	public void setNomAreaConocimiento(String nomAreaConocimiento) {
		this.nomAreaConocimiento = nomAreaConocimiento;
	}

	public String getDesAreaConocimiento() {
		return desAreaConocimiento;
	}

	public void setDesAreaConocimiento(String desAreaConocimiento) {
		this.desAreaConocimiento = desAreaConocimiento;
	}

	public short getEstRegistro() {
		return estRegistro;
	}

	public void setEstRegistro(short estRegistro) {
		this.estRegistro = estRegistro;
	}

	public Collection<MaeComponente> getMaeComponenteCollection() {
		return maeComponenteCollection;
	}

	public void setMaeComponenteCollection(Collection<MaeComponente> maeComponenteCollection) {
		this.maeComponenteCollection = maeComponenteCollection;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (idAreaConocimiento != null ? idAreaConocimiento.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof MaeAreaConocimiento)) {
			return false;
		}
		MaeAreaConocimiento other = (MaeAreaConocimiento) object;
		if ((this.idAreaConocimiento == null && other.idAreaConocimiento != null)
				|| (this.idAreaConocimiento != null && !this.idAreaConocimiento.equals(other.idAreaConocimiento))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.api.mvo.core.entity.MaeAreaConocimiento[ idAreaConocimiento=" + idAreaConocimiento + " ]";
	}

}
