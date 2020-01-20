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
public class Fornecedor{
    private int codFornecedor ;
    private String nome;
    private String endereco;
    private int telefone;
    private String pesquisa;
  

    public Fornecedor() {
    }

    public Fornecedor(Integer codFornecedor) {
        this.codFornecedor = codFornecedor;
    }

    public Fornecedor(Integer codFornecedor, String nome, String endereco, int telefone) {
        this.codFornecedor = codFornecedor;
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
    }

    public Integer getCodFornecedor() {
        return codFornecedor;
    }

    public void setCodFornecedor(Integer codFornecedor) {
        this.codFornecedor = codFornecedor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public int getTelefone() {
        return telefone;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

    /**
     * @return the pesquisa
     */
    public String getPesquisa() {
        return pesquisa;
    }

    /**
     * @param pesquisa the pesquisa to set
     */
    public void setPesquisa(String pesquisa) {
        this.pesquisa = pesquisa;
    }
    

}
