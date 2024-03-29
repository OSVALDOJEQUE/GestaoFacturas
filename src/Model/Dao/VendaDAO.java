/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Dao;

import Model.Entidade.Fornecedor;
import Model.Entidade.Venda;
import java.math.BigDecimal;
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
public class VendaDAO implements DaoInterface<Venda, Integer> {
    
    private Connection con;
    
    BDconexao conex;
    
    public VendaDAO(){
      con=BDconexao.getconnection();
 
    }

    @Override
    public Venda inserir(Venda v) {
        String sql="insert into venda(quantidade,PrecoTotal,iva,Desconta,CodCliente) values(?,?,?,?,?)";
        PreparedStatement stmt=null;
        
        try {
            stmt=con.prepareStatement(sql);
            
            stmt.setInt(1, v.getQuantidade());
            stmt.setBigDecimal(2,v.getIva());
            stmt.setInt(3, v.getDesconta());
            stmt.setBigDecimal(4, v.getIva());
            stmt.setInt(5,v.getCodCliente());
            
            stmt.execute(sql);
            stmt.close();
            JOptionPane.showMessageDialog(null, "Venda Efectuada com sucesso");
        } catch (SQLException ex) {
            Logger.getLogger(VendaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       return v;    
    }

    @Override
    public void update(Venda v) {
      String sql="Update venda set quantidade=? precoUnit=? iva=? Desconta=? CodCliente=? where codVenda=?";
      
      PreparedStatement stmt=null;
      
        try {
            stmt=con.prepareStatement(sql);
              stmt.setInt(1, v.getQuantidade());
            stmt.setBigDecimal(2,v.getIva());
            stmt.setInt(3, v.getDesconta());
            stmt.setBigDecimal(4, v.getIva());
            stmt.setInt(5,v.getCodCliente());
            stmt.setInt(6,v.getCodVenda());
            
            stmt.execute();
            stmt.close();
            JOptionPane.showMessageDialog(null, "Actualizado com sucesso");
            
        } catch (SQLException ex) {
            Logger.getLogger(VendaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }         
    }

    @Override
    public void delete(Venda f) {
          String sql="delete from venda where codVenda=?";
        
        PreparedStatement stmt=null;
      try {
          stmt=con.prepareStatement(sql);
          stmt.setInt(1,f.getCodVenda());
          
          stmt.execute(); 
          stmt.close();
          
      } catch (SQLException ex) {
          Logger.getLogger(ArtigoDAO.class.getName()).log(Level.SEVERE, null, ex);
      }
    
    }

    @Override
    public List<Venda> listar() {
        
        String sql="Select* from Vendas";
        PreparedStatement stmt=null;
        ResultSet rs=null;
        List<Venda> vendas=new ArrayList();
        
        try{
            stmt=con.prepareStatement(sql);
            rs=stmt.executeQuery();
            while(rs.next()){
            Venda v=new Venda();
            
            v.setQuantidade(Integer.parseInt(rs.getString("quantidade")));
            v.setPrecoTotal(BigDecimal.valueOf(Double.parseDouble(rs.getString("PrecoTotal"))));
            v.setIva(BigDecimal.valueOf(Double.parseDouble(rs.getString("Iva"))));
            v.setDesconta(Integer.parseInt(rs.getString("PrecoTotal")));
            v.setCodCliente(Integer.parseInt(rs.getNString("CodCliente")));
             
         
            vendas.add(v);
            }
            stmt.close();
            rs.close();
            
        
        
        }catch(SQLException ex){Logger.getLogger(BDconexao.class.getName()).log(Level.SEVERE,null,ex);}
        return vendas;
       
    }

    @Override
    public List listarPorID(Integer i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public Venda BuscaFornecedor(Venda v){
       conex.executaSql("Select *from venda where nome like'%"+v.getPesquisa()+"%'");
        try {
            conex.rs.first();
              v.setQuantidade(Integer.parseInt(conex.rs.getString("quantidade")));
            v.setPrecoTotal(BigDecimal.valueOf(Double.parseDouble(conex.rs.getString("PrecoTotal"))));
            v.setIva(BigDecimal.valueOf(Double.parseDouble(conex.rs.getString("PrecoTotal"))));
            v.setDesconta(Integer.parseInt(conex.rs.getString("PrecoTotal")));
            v.setCodCliente(Integer.parseInt(conex.rs.getNString("CodCliente")));
             
        } catch (SQLException ex) {
               JOptionPane.showMessageDialog(null,"Fornecedor Não cadastrado");
        }
     
       return v;
    }
    
    
    
    
}
