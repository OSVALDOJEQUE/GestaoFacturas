/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Dao;

import Model.Entidade.Artigo;
import java.sql.*;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author JEQUE
 */
public class ArtigoDAO implements DaoInterface<Artigo,Integer>
{
  Connection con;
  
  public ArtigoDAO()
  {
  con=BDconexao.getconnection();
  }

   
    public Artigo inserir(Artigo a) {
        String sql="insert into Artigo (Descricao,Quantidade,precoUnit,Taxa,CodTipoArtigo,Artigo,Unidade,Marca,Cor,Peso,Moeda) values (?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement stmt=null;
        
      try {
          stmt=con.prepareStatement(sql);
          stmt.setString(1,a.getDescricao());
          stmt.setInt(2,a.getQuantidade());
          stmt.setBigDecimal(3,a.getPrecoUnit());
          stmt.setString(4,a.getTaxa());
          stmt.setInt(5,a.getCodTipoArtigo());
           stmt.setString(6,a.getArtigo());
          stmt.setString(7,a.getUnidade());
          stmt.setString(8,a.getMarca());
          stmt.setString(9,a.getCor());
          stmt.setFloat(10,a.getPeso());
          stmt.setString(11,a.getMoeda());
          
          stmt.executeUpdate();
          stmt.close();
          
          JOptionPane.showMessageDialog(null,"Produto Salvo com Sucesso");
      } catch (SQLException ex) {
          Logger.getLogger(ArtigoDAO.class.getName()).log(Level.SEVERE, null, ex);
      }
           
     return a;   
    }

    @Override
    public void update(Artigo a) {
    String sql="Update CodArtigo set Descr=?,Artigo=?,CodFornecedor=?,PrecoUnit=?,CodArtigo=?"+
           " where CodProduto=?";
        PreparedStatement stmt=null;
        
      try {
          stmt=con.prepareStatement(sql);
        stmt.setString(1,a.getDescricao());
          stmt.setInt(2,a.getQuantidade());
          stmt.setBigDecimal(3,a.getPrecoUnit());
          stmt.setInt(4,a.getCodTipoArtigo());
          stmt.setInt(5,a.getCodArtigo());
          
          stmt.execute();
          stmt.close();
          
          JOptionPane.showMessageDialog(null,"Actualizado com Sucesso");
      } catch (SQLException ex) {
          Logger.getLogger(ArtigoDAO.class.getName()).log(Level.SEVERE, null, ex);
      }
   
    }

    @Override
    public void delete(Artigo a) {
    
        String sql="delete from Artigo where CodProduto=?";
        
        PreparedStatement stmt=null;
      try {
          stmt=con.prepareStatement(sql);
          stmt.setInt(1,a.getCodArtigo());
          
          stmt.execute();
          
          stmt.close();
         
      } catch (SQLException ex) {
          Logger.getLogger(ArtigoDAO.class.getName()).log(Level.SEVERE, null, ex);
      }
    
    
    
    }

    @Override
    public List<Artigo> listar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List listarPorID(Integer i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
  
  
  
    
    
    
}
