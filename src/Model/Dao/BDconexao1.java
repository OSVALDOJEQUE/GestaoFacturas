/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
/**
 *
 * @author JEQUE
 */
public class BDconexao1 {
    public Statement stm;
    public ResultSet rs;
    private static final String Driver="com.mysql.jdbc.Driver";
    private static final String URL="jdbc:mysql://localhost/gestao1";
    private static final String user="root";
    private static final String password="";
    public Connection con;
    

  
   public static Connection getconnection(){
     try{
      Class.forName(Driver);
      return DriverManager.getConnection(URL, user, password);
              
    }catch(ClassNotFoundException| SQLException ex){
    JOptionPane.showMessageDialog(null,"ERRO NA CONEXAO");
    System.exit(0);
    }
   return null;
   }
   
   public static void fecharConexao(Connection con)
  {
  try{
      if(con!=null)
       con.close();
  } catch(SQLException ex){
   Logger.getLogger(BDconexao.class.getName()).log(Level.SEVERE,null,ex);
  }
  
  }
    //Fechar conexao
  public void desconectar()
  {
  try{
       con.close();
  } catch(SQLException ex){
   Logger.getLogger(BDconexao.class.getName()).log(Level.SEVERE,null,ex);
  }
  
  }
  
  public  void executaSql(String sql){
      con=BDconexao.getconnection();
        try {
            
            stm=con.createStatement(rs.TYPE_SCROLL_INSENSITIVE,rs.CONCUR_READ_ONLY);
            rs=stm.executeQuery(sql);
      
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"ErroExecutaSql");
           
        }
  }
  
  
  
   //Fechar conexao e PreparedStatement 
 public static void fecharConexao(Connection con,PreparedStatement stmt){
 fecharConexao(con);
     try{
     if(stmt!=null)
         stmt.close();
     
     }catch(SQLException ex){
     Logger.getLogger(BDconexao.class.getName()).log(Level.SEVERE,null,ex);
     }
 
 
 }

//Fechar conexao e PreparedStatement e ResultSet
public static void fecharConexao(Connection con,PreparedStatement stmt, ResultSet rs){

fecharConexao(con,stmt);
try{
   if(rs!=null)
       rs.close();
}catch(SQLException ex){
JOptionPane.showMessageDialog(null,"erro");}

}



}
