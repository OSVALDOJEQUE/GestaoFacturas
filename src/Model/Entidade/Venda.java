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
import javax.persistence.ManyToMany;
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
@Table(name = "venda")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Venda.findAll", query = "SELECT v FROM Venda v")
    , @NamedQuery(name = "Venda.findByCodVenda", query = "SELECT v FROM Venda v WHERE v.codVenda = :codVenda")
    , @NamedQuery(name = "Venda.findByQuantidade", query = "SELECT v FROM Venda v WHERE v.quantidade = :quantidade")
    , @NamedQuery(name = "Venda.findByPrecoTotal", query = "SELECT v FROM Venda v WHERE v.precoTotal = :precoTotal")
    , @NamedQuery(name = "Venda.findByCodCliente", query = "SELECT v FROM Venda v WHERE v.codCliente = :codCliente")
    , @NamedQuery(name = "Venda.findByIva", query = "SELECT v FROM Venda v WHERE v.iva = :iva")})
public class Venda implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CodVenda")
    private Integer codVenda;
    @Basic(optional = false)
    @Column(name = "quantidade")
    private int quantidade;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "PrecoTotal")
    private BigDecimal precoTotal;
    @Basic(optional = false)
    @Column(name = "CodCliente")
    private int codCliente;
    @Column(name = "Iva")
    private BigDecimal iva;
    @ManyToMany(mappedBy = "vendaCollection")
    private Collection<Artigo> artigoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codVenda")
    private Collection<Vd> vdCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codVenda")
    private Collection<Factura> facturaCollection;
    private int Desconta;
    private String pesquisa;
    

    public Venda() {
    }

    public Venda(Integer codVenda) {
        this.codVenda = codVenda;
    }

    public Venda(Integer codVenda, int quantidade, BigDecimal precoTotal, int codCliente) {
        this.codVenda = codVenda;
        this.quantidade = quantidade;
        this.precoTotal = precoTotal;
        this.codCliente = codCliente;
    }

    public Integer getCodVenda() {
        return codVenda;
    }

    public void setCodVenda(Integer codVenda) {
        this.codVenda = codVenda;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public BigDecimal getPrecoTotal() {
        return precoTotal;
    }

    public void setPrecoTotal(BigDecimal precoTotal) {
        this.precoTotal = precoTotal;
    }

    public int getCodCliente() {
        return codCliente;
    }

    public void setCodCliente(int codCliente) {
        this.codCliente = codCliente;
    }

    public BigDecimal getIva() {
        return iva;
    }

    public void setIva(BigDecimal iva) {
        this.iva = iva;
    }

    public void setDesconta(int Desconta) {
        this.Desconta = Desconta;
    }
    
    public int getDesconta() {
        return Desconta;
    }

    public void setPesquisa(String pesquisa) {
        this.pesquisa = pesquisa;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getPesquisa() {
        return pesquisa;
    }
    
    

    @XmlTransient
    public Collection<Artigo> getArtigoCollection() {
        return artigoCollection;
    }

    public void setArtigoCollection(Collection<Artigo> artigoCollection) {
        this.artigoCollection = artigoCollection;
    }

    @XmlTransient
    public Collection<Vd> getVdCollection() {
        return vdCollection;
    }

    public void setVdCollection(Collection<Vd> vdCollection) {
        this.vdCollection = vdCollection;
    }

    @XmlTransient
    public Collection<Factura> getFacturaCollection() {
        return facturaCollection;
    }

    public void setFacturaCollection(Collection<Factura> facturaCollection) {
        this.facturaCollection = facturaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codVenda != null ? codVenda.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Venda)) {
            return false;
        }
        Venda other = (Venda) object;
        if ((this.codVenda == null && other.codVenda != null) || (this.codVenda != null && !this.codVenda.equals(other.codVenda))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.Entidade.Venda[ codVenda=" + codVenda + " ]";
    }
    
}
