/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Dao;

import Model.Entidade.Tipoartigo;
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
public class TipoArtigoDAO implements DaoInterface<Tipoartigo,Integer>{
    Connection con=null;
    
    public TipoArtigoDAO(){
    
    con=BDconexao.getconnection();
    }

    @Override
    public Tipoartigo inserir(Tipoartigo ta) {
         String sql="insert into tipoartigo(Descricao) values(?)";
      PreparedStatement stmt=null;
      try{
      stmt=con.prepareStatement(sql);
      stmt.setString(1,ta.getDescricao());
      
      stmt.executeUpdate();
      stmt.close();
     JOptionPane.showMessageDialog(null," Categoria Gravado com sucesso");
      }catch(SQLException ex){Logger.getLogger(BDconexao.class.getName()).log(Level.SEVERE,null,ex);
      }
      return ta;
    }

    @Override
    public void update(Tipoartigo ta) {
    
    String sql="Update tipoartigo set DescrTipoProduto=? where CodTipoArtigo=?";
      PreparedStatement stmt=null;
      try{
      stmt=con.prepareStatement(sql);
      stmt.setString(1,ta.getDescricao());
      stmt.setInt(2,ta.getCodTipoArtigo());
      
      stmt.executeUpdate();
      stmt.close();
     JOptionPane.showMessageDialog(null," Categoria Gravado com sucesso");
      }catch(SQLException ex){Logger.getLogger(BDconexao.class.getName()).log(Level.SEVERE,null,ex);
      }
    
    
    }
    @Override
    public void delete(Tipoartigo ta) {
    String sql="delete tipoartigo where codTipoProduto=?";
        
        PreparedStatement stmt=null;
      try {
          stmt=con.prepareStatement(sql);
          stmt.setInt(1,ta.getCodTipoArtigo());
          
          stmt.executeQuery();
          
          stmt.close();
         
      } catch (SQLException ex) {
          Logger.getLogger(ArtigoDAO.class.getName()).log(Level.SEVERE, null, ex);
      }
    
    
    
    }
    @Override
    public List<Tipoartigo> listar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List listarPorID(Integer i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
