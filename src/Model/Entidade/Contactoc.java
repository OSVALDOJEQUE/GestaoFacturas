/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Entidade;

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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author JEQUE
 */
@Entity
@Table(name = "contactoc")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Contactoc.findAll", query = "SELECT c FROM Contactoc c")
    , @NamedQuery(name = "Contactoc.findByCodContacto", query = "SELECT c FROM Contactoc c WHERE c.codContacto = :codContacto")
    , @NamedQuery(name = "Contactoc.findByEmail", query = "SELECT c FROM Contactoc c WHERE c.email = :email")
    , @NamedQuery(name = "Contactoc.findByTelFixo", query = "SELECT c FROM Contactoc c WHERE c.telFixo = :telFixo")
    , @NamedQuery(name = "Contactoc.findByTelCelular", query = "SELECT c FROM Contactoc c WHERE c.telCelular = :telCelular")})
public class Contactoc implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CodContacto")
    private Integer codContacto;
    @Column(name = "email")
    private String email;
    @Column(name = "TelFixo")
    private Integer telFixo;
    @Basic(optional = false)
    @Column(name = "TelCelular")
    private int telCelular;
    @JoinColumn(name = "CodCliente", referencedColumnName = "CodCliente")
    @ManyToOne(optional = false)
    private int codCliente;

    public Contactoc() {
    }

    public Contactoc(Integer codContacto) {
        this.codContacto = codContacto;
    }

    public Contactoc(Integer codContacto, int telCelular) {
        this.codContacto = codContacto;
        this.telCelular = telCelular;
    }

    public Integer getCodContacto() {
        return codContacto;
    }

    public void setCodContacto(Integer codContacto) {
        this.codContacto = codContacto;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getTelFixo() {
        return telFixo;
    }

    public void setTelFixo(Integer telFixo) {
        this.telFixo = telFixo;
    }

    public int getTelCelular() {
        return telCelular;
    }

    public void setTelCelular(int telCelular) {
        this.telCelular = telCelular;
    }

    public int getCodCliente() {
        return codCliente;
    }

    public void setCodCliente(int codCliente) {
        this.codCliente = codCliente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codContacto != null ? codContacto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Contactoc)) {
            return false;
        }
        Contactoc other = (Contactoc) object;
        if ((this.codContacto == null && other.codContacto != null) || (this.codContacto != null && !this.codContacto.equals(other.codContacto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.Entidade.Contactoc[ codContacto=" + codContacto + " ]";
    }
    
}
