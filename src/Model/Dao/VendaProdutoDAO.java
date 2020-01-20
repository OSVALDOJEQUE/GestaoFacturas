/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Dao;

import Model.Entidade.VendaProduto;
import java.sql.Connection;
import java.sql.Date;
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
public class VendaProdutoDAO  implements DaoInterface<VendaProduto, Integer>{
    
    Connection con;
    
    VendaProdutoDAO(){
      con=BDconexao.getconnection();
    }

    @Override
    public VendaProduto inserir(VendaProduto vp) {
      String sql="Insert into VendaProduto(CodProduto,DataEmissao,DataValiade,quantidate,desconcto) value (?,?,?,?)";
      PreparedStatement stmt=null;
      
        try {
            stmt=con.prepareStatement(sql);
            stmt.setInt(1,vp.getCodProduto());
            stmt.setDate(2, (Date) vp.getDataEmissao());
            stmt.setDate(3,(Date)vp.getDataValidade());
            stmt.setInt(4,vp.getQuantidade());
            stmt.setInt(1,vp.getDesconto());
            
            stmt.executeUpdate();
            
            stmt.close();
            
            JOptionPane.showMessageDialog(null,"Salvo com sucesso");
        } catch (SQLException ex) {
            Logger.getLogger(VendaProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
      return vp;
    }

    @Override
    public void update(VendaProduto vp) {
         String sql="Upadete VendaProduto set CodProduto=? DataEmissao=?DataValiade=? quantidate=? desconcto=?";
      PreparedStatement stmt=null;
      
        try {
            stmt=con.prepareStatement(sql);
            stmt.setInt(1,vp.getCodProduto());
            stmt.setDate(2, (Date) vp.getDataEmissao());
            stmt.setDate(3,(Date)vp.getDataValidade());
            stmt.setInt(4,vp.getQuantidade());
            stmt.setInt(1,vp.getDesconto());
            
            stmt.executeUpdate();
            
            stmt.close();
            
            JOptionPane.showMessageDialog(null,"Actualizado com sucesso");
        } catch (SQLException ex) {
            Logger.getLogger(VendaProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
      
        
        
    }

    @Override
    public void delete(VendaProduto vp) {
        
        
    }
    @Override
    public List<VendaProduto> listar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List listarPorID(Integer i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
