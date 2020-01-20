/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Model.Dao.BDconexao;
import Model.Entidade.Usuario;
import View.PaginaLogin;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author JEQUE
 */
public class ContrUsuario {
    
    private Connection con;
    private BDconexao conex=new BDconexao();
    private static Usuario usuario;
    private final PaginaLogin login;
    
    
    public ContrUsuario(PaginaLogin login){
      
        usuario=new Usuario();
        this.login=login;
       
    }
    
    public boolean avalia(JTextField nome,JPasswordField senha,JLabel status){
   boolean result=(login(nome.getText(),senha.getText()));
    if(nome.getText().isEmpty()|senha.getText().isEmpty()|!result){
     nome.setText("");
     senha.setText("");
     
     new Thread(){
         public void run(){
         for (int i = 0; true; i++) {
                        try {
                            sleep(450);
                            if (i % 2 == 0) {
                                status.setText("Nome do Usuario ou senha invalido");
                            } else {
                                status.setText("");
                            }
                        } catch (InterruptedException exception) {
                        }
                    }
                }
         
     }.start();
     
     result=false;
    }
   return result;
    }
    
    
    
    public boolean login(String nome, String senha){
   boolean result=false;
    con=BDconexao.getconnection();
    String sql="Select nome,senha,tipo from usuario where nome='"+nome+"' and senha='"+senha+"'";
          conex.executaSql(sql);
     
        try {
            conex.rs.first();
           do{
            usuario.setNome(conex.rs.getString("nome"));
            usuario.setSenha(conex.rs.getString("senha"));
            usuario.setTipo(conex.rs.getString("Tipo"));
           result=true;
           }while(conex.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar usuario");
        }
    BDconexao.fecharConexao(con);
    
   return result;
    }

    public Usuario getUsuario() {
        return usuario;
    }
    
    
}
