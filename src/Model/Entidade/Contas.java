/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Entidade;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "contas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Contas.findAll", query = "SELECT c FROM Contas c")
    , @NamedQuery(name = "Contas.findByCodContas", query = "SELECT c FROM Contas c WHERE c.codContas = :codContas")
    , @NamedQuery(name = "Contas.findByNome", query = "SELECT c FROM Contas c WHERE c.nome = :nome")
    , @NamedQuery(name = "Contas.findByTipo", query = "SELECT c FROM Contas c WHERE c.tipo = :tipo")
    , @NamedQuery(name = "Contas.findByDebito", query = "SELECT c FROM Contas c WHERE c.debito = :debito")
    , @NamedQuery(name = "Contas.findByCredito", query = "SELECT c FROM Contas c WHERE c.credito = :credito")
    , @NamedQuery(name = "Contas.findBySaldo", query = "SELECT c FROM Contas c WHERE c.saldo = :saldo")
    , @NamedQuery(name = "Contas.findByNrconta", query = "SELECT c FROM Contas c WHERE c.nrconta = :nrconta")})
public class Contas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CodContas")
    private Integer codContas;
    @Column(name = "Nome")
    private String nome;
    @Basic(optional = false)
    @Column(name = "Tipo")
    private String tipo;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "Debito")
    private BigDecimal debito;
    @Basic(optional = false)
    @Column(name = "Credito")
    private BigDecimal credito;
    @Basic(optional = false)
    @Column(name = "Saldo")
    private BigDecimal saldo;
    @Basic(optional = false)
    @Column(name = "Nrconta")
    private int nrconta;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codContas")
    private Collection<Subconta> subcontaCollection;
    @JoinColumn(name = "CodClasse", referencedColumnName = "CodClasse")
    @ManyToOne(optional = false)
    private Classe codClasse;

    public Contas() {
    }

    public Contas(Integer codContas) {
        this.codContas = codContas;
    }

    public Contas(Integer codContas, String tipo, BigDecimal debito, BigDecimal credito, BigDecimal saldo, int nrconta) {
        this.codContas = codContas;
        this.tipo = tipo;
        this.debito = debito;
        this.credito = credito;
        this.saldo = saldo;
        this.nrconta = nrconta;
    }

    public Integer getCodContas() {
        return codContas;
    }

    public void setCodContas(Integer codContas) {
        this.codContas = codContas;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public BigDecimal getDebito() {
        return debito;
    }

    public void setDebito(BigDecimal debito) {
        this.debito = debito;
    }

    public BigDecimal getCredito() {
        return credito;
    }

    public void setCredito(BigDecimal credito) {
        this.credito = credito;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public int getNrconta() {
        return nrconta;
    }

    public void setNrconta(int nrconta) {
        this.nrconta = nrconta;
    }

    @XmlTransient
    public Collection<Subconta> getSubcontaCollection() {
        return subcontaCollection;
    }

    public void setSubcontaCollection(Collection<Subconta> subcontaCollection) {
        this.subcontaCollection = subcontaCollection;
    }

    public Classe getCodClasse() {
        return codClasse;
    }

    public void setCodClasse(Classe codClasse) {
        this.codClasse = codClasse;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codContas != null ? codContas.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Contas)) {
            return false;
        }
        Contas other = (Contas) object;
        if ((this.codContas == null && other.codContas != null) || (this.codContas != null && !this.codContas.equals(other.codContas))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.Entidade.Contas[ codContas=" + codContas + " ]";
    }
    
}
