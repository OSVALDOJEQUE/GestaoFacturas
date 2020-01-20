/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Dao;

import Model.Entidade.Tipoproduto;
import Model.Entidade.tipo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author JEQUE
 */
public class UsuarioDAO implements DaoInterface<tipo,Integer> {
    Connection con=null;
    
   public UsuarioDAO(){
    
    con=BDconexao.getconnection();
    }

    @Override
    public tipo inserir(tipo u) {
         String sql="insert into usuario(nome,senha,Tipo)values(?,?,?)";
      PreparedStatement stmt=null;
      try{
      stmt=con.prepareStatement(sql);
     
      
      stmt.setString(1,u.getNome());
      stmt.setString(2,u.getSenha());
      stmt.setString(3,u.getTipo());
      
     
      stmt.executeUpdate();
      stmt.close();
     JOptionPane.showMessageDialog(null," Categoria Gravado com sucesso");
      }catch(SQLException ex){Logger.getLogger(BDconexao.class.getName()).log(Level.SEVERE,null,ex);
      }
      return u;
    }

    @Override
    public void update(tipo u) {
    
    String sql="Update usuario set nome=?,senha=?,Tipo=? where codUsuario=?";
      PreparedStatement stmt=null;
      try{
      stmt=con.prepareStatement(sql);
      stmt.setString(1, u.getNome());
      stmt.setString(2,u.getSenha());
      stmt.setString(3,u.getTipo());
      stmt.setInt(4,u.getCodUsuario());
      
      stmt.execute();
      stmt.close();
     JOptionPane.showMessageDialog(null," Usuario alterado com sucesso");
      }catch(SQLException ex){JOptionPane.showMessageDialog(null," Usuario alterado com sucesso"+ex);
      }
    
    
    }
    @Override
    public void delete(tipo u) {
    String sql="delete from Usuario where codUsuario=?";
        
        PreparedStatement stmt=null;
      try {
          stmt=con.prepareStatement(sql);
          stmt.setInt(1,u.getCodUsuario());
          
          stmt.execute(); 
          stmt.close();
          
      } catch (SQLException ex) {
          Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
      }
    
    
    
    }

   
    @Override
    public List<tipo> listar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List listarPorID(Integer i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
