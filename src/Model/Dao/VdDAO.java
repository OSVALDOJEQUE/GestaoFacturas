/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Dao;

import Model.Entidade.Nota;
import Model.Entidade.Vd;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
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
public class VdDAO implements DaoInterface<Vd, Integer> {
        
     private Connection con;
    
    BDconexao conex;
    
    public VdDAO(){
      con=BDconexao.getconnection();
 
    }

    @Override
    public Vd inserir(Vd vd) {
        String sql="insert into Vd(quantidade, desconto, codVenda,dataEmissao) values(?,?,?,?)";
        PreparedStatement stmt=null;
        
        try {
            stmt=con.prepareStatement(sql);
            
          
            stmt.setInt(1,vd.getQuantidade());
            stmt.setBigDecimal(2, vd.getDesconto());
            stmt.setInt(3,vd.getCodVenda());
               stmt.setDate(4, (Date) vd.getDataEmissao());
           
            
            stmt.execute(sql);
            stmt.close();
            JOptionPane.showMessageDialog(null, "Vd Efectuada com sucesso");
        } catch (SQLException ex) {
            Logger.getLogger(VendaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       return vd;    
    }

    @Override
    public void update(Vd vd) {
      String sql="Update Nota set dataEmissao=? Tipo=? Valor=? Descr=? Iva=? codFactura=? where codNota=?";
      
      PreparedStatement stmt=null;
      
        try {
            stmt=con.prepareStatement(sql);
               stmt.setInt(1,vd.getQuantidade());
            stmt.setBigDecimal(2, vd.getDesconto());
            stmt.setInt(3,vd.getCodVenda());
               stmt.setDate(4, (Date) vd.getDataEmissao());
               stmt.setInt(5, vd.getCodVd());
            
            stmt.execute();
            stmt.close();
            JOptionPane.showMessageDialog(null, " Vd Actualizado com sucesso");
            
        } catch (SQLException ex) {
            Logger.getLogger(VendaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }         
    }

    @Override
    public void delete(Vd vd) {
          String sql="delete from Vd where codVd=?";
        
        PreparedStatement stmt=null;
      try {
          stmt=con.prepareStatement(sql);
          stmt.setInt(1,vd.getCodVd());
          
          stmt.execute(); 
          stmt.close();
          
      } catch (SQLException ex) {
          Logger.getLogger(ArtigoDAO.class.getName()).log(Level.SEVERE, null, ex);
      }
    
    }

    @Override
    public List<Vd> listar() {
        
        String sql="Select* from Vd";
        PreparedStatement stmt=null;
        ResultSet rs=null;
        List<Vd> vds=new ArrayList();
        
        try{
            stmt=con.prepareStatement(sql);
            rs=stmt.executeQuery();
            while(rs.next()){
            Vd vd=new Vd();
            vd.setQuantidade(Integer.parseInt(rs.getString("quantidade")));
            vd.setDesconto(BigDecimal.valueOf(Double.parseDouble(rs.getString("Desconto"))));
            vd.setCodVenda(Integer.parseInt(rs.getString("codVd")));
             vd.setDataEmissao(Date.valueOf(rs.getString("DataEmmissao")));
            
              
            vds.add(vd);
            }
            stmt.close();
            rs.close();
            
        
        
        }catch(SQLException ex){Logger.getLogger(BDconexao.class.getName()).log(Level.SEVERE,null,ex);}
        return vds;
       
    }

    @Override
    public List listarPorID(Integer i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public Vd BuscaFornecedor(Vd vd){
       conex.executaSql("Select *from Vd where nome like'%"+vd.getPesquisa()+"%'");
        try {
            conex.rs.first();
             
            vd.setQuantidade(Integer.parseInt(conex.rs.getString("quantidade")));
            vd.setDesconto(BigDecimal.valueOf(Double.parseDouble(conex.rs.getString("Desconto"))));
            vd.setCodVenda(Integer.parseInt(conex.rs.getString("codVd")));
             vd.setDataEmissao(Date.valueOf(conex.rs.getString("DataEmmissao")));
             
        } catch (SQLException ex) {
               JOptionPane.showMessageDialog(null,"vd Não Encontrada");
        }
     
       return vd;
    }
    
    
}
