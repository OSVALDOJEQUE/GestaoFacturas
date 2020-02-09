/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Dao;

import Model.Entidade.Recibo;
import Model.Entidade.Venda;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Date;
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
public class ReciboDAO  implements DaoInterface<Recibo, Integer>{
    

    private Connection con;
    
    BDconexao conex;
    
    public ReciboDAO(){
      con=BDconexao.getconnection();
 
    }

    @Override
    public Recibo inserir(Recibo r) {
        String sql="insert into Recibo(DataEmissao, Valor) values(?,?)";
        PreparedStatement stmt=null;
        
        try {
            stmt=con.prepareStatement(sql);
            
            stmt.setDate(1, (Date) r.getDataEmissao());
            stmt.setBigDecimal(2,r.getValor());
          
            stmt.execute(sql);
            stmt.close();
            JOptionPane.showMessageDialog(null, "Venda Efectuada com sucesso");
        } catch (SQLException ex) {
            Logger.getLogger(VendaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       return r;    
    }

    @Override
    public void update(Recibo r) {
      String sql="Update recibp set DataEmissao=? Valor=? where codRecibo=?";
      
      PreparedStatement stmt=null;
      
        try {
            stmt=con.prepareStatement(sql);
            stmt.setDate(1, (Date) r.getDataEmissao());
            stmt.setBigDecimal(2,r.getValor());
            stmt.setInt(3, r.getCodRecibo());
            
            stmt.execute();
            stmt.close();
            JOptionPane.showMessageDialog(null, "Actualizado com sucesso");
            
        } catch (SQLException ex) {
            Logger.getLogger(VendaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }         
    }

    @Override
    public void delete(Recibo r) {
          String sql="delete from recibo where codVenda=?";
        
        PreparedStatement stmt=null;
      try {
          stmt=con.prepareStatement(sql);
          stmt.setInt(1,r.getCodRecibo());
          
          stmt.execute(); 
          stmt.close();
          
      } catch (SQLException ex) {
          Logger.getLogger(ArtigoDAO.class.getName()).log(Level.SEVERE, null, ex);
      }
    
    }

    @Override
    public List<Recibo> listar() {
        
        String sql="Select* from Recibo";
        PreparedStatement stmt=null;
        ResultSet rs=null;
        List<Recibo> recibos=new ArrayList();
        
        try{
            stmt=con.prepareStatement(sql);
            rs=stmt.executeQuery();
            while(rs.next()){
            Recibo r=new Recibo();
            
            r.setDataEmissao((Date.valueOf(rs.getString("DataEmissao"))));
            r.setValor(BigDecimal.valueOf(Double.parseDouble(rs.getString("Valor"))));
            r.setCodRecibo(Integer.parseInt(rs.getNString("CodRecibo")));
             
         
            recibos.add(r);
            }
            stmt.close();
            rs.close();
            
        
        
        }catch(SQLException ex){Logger.getLogger(BDconexao.class.getName()).log(Level.SEVERE,null,ex);}
        return recibos;
       
    }

    @Override
    public List listarPorID(Integer i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
  public Recibo BuscaFornecedor(Recibo r){
       conex.executaSql("Select *from Recibo  where nome like'%"+r.getPesquisa()+"%'");
        try {
            conex.rs.first();
              r.setDataEmissao(Date.valueOf(conex.rs.getString("DataEmissao")));
              r.setValor(BigDecimal.valueOf(Double.parseDouble(conex.rs.getString("desconto"))));
            
             
        } catch (SQLException ex) {
               JOptionPane.showMessageDialog(null,"Recio Não Encontrado");
        }
     
       return r;
    }
    


}
