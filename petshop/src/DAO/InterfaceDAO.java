/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.List;

/**
 *
 * @author jonatas
 */
public interface InterfaceDAO<T> {
    
    
    public boolean inserir(T objeto);
    
    public boolean alterar(T objeto);
    
//    public List<T> listar();
    
    public boolean deletar(int id);
    
}
