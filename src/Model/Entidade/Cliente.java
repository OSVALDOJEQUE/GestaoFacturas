/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Entidade;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author JEQUE
 */
@Entity
@Table(name = "cliente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cliente.findAll", query = "SELECT c FROM Cliente c")
    , @NamedQuery(name = "Cliente.findByCodCliente", query = "SELECT c FROM Cliente c WHERE c.codCliente = :codCliente")
    , @NamedQuery(name = "Cliente.findByNome", query = "SELECT c FROM Cliente c WHERE c.nome = :nome")
    , @NamedQuery(name = "Cliente.findByNuit", query = "SELECT c FROM Cliente c WHERE c.nuit = :nuit")
    , @NamedQuery(name = "Cliente.findByNrEdificio", query = "SELECT c FROM Cliente c WHERE c.nrEdificio = :nrEdificio")
    , @NamedQuery(name = "Cliente.findByCodPostal", query = "SELECT c FROM Cliente c WHERE c.codPostal = :codPostal")
    , @NamedQuery(name = "Cliente.findByCaixaPostal", query = "SELECT c FROM Cliente c WHERE c.caixaPostal = :caixaPostal")})
public class Cliente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CodCliente")
    private Integer codCliente;
    @Basic(optional = false)
    @Column(name = "Nome")
    private String nome;
    @Column(name = "Nuit")
    private Integer nuit;
    @Column(name = "NrEdificio")
    private Integer nrEdificio;
    @Column(name = "CodPostal")
    private Integer codPostal;
    @Column(name = "CaixaPostal")
    private Integer caixaPostal;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codCliente")
    private Collection<Contactoc> contactocCollection;
    @JoinColumn(name = "CodEndereco", referencedColumnName = "CodEndereco")
    @ManyToOne(optional = false)
    private int codEndereco;
    
    private String pesquisa;

    public Cliente() {
    }

    public Cliente(Integer codCliente) {
        this.codCliente = codCliente;
    }

    public Cliente(Integer codCliente, String nome) {
        this.codCliente = codCliente;
        this.nome = nome;
    }

    public Integer getCodCliente() {
        return codCliente;
    }

    public void setCodCliente(Integer codCliente) {
        this.codCliente = codCliente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getNuit() {
        return nuit;
    }

    public void setNuit(Integer nuit) {
        this.nuit = nuit;
    }

    public Integer getNrEdificio() {
        return nrEdificio;
    }

    public void setNrEdificio(Integer nrEdificio) {
        this.nrEdificio = nrEdificio;
    }

    public Integer getCodPostal() {
        return codPostal;
    }

    public void setCodPostal(Integer codPostal) {
        this.codPostal = codPostal;
    }

    public Integer getCaixaPostal() {
        return caixaPostal;
    }

    public void setCaixaPostal(Integer caixaPostal) {
        this.caixaPostal = caixaPostal;
    }

    @XmlTransient
    public Collection<Contactoc> getContactocCollection() {
        return contactocCollection;
    }

    public void setContactocCollection(Collection<Contactoc> contactocCollection) {
        this.contactocCollection = contactocCollection;
    }

    public int getCodEndereco() {
        return codEndereco;
    }

    public void setCodEndereco(int codEndereco) {
        this.codEndereco = codEndereco;
    }
    
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codCliente != null ? codCliente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cliente)) {
            return false;
        }
        Cliente other = (Cliente) object;
        if ((this.codCliente == null && other.codCliente != null) || (this.codCliente != null && !this.codCliente.equals(other.codCliente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.Entidade.Cliente[ codCliente=" + codCliente + " ]";
    }

    /**
     * @return the pesquisa
     */
    public String getPesquisa() {
        return pesquisa;
    }

    /**
     * @param pesquisa the pesquisa to set
     */
    public void setPesquisa(String pesquisa) {
        this.pesquisa = pesquisa;
    }
    
}
