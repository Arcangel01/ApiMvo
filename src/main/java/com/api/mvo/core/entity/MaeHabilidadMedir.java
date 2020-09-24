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
 * Clase que representa a la entidad habilidad a medir.
 * 
 * @author jcatangu
 * @version: 23/09/2020
 */
@Entity
@Table(name = "MAE_HABILIDAD_MEDIR")
@NamedQueries({ @NamedQuery(name = "MaeHabilidadMedir.findAll", query = "SELECT m FROM MaeHabilidadMedir m") })
public class MaeHabilidadMedir implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * ID. Interno que Identifica la Llave Primaria de la Habilidad a Medir.
	 */
	@Id
	@Basic(optional = false)
	@NotNull
	@Column(name = "ID_HABILIDAD_MEDIR")
	private Long idHabilidadMedir;

	/**
	 * Descripción de la Habailidad a Medir.
	 */
	@Size(max = 100)
	@Column(name = "DES_HABILIDAD_MEDIR")
	private String desHabilidadMedir;

	/**
	 * Estado del registro. 1 = Activo, 0=Inactivo.
	 */
	@Basic(optional = false)
	@NotNull
	@Column(name = "EST_REGISTRO")
	private short estRegistro;

	public MaeHabilidadMedir() {
	}

	public MaeHabilidadMedir(Long idHabilidadMedir) {
		this.idHabilidadMedir = idHabilidadMedir;
	}

	public MaeHabilidadMedir(Long idHabilidadMedir, short estRegistro) {
		this.idHabilidadMedir = idHabilidadMedir;
		this.estRegistro = estRegistro;
	}

	public Long getIdHabilidadMedir() {
		return idHabilidadMedir;
	}

	public void setIdHabilidadMedir(Long idHabilidadMedir) {
		this.idHabilidadMedir = idHabilidadMedir;
	}

	public String getDesHabilidadMedir() {
		return desHabilidadMedir;
	}

	public void setDesHabilidadMedir(String desHabilidadMedir) {
		this.desHabilidadMedir = desHabilidadMedir;
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
		hash += (idHabilidadMedir != null ? idHabilidadMedir.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof MaeHabilidadMedir)) {
			return false;
		}
		MaeHabilidadMedir other = (MaeHabilidadMedir) object;
		if ((this.idHabilidadMedir == null && other.idHabilidadMedir != null)
				|| (this.idHabilidadMedir != null && !this.idHabilidadMedir.equals(other.idHabilidadMedir))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.api.mvo.core.entity.MaeHabilidadMedir[ idHabilidadMedir=" + idHabilidadMedir + " ]";
	}

}
