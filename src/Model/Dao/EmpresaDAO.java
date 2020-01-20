/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Dao;

import Model.Entidade.Empresa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author JEQUE
 */
public class EmpresaDAO implements DaoInterface<Empresa,Integer> {
    
    Connection con;
    
    EmpresaDAO(){
    
    con=BDconexao.getconnection();
    }

    
 
 
    public Empresa inserir(Empresa e){
       
        String sql="Insert into Empresa(Nome,Cidade,Nuit,Telefone,Email) value(?,?,?,?,?)";
        PreparedStatement stmt=null;
        
       
        try {
             stmt=con.prepareStatement(sql);
            stmt.setString(1,e.getNome());
            stmt.setString(2,e.getCidade());
            stmt.setInt(3,e.getNuit());
            stmt.setInt(4,e.getTelefone());
            stmt.setString(5,e.getEmail());
            
          JOptionPane.showMessageDialog(null," Empresa Registada com Sucesso");       
        } catch (SQLException ex) {
            Logger.getLogger(EmpresaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
       return e; 
        
    }

    @Override
    public void update(Empresa e) {
        String sql="update Empresa set Nome=?,Cidade=?,Nuit=?,Telefone=?,Email=?";
        PreparedStatement stmt=null;
        
        try {
            stmt=con.prepareCall(sql);
            stmt.setString(1,e.getNome());
            stmt.setString(2,e.getCidade());
            stmt.setInt(3,e.getNuit());
            stmt.setInt(4,e.getTelefone());
            stmt.setString(5,e.getEmail());
            stmt.executeUpdate();
 
            stmt.close();
           JOptionPane.showMessageDialog(null," Empresa Actualizada com Sucesso");  
            
        } catch (SQLException ex) {
            Logger.getLogger(EmpresaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }

    @Override
    public void delete(Empresa e) {
        String sql="Delete Empresa where Nuit=?";
        PreparedStatement stmt=null;
        
        try {
            stmt=con.prepareCall(sql);
            stmt.setInt(1,e.getNuit());
            stmt.executeQuery();
            
            stmt.close();
             
            
            JOptionPane.showMessageDialog(null,"Excluido com sucesso");
    
        } catch (SQLException ex) {
            Logger.getLogger(EmpresaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
        
        
        
    }
    @Override
    public List<Empresa> listar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List listarPorID(Integer i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
    
    
    
}
