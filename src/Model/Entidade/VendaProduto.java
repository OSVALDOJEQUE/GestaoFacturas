/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Entidade;
  import java.util.Date;

public class VendaProduto{
    
   private  int codVenda,codProduto;
   private Date dataEmissao,dataValidade;
   private int quantidade,desconto;
   
   VendaProduto(){
   }

    public VendaProduto(int codVenda, int codProduto, Date dataEmissao, Date dataPartida, int quantidade) {
        this.codVenda = codVenda;
        this.codProduto = codProduto;
        this.dataEmissao = dataEmissao;
        this.dataValidade = dataPartida;
        this.quantidade = quantidade;
    }

    public int getCodVenda() {
        return codVenda;
    }

    public void setCodVenda(int codVenda) {
        this.codVenda = codVenda;
    }

    public int getCodProduto() {
        return codProduto;
    }

    public void setCodProduto(int codProduto) {
        this.codProduto = codProduto;
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

    public void setDataValidade(Date dataValidadea) {
        this.dataValidade = dataValidade;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public int getDesconto() {
        return desconto;
    }

    public void setDesconto(int desconto) {
        this.desconto = desconto;
    }
    
   
}
