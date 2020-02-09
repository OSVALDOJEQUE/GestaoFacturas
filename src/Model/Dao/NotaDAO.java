/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Dao;

import Model.Entidade.Factura;
import Model.Entidade.Nota;
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
public class NotaDAO implements DaoInterface<Nota, Integer> {
    
     private Connection con;
    
    BDconexao conex;
    
    public NotaDAO(){
      con=BDconexao.getconnection();
 
    }

    @Override
    public Nota inserir(Nota n) {
        String sql="insert into nota(DataEmissao, Tipo,Valor, Descr, Iva, CodFactura) values(?,?,?,?,?,?)";
        PreparedStatement stmt=null;
        
        try {
            stmt=con.prepareStatement(sql);
            
            stmt.setDate(1, (Date) n.getDataEmissao());
            stmt.setString(2,n.getTipo());
            stmt.setBigDecimal(3, n.getValor());
            stmt.setString(4,n.getDescr());
             stmt.setBigDecimal(5, n.getValor());
            stmt.setInt(6, n.getCodFactura());
            
            stmt.execute(sql);
            stmt.close();
            JOptionPane.showMessageDialog(null, "Nota Efectuada com sucesso");
        } catch (SQLException ex) {
            Logger.getLogger(VendaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       return n;    
    }

    @Override
    public void update(Nota n) {
      String sql="Update Nota set dataEmissao=? Tipo=? Valor=? Descr=? Iva=? codFactura=? where codNota=?";
      
      PreparedStatement stmt=null;
      
        try {
            stmt=con.prepareStatement(sql);
            stmt.setDate(1, (Date) n.getDataEmissao());
            stmt.setString(2,n.getTipo());
            stmt.setBigDecimal(3, n.getValor());
            stmt.setString(4,n.getDescr());
             stmt.setBigDecimal(5, n.getValor());
            stmt.setInt(6, n.getCodFactura());
            stmt.setInt(7,n.getCodNota());
            
            stmt.execute();
            stmt.close();
            JOptionPane.showMessageDialog(null, " Nota Actualizado com sucesso");
            
        } catch (SQLException ex) {
            Logger.getLogger(VendaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }         
    }

    @Override
    public void delete(Nota n) {
          String sql="delete from Nota where codNota=?";
        
        PreparedStatement stmt=null;
      try {
          stmt=con.prepareStatement(sql);
          stmt.setInt(1,n.getCodNota());
          
          stmt.execute(); 
          stmt.close();
          
      } catch (SQLException ex) {
          Logger.getLogger(ArtigoDAO.class.getName()).log(Level.SEVERE, null, ex);
      }
    
    }

    @Override
    public List<Nota> listar() {
        
        String sql="Select* from Nota";
        PreparedStatement stmt=null;
        ResultSet rs=null;
        List<Nota> notas=new ArrayList();
        
        try{
            stmt=con.prepareStatement(sql);
            rs=stmt.executeQuery();
            while(rs.next()){
            Nota n=new Nota();
            
            n.setDataEmissao(Date.valueOf(rs.getString("DataEmissao")));
             n.setTipo(rs.getString("Tipo"));
             n.setValor(BigDecimal.valueOf(Double.parseDouble(rs.getString("Valor"))));
             n.setDescr(rs.getString("Descr"));
             n.setIva(BigDecimal.valueOf(Double.parseDouble(rs.getString("Iva"))));
             n.setCodFactura(Integer.parseInt(rs.getString("CodFactura")));
         
             
         
            notas.add(n);
            }
            stmt.close();
            rs.close();
            
        
        
        }catch(SQLException ex){Logger.getLogger(BDconexao.class.getName()).log(Level.SEVERE,null,ex);}
        return notas;
       
    }

    @Override
    public List listarPorID(Integer i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public Nota BuscaFornecedor(Nota n){
       conex.executaSql("Select *from venda where nome like'%"+n.getPesquisa()+"%'");
        try {
            conex.rs.first();
                    n.setDataEmissao(Date.valueOf(conex.rs.getString("DataEmissao")));
             n.setTipo(conex.rs.getString("Tipo"));
             n.setValor(BigDecimal.valueOf(Double.parseDouble(conex.rs.getString("Valor"))));
             n.setDescr(conex.rs.getString("Descr"));
             n.setIva(BigDecimal.valueOf(Double.parseDouble(conex.rs.getString("Iva"))));
             n.setCodFactura(Integer.parseInt(conex.rs.getString("CodFactura")));
             
        } catch (SQLException ex) {
               JOptionPane.showMessageDialog(null,"Nota Não Encontrada");
        }
     
       return n;
    }
    
    
    
    
    
    
    
    
    
}
