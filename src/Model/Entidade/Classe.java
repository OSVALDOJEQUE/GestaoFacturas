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
@Table(name = "classe")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Classe.findAll", query = "SELECT c FROM Classe c")
    , @NamedQuery(name = "Classe.findByCodClasse", query = "SELECT c FROM Classe c WHERE c.codClasse = :codClasse")
    , @NamedQuery(name = "Classe.findByNome", query = "SELECT c FROM Classe c WHERE c.nome = :nome")})
public class Classe implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CodClasse")
    private Integer codClasse;
    @Basic(optional = false)
    @Column(name = "Nome")
    private String nome;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codClasse")
    private Collection<Contas> contasCollection;

    public Classe() {
    }

    public Classe(Integer codClasse) {
        this.codClasse = codClasse;
    }

    public Classe(Integer codClasse, String nome) {
        this.codClasse = codClasse;
        this.nome = nome;
    }

    public Integer getCodClasse() {
        return codClasse;
    }

    public void setCodClasse(Integer codClasse) {
        this.codClasse = codClasse;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @XmlTransient
    public Collection<Contas> getContasCollection() {
        return contasCollection;
    }

    public void setContasCollection(Collection<Contas> contasCollection) {
        this.contasCollection = contasCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codClasse != null ? codClasse.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Classe)) {
            return false;
        }
        Classe other = (Classe) object;
        if ((this.codClasse == null && other.codClasse != null) || (this.codClasse != null && !this.codClasse.equals(other.codClasse))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.Entidade.Classe[ codClasse=" + codClasse + " ]";
    }
    
}
