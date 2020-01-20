/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Entidade;

public class Venda{
    
    private int codVenda;
    private int quantidade;
    private double precoTotal;
 

    public Venda() {
    }

    public Venda(Integer codVenda) {
        this.codVenda = codVenda;
    }

    public Venda(Integer codVenda, int quantidade) {
        this.codVenda = codVenda;
        this.quantidade = quantidade;
    }

    public int getCodVenda() {
        return codVenda;
    }

    public void setCodVenda(int codVenda) {
        this.codVenda = codVenda;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getPrecoTotal() {
        return precoTotal;
    }

    public void setPrecoTotal(double precoTotal) {
        this.precoTotal = precoTotal;
    }

    
    
}
