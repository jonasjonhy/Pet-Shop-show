/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Bean.Servico;
import DAO.ServicoDAO;
import java.util.List;

/**
 *
 * @author jonatas
 */
public class ServicoController {
    
    
    private ServicoDAO servico;
    
    public ServicoController(){
        
        this.servico = new ServicoDAO();
    }
    
    public void inserir(Servico servico){
        
        this.servico.inserir(servico);
    }
    
    public void alterar(Servico servico){
        
        this.servico.alterar(servico);
    }
    
    public List<Servico> listar(){
        
        List<Servico> lista = this.servico.listar();
        
        return lista;
    }
    public Servico listarUm(int idServico){
        
        Servico servico = this.servico.listarUm(idServico);
        
        return servico;
    }
    
    
    public void deletar(int id){
        
        this.servico.deletar(id);
    }

    public void finalizarServico(int id) {
        
        
        this.servico.finalizarServico(id);
        
        
    }
    
    public boolean verificaFinalizacao(int id){
        
      return this.servico.verificaFinalizacao(id);
    }
}
