/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mcc.poliklinik.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ASUS
 */
@Entity
@Table(name = "jadwal")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Jadwal.findAll", query = "SELECT j FROM Jadwal j")
    , @NamedQuery(name = "Jadwal.findById", query = "SELECT j FROM Jadwal j WHERE j.id = :id")
    , @NamedQuery(name = "Jadwal.findByTanggal", query = "SELECT j FROM Jadwal j WHERE j.tanggal = :tanggal")
    , @NamedQuery(name = "Jadwal.findByPoli", query = "SELECT j FROM Jadwal j WHERE j.poli = :poli")
    , @NamedQuery(name = "Jadwal.findByDokter", query = "SELECT j FROM Jadwal j WHERE j.dokter = :dokter")})
public class Jadwal implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "tanggal")
    private String tanggal;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "poli")
    private String poli;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "dokter")
    private String dokter;

    public Jadwal() {
    }

    public Jadwal(Integer id) {
        this.id = id;
    }

    public Jadwal(Integer id, String tanggal, String poli, String dokter) {
        this.id = id;
        this.tanggal = tanggal;
        this.poli = poli;
        this.dokter = dokter;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String getPoli() {
        return poli;
    }

    public void setPoli(String poli) {
        this.poli = poli;
    }

    public String getDokter() {
        return dokter;
    }

    public void setDokter(String dokter) {
        this.dokter = dokter;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Jadwal)) {
            return false;
        }
        Jadwal other = (Jadwal) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mcc.poliklinik.entities.Jadwal[ id=" + id + " ]";
    }
    
}
