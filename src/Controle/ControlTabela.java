/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Model.Dao.BDconexao;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

/**
 *
 * @author JEQUE
 */
public class ControlTabela {
   Connection con;
   BDconexao conex=new BDconexao();
    ControlTabela(){
    
    
    
    }
    
    
    public void TabelaArtigo(String sql,JTable jTableArtigo){
    ArrayList dados=new ArrayList();
    String[] colunas=new String[]{"Artigo","Descricao","Quantidade","Unidade","Preco","Marca"};
    con=BDconexao.getconnection();
    conex.executaSql(sql);
    try{
    conex.rs.first();
    do{
       dados.add(new Object[]{conex.rs.getInt("Artigo"),conex.rs.getString("Descricao"),
       conex.rs.getInt("Quantidade"),conex.rs.getString("Unidade"),conex.rs.getInt("Preco"),
       conex.rs.getString("Marca")});
      
    }while(conex.rs.next());
    }catch(SQLException ex){
    
        JOptionPane.showMessageDialog(null,"Erro no preenchimento da tabela Artigo");
    } 
    Tabela modelo=new Tabela(dados,colunas);
             
  
   
    jTableArtigo.setModel(modelo);
    jTableArtigo.getColumnModel().getColumn(0).setPreferredWidth(100);
    jTableArtigo.getColumnModel().getColumn(0).setResizable(false);
     jTableArtigo.getColumnModel().getColumn(1).setPreferredWidth(300);
    jTableArtigo.getColumnModel().getColumn(1).setResizable(false);
     jTableArtigo.getColumnModel().getColumn(2).setPreferredWidth(100);
    jTableArtigo.getColumnModel().getColumn(2).setResizable(false);
     jTableArtigo.getColumnModel().getColumn(3).setPreferredWidth(100);
    jTableArtigo.getColumnModel().getColumn(3).setResizable(false);
     jTableArtigo.getColumnModel().getColumn(4).setPreferredWidth(100);
    jTableArtigo.getColumnModel().getColumn(4).setResizable(false);
     jTableArtigo.getColumnModel().getColumn(5).setPreferredWidth(100);
    jTableArtigo.getColumnModel().getColumn(5).setResizable(false);
        jTableArtigo.getColumnModel().getColumn(6).setPreferredWidth(100);
    jTableArtigo.getColumnModel().getColumn(6).setResizable(false);
    
    jTableArtigo.getTableHeader().setReorderingAllowed(false);
    jTableArtigo.setAutoResizeMode(jTableArtigo.AUTO_RESIZE_OFF);
    jTableArtigo.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    
    
    
    BDconexao.fecharConexao(con);
    }
    
         public void preenceherComboBox(JComboBox jc1,JComboBox jc2,JComboBox jc3 )
         {
            
             jc1.addItem("litro");
             
         
         
         
         }
         
         
}


