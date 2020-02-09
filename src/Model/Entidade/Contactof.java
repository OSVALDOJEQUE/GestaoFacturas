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
@Table(name = "contactof")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Contactof.findAll", query = "SELECT c FROM Contactof c")
    , @NamedQuery(name = "Contactof.findByCodContacto", query = "SELECT c FROM Contactof c WHERE c.codContacto = :codContacto")
    , @NamedQuery(name = "Contactof.findByEmail", query = "SELECT c FROM Contactof c WHERE c.email = :email")
    , @NamedQuery(name = "Contactof.findByTelFixo", query = "SELECT c FROM Contactof c WHERE c.telFixo = :telFixo")
    , @NamedQuery(name = "Contactof.findByTelCelular", query = "SELECT c FROM Contactof c WHERE c.telCelular = :telCelular")})
public class Contactof implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "codContacto")
    private Integer codContacto;
    @Column(name = "email")
    private String email;
    @Column(name = "TelFixo")
    private Integer telFixo;
    @Basic(optional = false)
    @Column(name = "TelCelular")
    private int telCelular;
    @JoinColumn(name = "CodFornecedor", referencedColumnName = "CodFornecedor")
    @ManyToOne(optional = false)
    private Fornecedor codFornecedor;

    public Contactof() {
    }

    public Contactof(Integer codContacto) {
        this.codContacto = codContacto;
    }

    public Contactof(Integer codContacto, int telCelular) {
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

    public Fornecedor getCodFornecedor() {
        return codFornecedor;
    }

    public void setCodFornecedor(Fornecedor codFornecedor) {
        this.codFornecedor = codFornecedor;
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
        if (!(object instanceof Contactof)) {
            return false;
        }
        Contactof other = (Contactof) object;
        if ((this.codContacto == null && other.codContacto != null) || (this.codContacto != null && !this.codContacto.equals(other.codContacto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.Entidade.Contactof[ codContacto=" + codContacto + " ]";
    }
    
}
