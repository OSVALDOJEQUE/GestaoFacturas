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
@Table(name = "tipoartigo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tipoartigo.findAll", query = "SELECT t FROM Tipoartigo t")
    , @NamedQuery(name = "Tipoartigo.findByCodTipoArtigo", query = "SELECT t FROM Tipoartigo t WHERE t.codTipoArtigo = :codTipoArtigo")
    , @NamedQuery(name = "Tipoartigo.findByDescricao", query = "SELECT t FROM Tipoartigo t WHERE t.descricao = :descricao")})
public class Tipoartigo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CodTipoArtigo")
    private Integer codTipoArtigo;
    @Basic(optional = false)
    @Column(name = "Descricao")
    private String descricao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codTipoArtigo")
    private Collection<Artigo> artigoCollection;
    private String pesquisa;
    

    public Tipoartigo() {
    }

    public Tipoartigo(Integer codTipoArtigo) {
        this.codTipoArtigo = codTipoArtigo;
    }

    public Tipoartigo(Integer codTipoArtigo, String descricao) {
        this.codTipoArtigo = codTipoArtigo;
        this.descricao = descricao;
    }

    public Integer getCodTipoArtigo() {
        return codTipoArtigo;
    }

    public void setCodTipoArtigo(Integer codTipoArtigo) {
        this.codTipoArtigo = codTipoArtigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getPesquisa() {
        return pesquisa;
    }

    public void setPesquisa(String pesquisa) {
        this.pesquisa = pesquisa;
    }

    
    @XmlTransient
    public Collection<Artigo> getArtigoCollection() {
        return artigoCollection;
    }

    public void setArtigoCollection(Collection<Artigo> artigoCollection) {
        this.artigoCollection = artigoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codTipoArtigo != null ? codTipoArtigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tipoartigo)) {
            return false;
        }
        Tipoartigo other = (Tipoartigo) object;
        if ((this.codTipoArtigo == null && other.codTipoArtigo != null) || (this.codTipoArtigo != null && !this.codTipoArtigo.equals(other.codTipoArtigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.Entidade.Tipoartigo[ codTipoArtigo=" + codTipoArtigo + " ]";
    }
    
}
