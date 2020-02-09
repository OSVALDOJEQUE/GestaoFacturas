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
import javax.persistence.ManyToMany;
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
@Table(name = "fornecedor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Fornecedor.findAll", query = "SELECT f FROM Fornecedor f")
    , @NamedQuery(name = "Fornecedor.findByCodFornecedor", query = "SELECT f FROM Fornecedor f WHERE f.codFornecedor = :codFornecedor")
    , @NamedQuery(name = "Fornecedor.findByNome", query = "SELECT f FROM Fornecedor f WHERE f.nome = :nome")
    , @NamedQuery(name = "Fornecedor.findByNuit", query = "SELECT f FROM Fornecedor f WHERE f.nuit = :nuit")
    , @NamedQuery(name = "Fornecedor.findByNrEdficio", query = "SELECT f FROM Fornecedor f WHERE f.nrEdficio = :nrEdficio")
    , @NamedQuery(name = "Fornecedor.findByCaixaPostal", query = "SELECT f FROM Fornecedor f WHERE f.caixaPostal = :caixaPostal")
    , @NamedQuery(name = "Fornecedor.findByCodPostal", query = "SELECT f FROM Fornecedor f WHERE f.codPostal = :codPostal")})
public class Fornecedor implements Serializable {
    
    
    
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CodFornecedor")
    private Integer codFornecedor;
    @Basic(optional = false)
    @Column(name = "Nome")
    private String nome;
    @Basic(optional = false)
    @Column(name = "Nuit")
    private int nuit;
    @Basic(optional = false)
    @Column(name = "NrEdficio")
    private int nrEdficio;
    @Basic(optional = false)
    @Column(name = "CaixaPostal")
    private int caixaPostal;
    @Basic(optional = false)
    @Column(name = "CodPostal")
    private int codPostal;
    @ManyToMany(mappedBy = "fornecedorCollection")
    private Collection<Artigo> artigoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codFornecedor")
    private Collection<Contactof> contactofCollection;
    @JoinColumn(name = "CodEndereco", referencedColumnName = "CodEndereco")
    @ManyToOne(optional = false)
    private int codEndereco;
    private String pesquisa;

    public Fornecedor() {
    }

    public Fornecedor(Integer codFornecedor) {
        this.codFornecedor = codFornecedor;
    }

    public Fornecedor(Integer codFornecedor, String nome, int nuit, int nrEdficio, int caixaPostal, int codPostal) {
        this.codFornecedor = codFornecedor;
        this.nome = nome;
        this.nuit = nuit;
        this.nrEdficio = nrEdficio;
        this.caixaPostal = caixaPostal;
        this.codPostal = codPostal;
    }

    public Integer getCodFornecedor() {
        return codFornecedor;
    }

    public void setCodFornecedor(Integer codFornecedor) {
        this.codFornecedor = codFornecedor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNuit() {
        return nuit;
    }

    public void setNuit(int nuit) {
        this.nuit = nuit;
    }

    public int getNrEdficio() {
        return nrEdficio;
    }

    public void setNrEdficio(int nrEdficio) {
        this.nrEdficio = nrEdficio;
    }

    public int getCaixaPostal() {
        return caixaPostal;
    }

    public void setCaixaPostal(int caixaPostal) {
        this.caixaPostal = caixaPostal;
    }

    public int getCodPostal() {
        return codPostal;
    }

    public void setCodPostal(int codPostal) {
        this.codPostal = codPostal;
    }

    @XmlTransient
    public Collection<Artigo> getArtigoCollection() {
        return artigoCollection;
    }

    public void setArtigoCollection(Collection<Artigo> artigoCollection) {
        this.artigoCollection = artigoCollection;
    }

    @XmlTransient
    public Collection<Contactof> getContactofCollection() {
        return contactofCollection;
    }

    public void setContactofCollection(Collection<Contactof> contactofCollection) {
        this.contactofCollection = contactofCollection;
    }

    public int getCodEndereco() {
        return codEndereco;
    }

    public void setCodEndereco(int codEndereco) {
        this.codEndereco = codEndereco;
    }

    public void setPesquisa(String pesquisa) {
        this.pesquisa = pesquisa;
    }

    public String getPesquisa() {
        return pesquisa;
    }
    
 

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codFornecedor != null ? codFornecedor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Fornecedor)) {
            return false;
        }
        Fornecedor other = (Fornecedor) object;
        if ((this.codFornecedor == null && other.codFornecedor != null) || (this.codFornecedor != null && !this.codFornecedor.equals(other.codFornecedor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.Entidade.Fornecedor[ codFornecedor=" + codFornecedor + " ]";
    }
    
}
