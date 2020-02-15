/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Dao;

import Model.Entidade.Contactoc;
import Model.Entidade.Contactof;
import Model.Entidade.Endereco;
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
public class TodoDAO {
    
    Connection con;
     BDconexao conex=new BDconexao();
    public TodoDAO(){
   
    }
    
    
   // DAO Contactos
    
    public Contactoc inserirC(Contactoc cc) {
      String sql="insert into contactoc(email,TelFixo,TelCelular,CodCliente) values (?,?,?,?)";
      PreparedStatement stmt=null;
      try{
            stmt=con.prepareStatement(sql);
            stmt.setString(1,cc.getEmail());
            stmt.setInt(2,cc.getTelFixo());
            stmt.setInt(3,cc.getTelCelular());
            stmt.setInt(4,cc.getCodCliente());

            stmt.executeUpdate();
            stmt.close();
     JOptionPane.showMessageDialog(null," Categoria Gravado com sucesso");
      }catch(SQLException ex){Logger.getLogger(BDconexao.class.getName()).log(Level.SEVERE,null,ex);
      }
      return cc;
    }
    
    
    public void updateC(Contactoc cc) {
    
    String sql="Update contactoc set email=? TelFixo=? telCelulat=? CodCliente where codContactoc=?";
      PreparedStatement stmt=null;
      try{
      stmt=con.prepareStatement(sql);
      stmt.setString(1,cc.getEmail());
      stmt.setInt(2,cc.getTelFixo());
      stmt.setInt(3, cc.getTelCelular());
      stmt.setInt(4, cc.getCodCliente());
      stmt.setInt(5, cc.getCodContacto());
      
      stmt.executeUpdate();
      stmt.close();
     JOptionPane.showMessageDialog(null," Contacto Gravado com sucesso");
      }catch(SQLException ex){Logger.getLogger(BDconexao.class.getName()).log(Level.SEVERE,null,ex);
      }
    
    
    }
    
    
    public void deleteC(Contactoc cc) {
    String sql="delete Contactoc where codFornecedor=?";
        
        PreparedStatement stmt=null;
      try {
          stmt=con.prepareStatement(sql);
          stmt.setInt(1,cc.getCodContacto());
          
          stmt.executeQuery();
          
          stmt.close();
         
      } catch (SQLException ex) {
          Logger.getLogger(ArtigoDAO.class.getName()).log(Level.SEVERE, null, ex);
      }
    
    
    
    }
   
    public List<Contactoc> listarC() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

  
    public List listarPorIDC(Integer i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    //DAO ContactoF
        
    public Contactof inserirF(Contactof cf) {
      String sql="insert into contactof(email,TelFixo,TelCelular,CodFornecedor) values (?,?,?,?)";
      PreparedStatement stmt=null;
      try{
            stmt=con.prepareStatement(sql);
            stmt.setString(1,cf.getEmail());
            stmt.setInt(2,cf.getTelFixo());
            stmt.setInt(3,cf.getTelCelular());
            stmt.setInt(4,cf.getCodFornecedor());
     

            stmt.executeUpdate();
            stmt.close();
     JOptionPane.showMessageDialog(null," Contacto Gravado com sucesso");
      }catch(SQLException ex){Logger.getLogger(BDconexao.class.getName()).log(Level.SEVERE,null,ex);
      }
      return cf;
    }
    
    
    public void updateF(Contactof cf) {
    
    String sql="Update contactof set email=? TelFixo=? telCelulat=? CodCliente=? where codContactof=?";
      PreparedStatement stmt=null;
      try{
      stmt=con.prepareStatement(sql);
      stmt.setString(1,cf.getEmail());
      stmt.setInt(2,cf.getTelFixo());
      stmt.setInt(3, cf.getTelCelular());
      stmt.setInt(4, cf.getCodFornecedor());
      stmt.setInt(5, cf.getCodContacto());
      
      stmt.executeUpdate();
      stmt.close();
     JOptionPane.showMessageDialog(null," Contacto Gravado com sucesso");
      }catch(SQLException ex){Logger.getLogger(BDconexao.class.getName()).log(Level.SEVERE,null,ex);
      }
    
    
    }
    
    
    public void deleteF(Contactof cf) {
    String sql="delete Contactof where codFornecedor=?";
        
        PreparedStatement stmt=null;
      try {
          stmt=con.prepareStatement(sql);
          stmt.setInt(1,cf.getCodContacto());
          
          stmt.executeQuery();
          
          stmt.close();
         
      } catch (SQLException ex) {
          Logger.getLogger(ArtigoDAO.class.getName()).log(Level.SEVERE, null, ex);
      }
    
    
    
    }
   
    public List<Contactof> listar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

  
    public List listarPorID(Integer i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    //DAO Endereco
         public Endereco inserirE(Endereco en) {
      String sql="insert into endereco (Distrito, Cidade, Avenida, Rua) values (?,?,?,?)";
      PreparedStatement stmt=null;
      try{
            stmt=con.prepareStatement(sql);
            stmt.setString(1,en.getDistrito());
            stmt.setString(2,en.getCidade());
            stmt.setString(3,en.getAvenida());
            stmt.setString(4,en.getRua());
     

            stmt.executeUpdate();
            stmt.close();
     JOptionPane.showMessageDialog(null," endereco Gravado com sucesso");
      }catch(SQLException ex){Logger.getLogger(BDconexao.class.getName()).log(Level.SEVERE,null,ex);
      }
      return en;
    }
    
    
    public void updateE(Endereco en) {
    
    String sql="Update Endereco set email=? TelFixo=? telCelulat=? CodCliente=? where cod=?";
      PreparedStatement stmt=null;
      try{
      stmt=con.prepareStatement(sql);
      stmt.setString(1,en.getDistrito());
      stmt.setString(2,en.getCidade());
      stmt.setString(3, en.getAvenida());
      stmt.setString(4, en.getRua());
      stmt.setInt(5, en.getCodEndereco());
      
      stmt.executeUpdate();
      stmt.close();
     JOptionPane.showMessageDialog(null," Endereco Gravado com sucesso");
      }catch(SQLException ex){Logger.getLogger(BDconexao.class.getName()).log(Level.SEVERE,null,ex);
      }
    
    
    }
    
    
    public void deleteE(Endereco en) {
    String sql="delete Endereco where codEndereco=?";
        
        PreparedStatement stmt=null;
      try {
          stmt=con.prepareStatement(sql);
          stmt.setInt(1,en.getCodEndereco());
          
          stmt.executeQuery();
          
          stmt.close();
         
      } catch (SQLException ex) {
          Logger.getLogger(ArtigoDAO.class.getName()).log(Level.SEVERE, null, ex);
      }
    
    
    
    }
   
    public List<Endereco> listarE() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

  
    public List listarPorIDE(Integer i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
      public Endereco BuscaEndereco(Endereco end){
       conex.executaSql("Select *from Endereco where codEndereco like'%"+end.getPesquisa()+"%'");
        try {
           
            conex.rs.first();
            end.setCodEndereco(conex.rs.getInt("codEndereco"));
            end.setDistrito(conex.rs.getString("Distrito"));
             end.setCidade(conex.rs.getString("Cidade"));
              end.setAvenida(conex.rs.getString("Avenida"));
               end.setRua(conex.rs.getString("Rua"));
        } catch (SQLException ex) {
               JOptionPane.showMessageDialog(null,"Endereco Encontrado");
        }
     
       return end;
    }

    //DAO classe
    
    //DAO contas 
    
    
    
    
}
