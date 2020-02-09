/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Dao;

import Model.Entidade.Factura;
import Model.Entidade.Venda;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.apache.commons.beanutils.converters.SqlDateConverter;

/**
 *
 * @author JEQUE
 */
public class FacturaDAO implements DaoInterface<Factura, Integer> {
    
     private Connection con;
    
    BDconexao conex;
    
    public FacturaDAO(){
      con=BDconexao.getconnection();
 
    }

    @Override
    public Factura inserir(Factura f) {
        String sql="insert into factura(DataEmissao,DataValida,quantidade,Desconto,CodVenda) values(?,?,?,?,?)";
        PreparedStatement stmt=null;
        
        try {
            stmt=con.prepareStatement(sql);
            
            
            stmt.setDate(1, (Date) f.getDataEmissao());
            stmt.setDate(2,(Date) f.getDataValidade());
            stmt.setInt(3, f.getQuantidade());
            stmt.setBigDecimal(4,f.getDesconto());
            stmt.setInt(5, f.getCodVenda().getCodVenda());
            
            stmt.execute(sql);
            stmt.close();
            JOptionPane.showMessageDialog(null, "Venda Efectuada com sucesso");
        } catch (SQLException ex) {
            Logger.getLogger(VendaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       return f;    
    }

    @Override
    public void update(Factura f) {
      String sql="Update Factura set dataEmissao=? DataValidade=? Quantidade=? Desconto=? CodVenda=? where codFactura=?";
      
      PreparedStatement stmt=null;
      
        try {
            stmt=con.prepareStatement(sql);
           stmt.setDate(1, (Date) f.getDataEmissao());
            stmt.setDate(2,(Date) f.getDataValidade());
            stmt.setInt(3, f.getQuantidade());
            stmt.setBigDecimal(4,f.getDesconto());
            stmt.setInt(5, f.getCodVenda().getCodVenda());
            
            stmt.execute();
            stmt.close();
            JOptionPane.showMessageDialog(null, "Actualizado com sucesso");
            
        } catch (SQLException ex) {
            Logger.getLogger(VendaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }         
    }

    @Override
    public void delete(Factura f) {
          String sql="delete from venda where codVenda=?";
        
        PreparedStatement stmt=null;
      try {
          stmt=con.prepareStatement(sql);
          stmt.setInt(1,f.getCodFactura());
          
          stmt.execute(); 
          stmt.close();
          
      } catch (SQLException ex) {
          Logger.getLogger(ArtigoDAO.class.getName()).log(Level.SEVERE, null, ex);
      }
    
    }

    @Override
    public List<Factura> listar() {
        
        String sql="Select* from Factura";
        PreparedStatement stmt=null;
        ResultSet rs=null;
        List<Factura> facturas=new ArrayList();
        
        try{
            stmt=con.prepareStatement(sql);
            rs=stmt.executeQuery();
            while(rs.next()){
            Factura f=new Factura();
            
            f.setDataEmissao((SQLData)(rs.getString("DataEmissao")));
             f.setDataEmissao(()rs.getString("DataValidade"));
             f.setQuantidade(Integer.parseInt(rs.getString("Quantidade")));
             f.setDesconto(BigDecimal.valueOf(Double.parseDouble(rs.getString("Desconto"))));
             f.setCodVenda((Venda)(Object)Integer.parseInt(rs.getString("CodVenda")));
         
             
         
            facturas.add(f);
            }
            stmt.close();
            rs.close();
            
        
        
        }catch(SQLException ex){Logger.getLogger(BDconexao.class.getName()).log(Level.SEVERE,null,ex);}
        return facturas;
       
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
