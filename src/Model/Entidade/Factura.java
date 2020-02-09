/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Entidade;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author JEQUE
 */
@Entity
@Table(name = "factura")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Factura.findAll", query = "SELECT f FROM Factura f")
    , @NamedQuery(name = "Factura.findByCodFactura", query = "SELECT f FROM Factura f WHERE f.codFactura = :codFactura")
    , @NamedQuery(name = "Factura.findByDataEmissao", query = "SELECT f FROM Factura f WHERE f.dataEmissao = :dataEmissao")
    , @NamedQuery(name = "Factura.findByDataValidade", query = "SELECT f FROM Factura f WHERE f.dataValidade = :dataValidade")
    , @NamedQuery(name = "Factura.findByQuantidade", query = "SELECT f FROM Factura f WHERE f.quantidade = :quantidade")
    , @NamedQuery(name = "Factura.findByDesconto", query = "SELECT f FROM Factura f WHERE f.desconto = :desconto")})
public class Factura implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CodFactura")
    private Integer codFactura;
    @Basic(optional = false)
    @Column(name = "DataEmissao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataEmissao;
    @Basic(optional = false)
    @Column(name = "DataValidade")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataValidade;
    @Basic(optional = false)
    @Column(name = "quantidade")
    private int quantidade;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "desconto")
    private BigDecimal desconto;
    @JoinTable(name = "recibo_has_factura", joinColumns = {
        @JoinColumn(name = "CodFactura", referencedColumnName = "CodFactura")}, inverseJoinColumns = {
        @JoinColumn(name = "CodRecibo", referencedColumnName = "CodRecibo")})
    @ManyToMany
    private Collection<Recibo> reciboCollection;
    @JoinColumn(name = "CodVenda", referencedColumnName = "CodVenda")
    @ManyToOne(optional = false)
    private int codVenda;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codFactura")
    private Collection<Nota> notaCollection;
    
    private String pesquisa;

    public Factura() {
    }

    public Factura(Integer codFactura) {
        this.codFactura = codFactura;
    }

    public Factura(Integer codFactura, Date dataEmissao, Date dataValidade, int quantidade, BigDecimal desconto) {
        this.codFactura = codFactura;
        this.dataEmissao = dataEmissao;
        this.dataValidade = dataValidade;
        this.quantidade = quantidade;
        this.desconto = desconto;
    }

    public Integer getCodFactura() {
        return codFactura;
    }

    public void setCodFactura(Integer codFactura) {
        this.codFactura = codFactura;
    }

    public Date getDataEmissao() {
        return dataEmissao;
    }

    public void setDataEmissao(Date dataEmissao) {
        this.dataEmissao = dataEmissao;
    }

    public Date getDataValidade() {
        return dataValidade;
    }

    public void setDataValidade(Date dataValidade) {
        this.dataValidade = dataValidade;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public BigDecimal getDesconto() {
        return desconto;
    }

    public void setDesconto(BigDecimal desconto) {
        this.desconto = desconto;
    }

    @XmlTransient
    public Collection<Recibo> getReciboCollection() {
        return reciboCollection;
    }

    public void setReciboCollection(Collection<Recibo> reciboCollection) {
        this.reciboCollection = reciboCollection;
    }

    public int getCodVenda() {
        return codVenda;
    }

    public void setCodVenda(int codVenda) {
        this.codVenda = codVenda;
    }

    public String getPesquisa() {
        return pesquisa;
    }

    public void setPesquisa(String pesquisa) {
        this.pesquisa = pesquisa;
    }
    
   

    @XmlTransient
    public Collection<Nota> getNotaCollection() {
        return notaCollection;
    }

    public void setNotaCollection(Collection<Nota> notaCollection) {
        this.notaCollection = notaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codFactura != null ? codFactura.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Factura)) {
            return false;
        }
        Factura other = (Factura) object;
        if ((this.codFactura == null && other.codFactura != null) || (this.codFactura != null && !this.codFactura.equals(other.codFactura))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.Entidade.Factura[ codFactura=" + codFactura + " ]";
    }
    
}
