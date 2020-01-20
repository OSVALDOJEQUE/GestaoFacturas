/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Entidade;


/**
 *
 * @author JEQUE
 */
public class Produto{
    
    private int codProduto,codFornecedor,codTipoProduto;
    private int quantidade;
    private String descr;
    private double precoUnit;
    private String pesquisa;
    

    public Produto() {
    }

    public Produto(Integer codProduto) {
        this.codProduto = codProduto;
    }

    public Produto(Integer codProduto, String descr) {
        this.codProduto = codProduto;
        this.descr = descr;
    }

    public int getCodProduto() {
        return codProduto;
    }

    public void setCodProduto(int codProduto) {
        this.codProduto = codProduto;
    }

    public int getCodFornecedor() {
        return codFornecedor;
    }

    public void setCodFornecedor(int codFornecedor) {
        this.codFornecedor = codFornecedor;
    }

    public int getCodTipoProduto() {
        return codTipoProduto;
    }

    public void setCodTipoProduto(int codTipoProduto) {
        this.codTipoProduto = codTipoProduto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    public double getPrecoUnit() {
        return precoUnit;
    }

    public void setPrecoUnit(double precoUnit) {
        this.precoUnit = precoUnit;
    }

    /**
     * @return the pesquisa
     */
    public String getPesquisa() {
        return pesquisa;
    }

    /**
     * @param pesquisa the  to set
     */
    public void setPesquisa(String pesquisa) {
        this.pesquisa = pesquisa;
    }

  
}
