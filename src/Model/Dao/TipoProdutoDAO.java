/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Dao;

import Model.Entidade.Tipoproduto;
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
public class TipoProdutoDAO implements DaoInterface<Tipoproduto,Integer>{
    Connection con=null;
    
    public TipoProdutoDAO(){
    
    con=BDconexao.getconnection();
    }

    @Override
    public Tipoproduto inserir(Tipoproduto tp) {
         String sql="insert into tipoProduto(DescrTipoProduto) values(?)";
      PreparedStatement stmt=null;
      try{
      stmt=con.prepareStatement(sql);
      stmt.setString(1,tp.getDescrTipoProduto());
      
      stmt.executeUpdate();
      stmt.close();
     JOptionPane.showMessageDialog(null," Categoria Gravado com sucesso");
      }catch(SQLException ex){Logger.getLogger(BDconexao.class.getName()).log(Level.SEVERE,null,ex);
      }
      return tp;
    }

    @Override
    public void update(Tipoproduto tp) {
    
    String sql="Update TipoProduto set DescrTipoProduto=? where CodTipoProduto=?";
      PreparedStatement stmt=null;
      try{
      stmt=con.prepareStatement(sql);
      stmt.setString(1,tp.getDescrTipoProduto());
      stmt.setInt(2,tp.getCodTipoProduto());
      
      stmt.executeUpdate();
      stmt.close();
     JOptionPane.showMessageDialog(null," Categoria Gravado com sucesso");
      }catch(SQLException ex){Logger.getLogger(BDconexao.class.getName()).log(Level.SEVERE,null,ex);
      }
    
    
    }
    @Override
    public void delete(Tipoproduto tp) {
    String sql="delete tipoProduto where codTipoProduto=?";
        
        PreparedStatement stmt=null;
      try {
          stmt=con.prepareStatement(sql);
          stmt.setInt(1,tp.getCodTipoProduto());
          
          stmt.executeQuery();
          
          stmt.close();
         
      } catch (SQLException ex) {
          Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
      }
    
    
    
    }
    @Override
    public List<Tipoproduto> listar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List listarPorID(Integer i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
