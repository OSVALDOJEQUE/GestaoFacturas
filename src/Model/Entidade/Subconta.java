/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Entidade;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "subconta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Subconta.findAll", query = "SELECT s FROM Subconta s")
    , @NamedQuery(name = "Subconta.findByCodSubconta", query = "SELECT s FROM Subconta s WHERE s.codSubconta = :codSubconta")
    , @NamedQuery(name = "Subconta.findByNome", query = "SELECT s FROM Subconta s WHERE s.nome = :nome")
    , @NamedQuery(name = "Subconta.findByDebito", query = "SELECT s FROM Subconta s WHERE s.debito = :debito")
    , @NamedQuery(name = "Subconta.findByCredito", query = "SELECT s FROM Subconta s WHERE s.credito = :credito")
    , @NamedQuery(name = "Subconta.findBySaldo", query = "SELECT s FROM Subconta s WHERE s.saldo = :saldo")
    , @NamedQuery(name = "Subconta.findByNrSubConta", query = "SELECT s FROM Subconta s WHERE s.nrSubConta = :nrSubConta")})
public class Subconta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "codSubconta")
    private Integer codSubconta;
    @Basic(optional = false)
    @Column(name = "Nome")
    private String nome;
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
    @Column(name = "NrSubConta")
    private int nrSubConta;
    @JoinColumn(name = "CodContas", referencedColumnName = "CodContas")
    @ManyToOne(optional = false)
    private Contas codContas;

    public Subconta() {
    }

    public Subconta(Integer codSubconta) {
        this.codSubconta = codSubconta;
    }

    public Subconta(Integer codSubconta, String nome, BigDecimal debito, BigDecimal credito, BigDecimal saldo, int nrSubConta) {
        this.codSubconta = codSubconta;
        this.nome = nome;
        this.debito = debito;
        this.credito = credito;
        this.saldo = saldo;
        this.nrSubConta = nrSubConta;
    }

    public Integer getCodSubconta() {
        return codSubconta;
    }

    public void setCodSubconta(Integer codSubconta) {
        this.codSubconta = codSubconta;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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

    public int getNrSubConta() {
        return nrSubConta;
    }

    public void setNrSubConta(int nrSubConta) {
        this.nrSubConta = nrSubConta;
    }

    public Contas getCodContas() {
        return codContas;
    }

    public void setCodContas(Contas codContas) {
        this.codContas = codContas;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codSubconta != null ? codSubconta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Subconta)) {
            return false;
        }
        Subconta other = (Subconta) object;
        if ((this.codSubconta == null && other.codSubconta != null) || (this.codSubconta != null && !this.codSubconta.equals(other.codSubconta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.Entidade.Subconta[ codSubconta=" + codSubconta + " ]";
    }
    
}
