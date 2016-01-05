/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Bean.Cliente;
import DAO.ClienteDAO;
import java.util.List;
import javax.swing.JComboBox;


/**
 *
 * @author jonatas
 */
public class ClienteController {
    
    private ClienteDAO clienteDAO;
    
    public ClienteController(){
        this.clienteDAO = new ClienteDAO();
    }
    
    public Boolean inserir(Cliente cliente){
        
       return this.clienteDAO.inserir(cliente);
        
    }
    
    public void alterar(Cliente cliente){
        
        this.clienteDAO.alterar(cliente);
    }
    
    public List<Cliente> listar() {
        
      List<Cliente> lista = this.clienteDAO.listar();
       
      return lista;
    }
     
    public List<Cliente> listar(JComboBox clientes) {
        
      List<Cliente> lista = this.clienteDAO.listar(clientes);
       
      return lista;
    }
    
    public void deletar(int id){
        
        this.clienteDAO.deletar(id);
        
    }
    public int buscarUltimoId(){
        return this.clienteDAO.buscarUltimoId();
    }
            
    public Cliente buscarUm(int id){
        
        Cliente cliente = new Cliente();
        
        cliente = clienteDAO.buscarCliente(id);
        
        return cliente;
        
    }
        
    
}

