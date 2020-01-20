/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Dao;

import Model.Entidade.Produto;
import java.sql.*;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author JEQUE
 */
public class ProdutoDAO implements DaoInterface<Produto,Integer>
{
  Connection con;
  
  public ProdutoDAO()
  {
  con=BDconexao.getconnection();
  }

   
    public Produto inserir(Produto p) {
        String sql="insert into Produto (Descr,Artigo,CodFornecedor,PrecoUnit,CodTipoProduto) value (?,?,?,?,?)";
        PreparedStatement stmt=null;
        
      try {
          stmt=con.prepareStatement(sql);
          stmt.setString(1,p.getDescr());
          stmt.setInt(2,p.getQuantidade());
          stmt.setInt(3,p.getCodFornecedor());
          stmt.setDouble(4,p.getPrecoUnit());
          stmt.setInt(5,p.getCodTipoProduto());
          
          stmt.executeUpdate();
          stmt.close();
          
          JOptionPane.showMessageDialog(null,"Produto Salvo com Sucesso");
      } catch (SQLException ex) {
          Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
      }
           
     return p;   
    }

    @Override
    public void update(Produto p) {
    String sql="Update Produto set Descr=?,Artigo=?,CodFornecedor=?,PrecoUnit=?,CodTipoProduto=?"+
           " where CodProduto=?";
        PreparedStatement stmt=null;
        
      try {
          stmt=con.prepareStatement(sql);
          stmt.setString(1,p.getDescr());
          stmt.setInt(2,p.getQuantidade());
          stmt.setInt(3,p.getCodFornecedor());
          stmt.setDouble(4,p.getPrecoUnit());
          stmt.setInt(5,p.getCodTipoProduto());
          stmt.setInt(6,p.getCodProduto());
          
          stmt.execute();
          stmt.close();
          
          JOptionPane.showMessageDialog(null,"Actualizado com Sucesso");
      } catch (SQLException ex) {
          Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
      }
   
    }

    @Override
    public void delete(Produto p) {
    
        String sql="delete from Produto where CodProduto=?";
        
        PreparedStatement stmt=null;
      try {
          stmt=con.prepareStatement(sql);
          stmt.setInt(1,p.getCodProduto());
          
          stmt.execute();
          
          stmt.close();
         
      } catch (SQLException ex) {
          Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
      }
    
    
    
    }

    @Override
    public List<Produto> listar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List listarPorID(Integer i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
  
  
  
    
    
    
}
