/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mcc.poliklinik.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ASUS
 */
@Entity
@Table(name = "pemeriksaan")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pemeriksaan.findAll", query = "SELECT p FROM Pemeriksaan p")
    , @NamedQuery(name = "Pemeriksaan.findById", query = "SELECT p FROM Pemeriksaan p WHERE p.id = :id")
    , @NamedQuery(name = "Pemeriksaan.findByTanggal", query = "SELECT p FROM Pemeriksaan p WHERE p.tanggal = :tanggal")
    , @NamedQuery(name = "Pemeriksaan.findByKeluhan", query = "SELECT p FROM Pemeriksaan p WHERE p.keluhan = :keluhan")})
public class Pemeriksaan implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "tanggal")
    @Temporal(TemporalType.DATE)
    private Date tanggal;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "keluhan")
    private String keluhan;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPemeriksaan", fetch = FetchType.LAZY)
    private List<Riwayat> riwayatList;
    @JoinColumn(name = "no_pendaftaran", referencedColumnName = "no")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Pendaftaran noPendaftaran;

    public Pemeriksaan() {
    }

    public Pemeriksaan(Integer id) {
        this.id = id;
    }

    public Pemeriksaan(Integer id, Date tanggal, String keluhan) {
        this.id = id;
        this.tanggal = tanggal;
        this.keluhan = keluhan;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    @XmlTransient
    public List<Riwayat> getRiwayatList() {
        return riwayatList;
    }

    public void setRiwayatList(List<Riwayat> riwayatList) {
        this.riwayatList = riwayatList;
    }

    public Pendaftaran getNoPendaftaran() {
        return noPendaftaran;
    }

    public void setNoPendaftaran(Pendaftaran noPendaftaran) {
        this.noPendaftaran = noPendaftaran;
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
        if (!(object instanceof Pemeriksaan)) {
            return false;
        }
        Pemeriksaan other = (Pemeriksaan) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mcc.poliklinik.entities.Pemeriksaan[ id=" + id + " ]";
    }

    public Date getTanggal() {
        return tanggal;
    }

    public void setTanggal(Date tanggal) {
        this.tanggal = tanggal;
    }

    public String getKeluhan() {
        return keluhan;
    }

    public void setKeluhan(String keluhan) {
        this.keluhan = keluhan;
    }
    
}
