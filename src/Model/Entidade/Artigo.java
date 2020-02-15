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
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author JEQUE
 */
@Entity
@Table(name = "artigo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Artigo.findAll", query = "SELECT a FROM Artigo a")
    , @NamedQuery(name = "Artigo.findByCodArtigo", query = "SELECT a FROM Artigo a WHERE a.codArtigo = :codArtigo")
    , @NamedQuery(name = "Artigo.findByDescricao", query = "SELECT a FROM Artigo a WHERE a.descricao = :descricao")
    , @NamedQuery(name = "Artigo.findByQuantidade", query = "SELECT a FROM Artigo a WHERE a.quantidade = :quantidade")
    , @NamedQuery(name = "Artigo.findByPrecoUnit", query = "SELECT a FROM Artigo a WHERE a.precoUnit = :precoUnit")})
public class Artigo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CodArtigo")
    private Integer codArtigo;
    @Basic(optional = false)
    @Column(name = "Descricao")
    private String descricao;
    @Column(name = "Quantidade")
    private Integer quantidade;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "PrecoUnit")
    private BigDecimal precoUnit;
    @JoinTable(name = "venda_has_artigo", joinColumns = {
        @JoinColumn(name = "CodArtigo", referencedColumnName = "CodArtigo")}, inverseJoinColumns = {
        @JoinColumn(name = "CodVenda", referencedColumnName = "CodVenda")})
    @ManyToMany
    private Collection<Venda> vendaCollection;
    @JoinTable(name = "artigo_has_fornecedor", joinColumns = {
        @JoinColumn(name = "CodArtigo", referencedColumnName = "CodArtigo")}, inverseJoinColumns = {
        @JoinColumn(name = "CodFornecedor", referencedColumnName = "CodFornecedor")})
    @ManyToMany
    private Collection<Fornecedor> fornecedorCollection;
    @JoinColumn(name = "CodTipoArtigo", referencedColumnName = "CodTipoArtigo")
    @ManyToOne(optional = false)
    private int codTipoArtigo;
    private String  Artigo,unidade, marca, moeda,taxa, cor;
    private float peso;
    
    
    
    
    

    public Artigo() {
    }

    public Artigo(Integer codArtigo) {
        this.codArtigo = codArtigo;
    }

    public Artigo(Integer codArtigo, String descricao) {
        this.codArtigo = codArtigo;
        this.descricao = descricao;
    }

    public Integer getCodArtigo() {
        return codArtigo;
    }

    public void setCodArtigo(Integer codArtigo) {
        this.codArtigo = codArtigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public BigDecimal getPrecoUnit() {
        return precoUnit;
    }

    public void setPrecoUnit(BigDecimal precoUnit) {
        this.precoUnit = precoUnit;
    }

    public String getArtigo() {
        return Artigo;
    }

    public void setArtigo(String Artigo) {
        this.Artigo = Artigo;
    }

    public String getUnidade() {
        return unidade;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getMoeda() {
        return moeda;
    }

    public void setMoeda(String moeda) {
        this.moeda = moeda;
    }

    public String getTaxa() {
        return taxa;
    }

    public void setTaxa(String taxa) {
        this.taxa = taxa;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }
    
    

    @XmlTransient
    public Collection<Venda> getVendaCollection() {
        return vendaCollection;
    }

    public void setVendaCollection(Collection<Venda> vendaCollection) {
        this.vendaCollection = vendaCollection;
    }

    @XmlTransient
    public Collection<Fornecedor> getFornecedorCollection() {
        return fornecedorCollection;
    }

    public void setFornecedorCollection(Collection<Fornecedor> fornecedorCollection) {
        this.fornecedorCollection = fornecedorCollection;
    }

    public int getCodTipoArtigo() {
        return codTipoArtigo;
    }

    public void setCodTipoArtigo(int codTipoArtigo) {
        this.codTipoArtigo = codTipoArtigo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codArtigo != null ? codArtigo.hashCode() : 0);
        return hash;
    }

    
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Artigo)) {
            return false;
        }
        Artigo other = (Artigo) object;
        if ((this.codArtigo == null && other.codArtigo != null) || (this.codArtigo != null && !this.codArtigo.equals(other.codArtigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.Entidade.Artigo[ codArtigo=" + codArtigo + " ]";
    }
    
}
