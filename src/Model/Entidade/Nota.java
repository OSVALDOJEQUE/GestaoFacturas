/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Entidade;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author JEQUE
 */
@Entity
@Table(name = "nota")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Nota.findAll", query = "SELECT n FROM Nota n")
    , @NamedQuery(name = "Nota.findByCodNota", query = "SELECT n FROM Nota n WHERE n.codNota = :codNota")
    , @NamedQuery(name = "Nota.findByDataEmissao", query = "SELECT n FROM Nota n WHERE n.dataEmissao = :dataEmissao")
    , @NamedQuery(name = "Nota.findByTipo", query = "SELECT n FROM Nota n WHERE n.tipo = :tipo")
    , @NamedQuery(name = "Nota.findByValor", query = "SELECT n FROM Nota n WHERE n.valor = :valor")
    , @NamedQuery(name = "Nota.findByDescr", query = "SELECT n FROM Nota n WHERE n.descr = :descr")
    , @NamedQuery(name = "Nota.findByIva", query = "SELECT n FROM Nota n WHERE n.iva = :iva")})
public class Nota implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CodNota")
    private Integer codNota;
    @Basic(optional = false)
    @Column(name = "DataEmissao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataEmissao;
    @Basic(optional = false)
    @Column(name = "Tipo")
    private String tipo;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "Valor")
    private BigDecimal valor;
    @Basic(optional = false)
    @Column(name = "Descr")
    private String descr;
    @Basic(optional = false)
    @Column(name = "Iva")
    private BigDecimal iva;
    @JoinColumn(name = "CodFactura", referencedColumnName = "CodFactura")
    @ManyToOne(optional = false)
    private int codFactura;
    private int pesquisa;

    public Nota() {
    }

    public Nota(Integer codNota) {
        this.codNota = codNota;
    }

    public Nota(Integer codNota, Date dataEmissao, String tipo, BigDecimal valor, String descr, BigDecimal iva) {
        this.codNota = codNota;
        this.dataEmissao = dataEmissao;
        this.tipo = tipo;
        this.valor = valor;
        this.descr = descr;
        this.iva = iva;
    }

    public Integer getCodNota() {
        return codNota;
    }

    public void setCodNota(Integer codNota) {
        this.codNota = codNota;
    }

    public Date getDataEmissao() {
        return dataEmissao;
    }

    public void setDataEmissao(Date dataEmissao) {
        this.dataEmissao = dataEmissao;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    public BigDecimal getIva() {
        return iva;
    }

    public void setIva(BigDecimal iva) {
        this.iva = iva;
    }

    public int getCodFactura() {
        return codFactura;
    }

    public void setCodFactura(int codFactura) {
        this.codFactura = codFactura;
    }

    public int getPesquisa() {
        return pesquisa;
    }

    public void setPesquisa(int pesquisa) {
        this.pesquisa = pesquisa;
    }
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codNota != null ? codNota.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Nota)) {
            return false;
        }
        Nota other = (Nota) object;
        if ((this.codNota == null && other.codNota != null) || (this.codNota != null && !this.codNota.equals(other.codNota))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.Entidade.Nota[ codNota=" + codNota + " ]";
    }
    
}
