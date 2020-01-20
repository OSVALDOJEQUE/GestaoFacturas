/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Dao;
import java.util.List;
/**
 *
 * @author JEQUE
 */
public interface DaoInterface<F,I> {
    
    
    public F inserir(F f);
    public void update(F f);
    public void delete(F f);
    public List<F> listar();
    public List listarPorID(I i);
    
 



    
}
