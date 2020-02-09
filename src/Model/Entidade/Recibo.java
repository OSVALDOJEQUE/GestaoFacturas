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
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
@Table(name = "recibo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Recibo.findAll", query = "SELECT r FROM Recibo r")
    , @NamedQuery(name = "Recibo.findByCodRecibo", query = "SELECT r FROM Recibo r WHERE r.codRecibo = :codRecibo")
    , @NamedQuery(name = "Recibo.findByDataEmissao", query = "SELECT r FROM Recibo r WHERE r.dataEmissao = :dataEmissao")
    , @NamedQuery(name = "Recibo.findByValor", query = "SELECT r FROM Recibo r WHERE r.valor = :valor")})
public class Recibo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CodRecibo")
    private Integer codRecibo;
    @Basic(optional = false)
    @Column(name = "DataEmissao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataEmissao;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "Valor")
    private BigDecimal valor;
    @ManyToMany(mappedBy = "reciboCollection")
    private Collection<Factura> facturaCollection;

    public Recibo() {
    }

    public Recibo(Integer codRecibo) {
        this.codRecibo = codRecibo;
    }

    public Recibo(Integer codRecibo, Date dataEmissao, BigDecimal valor) {
        this.codRecibo = codRecibo;
        this.dataEmissao = dataEmissao;
        this.valor = valor;
    }

    public Integer getCodRecibo() {
        return codRecibo;
    }

    public void setCodRecibo(Integer codRecibo) {
        this.codRecibo = codRecibo;
    }

    public Date getDataEmissao() {
        return dataEmissao;
    }

    public void setDataEmissao(Date dataEmissao) {
        this.dataEmissao = dataEmissao;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
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
        hash += (codRecibo != null ? codRecibo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Recibo)) {
            return false;
        }
        Recibo other = (Recibo) object;
        if ((this.codRecibo == null && other.codRecibo != null) || (this.codRecibo != null && !this.codRecibo.equals(other.codRecibo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.Entidade.Recibo[ codRecibo=" + codRecibo + " ]";
    }
    
}
