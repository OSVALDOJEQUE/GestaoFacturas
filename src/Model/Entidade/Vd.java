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
@Table(name = "vd")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vd.findAll", query = "SELECT v FROM Vd v")
    , @NamedQuery(name = "Vd.findByCodVd", query = "SELECT v FROM Vd v WHERE v.codVd = :codVd")
    , @NamedQuery(name = "Vd.findByQuantidade", query = "SELECT v FROM Vd v WHERE v.quantidade = :quantidade")
    , @NamedQuery(name = "Vd.findByDesconto", query = "SELECT v FROM Vd v WHERE v.desconto = :desconto")
    , @NamedQuery(name = "Vd.findByDataEmissao", query = "SELECT v FROM Vd v WHERE v.dataEmissao = :dataEmissao")})
public class Vd implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CodVd")
    private Integer codVd;
    @Basic(optional = false)
    @Column(name = "quantidade")
    private int quantidade;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "desconto")
    private BigDecimal desconto;
    @Basic(optional = false)
    @Column(name = "DataEmissao")
    @Temporal(TemporalType.DATE)
    private Date dataEmissao;
    @JoinColumn(name = "CodVenda", referencedColumnName = "CodVenda")
    @ManyToOne(optional = false)
    private int codVenda;
    private String pesquisa;

    public Vd() {
    }

    public Vd(Integer codVd) {
        this.codVd = codVd;
    }

    public Vd(Integer codVd, int quantidade, BigDecimal desconto, Date dataEmissao) {
        this.codVd = codVd;
        this.quantidade = quantidade;
        this.desconto = desconto;
        this.dataEmissao = dataEmissao;
    }

    public Integer getCodVd() {
        return codVd;
    }

    public void setCodVd(Integer codVd) {
        this.codVd = codVd;
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

    public Date getDataEmissao() {
        return dataEmissao;
    }

    public void setDataEmissao(Date dataEmissao) {
        this.dataEmissao = dataEmissao;
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

    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codVd != null ? codVd.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vd)) {
            return false;
        }
        Vd other = (Vd) object;
        if ((this.codVd == null && other.codVd != null) || (this.codVd != null && !this.codVd.equals(other.codVd))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.Entidade.Vd[ codVd=" + codVd + " ]";
    }
    
}
