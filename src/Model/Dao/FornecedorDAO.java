/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Dao;

import Model.Entidade.Fornecedor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author JEQUE
 */
public class FornecedorDAO implements DaoInterface<Fornecedor,Integer> {
    
    private Connection con;
  
    
     BDconexao conex=new BDconexao();
     
   
    public FornecedorDAO(){
        con=BDconexao.getconnection();
        
      }

 
    public Fornecedor inserir(Fornecedor f) {
      
        String sql="insert into Fornecedor(nome,Nuit,NrEdificio,CodPostal,CaixaPostal.CodEndereco) values(?,?,?,?,?,?)";
      PreparedStatement stmt=null;
      try{
      stmt=con.prepareStatement(sql);
      stmt.setString(1,f.getNome());
      stmt.setInt(2,f.getNuit());
      stmt.setInt(3,f.getNrEdficio());
      stmt.setInt(4, f.getCaixaPostal());
      stmt.setInt(5, f.getCodPostal());
      stmt.setInt(6,f.getCodEndereco());
   
      stmt.executeUpdate();
      stmt.close();
     JOptionPane.showMessageDialog(null," Forncedor Gravado com sucesso");
      }catch(SQLException ex){Logger.getLogger(BDconexao.class.getName()).log(Level.SEVERE,null,ex);
      }
      
      return f;
    }

    @Override
    public void update(Fornecedor f) {
        
        String sql="update Fornecedor set nome=?,Nuit=?,NrEdificio=?, CaixaPosta=?,CodPostal, CodEndereco=? where codFornecedor=?";
        
        PreparedStatement stmt=null;
        try{
      stmt.setString(1,f.getNome());
      stmt.setInt(2,f.getNuit());
      stmt.setInt(3,f.getNrEdficio());
      stmt.setInt(4, f.getCaixaPostal());
      stmt.setInt(5, f.getCodPostal());
      stmt.setInt(6,f.getCodEndereco());
      stmt.setInt(7, f.getCodFornecedor());
        
        stmt.execute();
       stmt.close();
        
        JOptionPane.showMessageDialog(null," Forncedor Actualizado com sucesso");
        }catch(SQLException ex){Logger.getLogger(BDconexao.class.getName()).log(Level.SEVERE,null,ex);}
  
    }

    public void delete(Fornecedor f) {
        String sql="Delete from Fornecedor where CodFornecedor=?";
        PreparedStatement stmt=null;
        try{
            stmt=con.prepareStatement(sql);
            stmt.setInt(1,f.getCodFornecedor());
            
            stmt.execute();
            
            stmt.close();
            
        JOptionPane.showMessageDialog(null,"Excluido com sucesso");
        }catch(SQLException ex){Logger.getLogger(BDconexao.class.getName()).log(Level.SEVERE,null,ex);}
        
        
        
        
    }

  
    public List<Fornecedor> listar() {
        String sql="Select* from Fornecedor";
        PreparedStatement stmt=null;
        ResultSet rs=null;
        List<Fornecedor> fornecedores=new ArrayList();
        
        try{
            stmt=con.prepareStatement(sql);
            rs=stmt.executeQuery();
            while(rs.next()){
            Fornecedor f=new Fornecedor();
            
            f.setNome(rs.getString("nome"));
            f.setNuit(Integer.parseInt(rs.getString("Nuit"))) ;
             f.setNrEdficio(Integer.parseInt(rs.getString("NrEdificio")));
             f.setCaixaPostal(Integer.parseInt(rs.getString("CaixaPostal"))) ;
               f.setCodPostal(Integer.parseInt(rs.getString("CodPostal"))) ;
             f.setCodEndereco(Integer.parseInt(rs.getString("CodEndereco")));
         
            fornecedores.add(f);
            }
            stmt.close();
            rs.close();
            
        
        
        }catch(SQLException ex){Logger.getLogger(BDconexao.class.getName()).log(Level.SEVERE,null,ex);}
        return fornecedores;
    }

  
    public List listarPorID(Integer i) {
     String sql="Select* from Fornecedor where codFornecedor=?";
        PreparedStatement stmt=null;
        ResultSet rs=null;
        List<Fornecedor> fornecedores=new ArrayList();
        
        try{
             stmt=con.prepareStatement(sql);
             stmt.setInt(1,i);
             rs=stmt.executeQuery();
            
            
            while(rs.next()){
            Fornecedor f=new Fornecedor();
               f.setNome(rs.getString("nome"));
            f.setNuit(Integer.parseInt(rs.getString("Nuit"))) ;
             f.setNrEdficio(Integer.parseInt(rs.getString("NrEdificio")));
             f.setCaixaPostal(Integer.parseInt(rs.getString("CaixaPostal"))) ;
               f.setCodPostal(Integer.parseInt(rs.getString("CodPostal"))) ;
             f.setCodEndereco(Integer.parseInt(rs.getString("CodEndereco")));
            
            fornecedores.add(f);
            }
            stmt.close();
            rs.close();
            
        
        
        }catch(SQLException ex){Logger.getLogger(BDconexao.class.getName()).log(Level.SEVERE,null,ex);}
        return fornecedores;
    }
    
    public Fornecedor BuscaFornecedor(Fornecedor fo){
       conex.executaSql("Select *from Fornecedor where nome like'%"+fo.getPesquisa()+"%'");
        try {
            conex.rs.first();
            fo.setCodFornecedor(conex.rs.getInt("codFornecedor"));
            fo.setNome(conex.rs.getString("Nome"));
            fo.setNuit(Integer.parseInt(conex.rs.getString("CaixaPostal")));
            fo.setNrEdficio(Integer.parseInt(conex.rs.getString("NrEdifico")));
            fo.setCaixaPostal(Integer.parseInt(conex.rs.getString("CaixaPostal")));
            fo.setCodPostal(Integer.parseInt(conex.rs.getString("CodPostal")));
            fo.setCodEndereco(Integer.parseInt(conex.rs.getString("CodEndereco")));
        } catch (SQLException ex) {
               JOptionPane.showMessageDialog(null,"Fornecedor Não cadastrado");
        }
     
       return fo;
    }
    
    
    
}
