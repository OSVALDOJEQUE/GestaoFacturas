/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Entidade;

public class Empresa{
    
    
    private String nome,cidade,email;
    private int nuit,telefone;

    
    Empresa(){
    
    }
    public Empresa(String nome, String cidade, String email, int nuit, int telefone) {
        this.nome = nome;
        this.cidade = cidade;
        this.email = email;
        this.nuit = nuit;
        this.telefone = telefone;
    }

    
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getNuit() {
        return nuit;
    }

    public void setNuit(int nuit) {
        this.nuit = nuit;
    }

    public int getTelefone() {
        return telefone;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }
    
    
    
}
