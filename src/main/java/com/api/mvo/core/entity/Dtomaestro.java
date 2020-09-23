/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.api.mvo.core.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Usuario
 */
@Entity
@Table(name = "DTOMAESTRO")
@NamedQueries({
    @NamedQuery(name = "Dtomaestro.findAll", query = "SELECT d FROM Dtomaestro d")})
public class Dtomaestro implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDMAESTRO")
    private BigDecimal idmaestro;
    
    @Column(name = "ESTADO")
    private BigInteger estado;
    
    @Column(name = "CREADOPOR")
    private BigInteger creadopor;
    
    @Column(name = "FECHACREADO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechacreado;
    
    @Column(name = "ACTUALIZADOPOR")
    private BigInteger actualizadopor;
    
    @Column(name = "FECHAACTUALIZADO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaactualizado;

    public Dtomaestro() {
    }

    public Dtomaestro(BigDecimal idmaestro) {
        this.idmaestro = idmaestro;
    }

    public BigDecimal getIdmaestro() {
        return idmaestro;
    }

    public void setIdmaestro(BigDecimal idmaestro) {
        this.idmaestro = idmaestro;
    }

    public BigInteger getEstado() {
        return estado;
    }

    public void setEstado(BigInteger estado) {
        this.estado = estado;
    }

    public BigInteger getCreadopor() {
        return creadopor;
    }

    public void setCreadopor(BigInteger creadopor) {
        this.creadopor = creadopor;
    }

    public Date getFechacreado() {
        return fechacreado;
    }

    public void setFechacreado(Date fechacreado) {
        this.fechacreado = fechacreado;
    }

    public BigInteger getActualizadopor() {
        return actualizadopor;
    }

    public void setActualizadopor(BigInteger actualizadopor) {
        this.actualizadopor = actualizadopor;
    }

    public Date getFechaactualizado() {
        return fechaactualizado;
    }

    public void setFechaactualizado(Date fechaactualizado) {
        this.fechaactualizado = fechaactualizado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idmaestro != null ? idmaestro.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Dtomaestro)) {
            return false;
        }
        Dtomaestro other = (Dtomaestro) object;
        if ((this.idmaestro == null && other.idmaestro != null) || (this.idmaestro != null && !this.idmaestro.equals(other.idmaestro))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.api.mvo.core.entity.Dtomaestro[ idmaestro=" + idmaestro + " ]";
    }
    
}
