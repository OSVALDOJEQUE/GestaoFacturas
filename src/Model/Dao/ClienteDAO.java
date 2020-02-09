/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Dao;

import Model.Entidade.Cliente;
import Model.Entidade.Fornecedor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author JEQUE
 */
public class ClienteDAO  implements DaoInterface<Cliente,Integer>{
    
    private Connection con;
     BDconexao conex=new BDconexao();
     
   
    public ClienteDAO(){
        con=BDconexao.getconnection();
        
      }

 
    public Cliente inserir(Cliente c) {
      
        String sql="insert into Cliente (nome,Nuit,NrEdificio,CodPostal,CaixaPostal.CodCliente) values(?,?,?,?,?,?)";
      PreparedStatement stmt=null;
      try{
      stmt=con.prepareStatement(sql);
      stmt.setString(1,c.getNome());
      stmt.setInt(2,c.getNuit());
      stmt.setInt(3,c.getNrEdificio());
      stmt.setInt(4, c.getCaixaPostal());
      stmt.setInt(5, c.getCodPostal());
      stmt.setInt(6,c.getCodEndereco());
   
      stmt.executeUpdate();
      stmt.close();
     JOptionPane.showMessageDialog(null," Cliente Gravado com sucesso");
      }catch(SQLException ex){Logger.getLogger(BDconexao.class.getName()).log(Level.SEVERE,null,ex);
      }
      
      return c;
    }

    @Override
    public void update(Cliente c) {
        
        String sql="update Cliente set nome=?,Nuit=?,NrEdificio=?, CaixaPosta=?,CodPostal, CodEndereco=? where codCliente=?";
        
        PreparedStatement stmt=null;
        try{
      stmt.setString(1,c.getNome());
      stmt.setInt(2,c.getNuit());
      stmt.setInt(3,c.getNrEdificio());
      stmt.setInt(4, c.getCaixaPostal());
      stmt.setInt(5, c.getCodPostal());
      stmt.setInt(6,c.getCodEndereco());
      stmt.setInt(7, c.getCodCliente());
        
        stmt.execute();
       stmt.close();
        
        JOptionPane.showMessageDialog(null," Cliente Actualizado com sucesso");
        }catch(SQLException ex){Logger.getLogger(BDconexao.class.getName()).log(Level.SEVERE,null,ex);}
  
    }

    public void delete(Cliente f) {
        String sql="Delete from Fornecedor where CodCliente=?";
        PreparedStatement stmt=null;
        try{
            stmt=con.prepareStatement(sql);
            stmt.setInt(1,f.getCodCliente());
            
            stmt.execute();
            
            stmt.close();
            
        JOptionPane.showMessageDialog(null,"Excluido com sucesso");
        }catch(SQLException ex){Logger.getLogger(BDconexao.class.getName()).log(Level.SEVERE,null,ex);}
        
        
        
        
    }

  
    public List<Cliente> listar() {
        String sql="Select* from Fornecedor";
        PreparedStatement stmt=null;
        ResultSet rs=null;
        List<Cliente> clientes=new ArrayList();
        
        try{
            stmt=con.prepareStatement(sql);
            rs=stmt.executeQuery();
            while(rs.next()){
            Cliente c=new Cliente();
            
            c.setNome(rs.getString("nome"));
            c.setNuit(Integer.parseInt(rs.getString("Nuit"))) ;
             c.setNrEdificio(Integer.parseInt(rs.getString("NrEdificio")));
             c.setCaixaPostal(Integer.parseInt(rs.getString("CaixaPostal"))) ;
               c.setCodPostal(Integer.parseInt(rs.getString("CodPostal"))) ;
             c.setCodEndereco(Integer.parseInt(rs.getString("CodEndereco")));
         
            clientes.add(c);
            }
            stmt.close();
            rs.close();
            
        
        
        }catch(SQLException ex){Logger.getLogger(BDconexao.class.getName()).log(Level.SEVERE,null,ex);}
        return clientes;
    }

  
    public List listarPorID(Integer i) {
     String sql="Select* from Fornecedor where codFornecedor=?";
        PreparedStatement stmt=null;
        ResultSet rs=null;
        List<Cliente> clientes=new ArrayList();
        
        try{
             stmt=con.prepareStatement(sql);
             stmt.setInt(1,i);
             rs=stmt.executeQuery();
            
            
            while(rs.next()){
            Cliente c=new Cliente();
               c.setNome(rs.getString("nome"));
            c.setNuit(Integer.parseInt(rs.getString("Nuit"))) ;
             c.setNrEdificio(Integer.parseInt(rs.getString("NrEdificio")));
             c.setCaixaPostal(Integer.parseInt(rs.getString("CaixaPostal"))) ;
               c.setCodPostal(Integer.parseInt(rs.getString("CodPostal"))) ;
             c.setCodEndereco(Integer.parseInt(rs.getString("CodEndereco")));
            
            clientes.add(c);
            }
            stmt.close();
            rs.close();
            
        
        
        }catch(SQLException ex){Logger.getLogger(BDconexao.class.getName()).log(Level.SEVERE,null,ex);}
        return clientes;
    }
    
    public Cliente BuscaClientes(Cliente cli){
       conex.executaSql("Select *from Fornecedor where nome like'%"+cli.getPesquisa()+"%'");
        try {
            conex.rs.first();
            cli.setCodCliente(conex.rs.getInt("codFornecedor"));
            cli.setNome(conex.rs.getString("Nome"));
            cli.setNuit(Integer.parseInt(conex.rs.getString("CaixaPostal")));
            cli.setNrEdificio(Integer.parseInt(conex.rs.getString("NrEdifico")));
            cli.setCaixaPostal(Integer.parseInt(conex.rs.getString("CaixaPostal")));
            cli.setCodPostal(Integer.parseInt(conex.rs.getString("CodPostal")));
            cli.setCodEndereco(Integer.parseInt(conex.rs.getString("CodEndereco")));
        } catch (SQLException ex) {
               JOptionPane.showMessageDialog(null,"Fornecedor Não cadastrado");
        }
     
       return cli;
    }
    
    
    
    
}
