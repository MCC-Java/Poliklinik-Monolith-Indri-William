/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mcc.poliklinik.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author TOSHIBA
 */
@Entity
@Table(name = "pendaftaran")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pendaftaran.findAll", query = "SELECT p FROM Pendaftaran p")
    , @NamedQuery(name = "Pendaftaran.findByNo", query = "SELECT p FROM Pendaftaran p WHERE p.no = :no")
    , @NamedQuery(name = "Pendaftaran.findByTanggal", query = "SELECT p FROM Pendaftaran p WHERE p.tanggal = :tanggal")
    , @NamedQuery(name = "Pendaftaran.findByPasien", query = "SELECT p FROM Pendaftaran p WHERE p.pasien = :pasien")
    , @NamedQuery(name = "Pendaftaran.findByNama", query = "SELECT p FROM Pendaftaran p WHERE p.nama = :nama")
    , @NamedQuery(name = "Pendaftaran.findByStatus", query = "SELECT p FROM Pendaftaran p WHERE p.status = :status")
    , @NamedQuery(name = "Pendaftaran.findByPoli", query = "SELECT p FROM Pendaftaran p WHERE p.poli = :poli")})
public class Pendaftaran implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "no")
    private Integer no;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tanggal")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date tanggal;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 11)
    @Column(name = "pasien")
    private String pasien;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "nama")
    private String nama;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "status")
    private String status;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "poli")
    private String poli;

    public Pendaftaran() {
    }

    public Pendaftaran(Integer no) {
        this.no = no;
    }

    public Pendaftaran(Integer no, Date tanggal, String pasien, String nama, String status, String poli) {
        this.no = no;
        this.tanggal = tanggal;
        this.pasien = pasien;
        this.nama = nama;
        this.status = status;
        this.poli = poli;
    }

    public Integer getNo() {
        return no;
    }

    public void setNo(Integer no) {
        this.no = no;
    }

    public Date getTanggal() {
        return tanggal;
    }

    public void setTanggal(Date tanggal) {
        this.tanggal = tanggal;
    }

    public String getPasien() {
        return pasien;
    }

    public void setPasien(String pasien) {
        this.pasien = pasien;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPoli() {
        return poli;
    }

    public void setPoli(String poli) {
        this.poli = poli;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (no != null ? no.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pendaftaran)) {
            return false;
        }
        Pendaftaran other = (Pendaftaran) object;
        if ((this.no == null && other.no != null) || (this.no != null && !this.no.equals(other.no))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mcc.poliklinik.entities.Pendaftaran[ no=" + no + " ]";
    }
    
}
