/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Bean.Animal;
import Bean.Cliente;
import DAO.AnimalDAO;
import java.util.List;
import javax.swing.JComboBox;

/**
 *
 * @author jonatas
 */
public class AnimalController {
    
    private AnimalDAO animalDAO;
    
    public AnimalController(){
        this.animalDAO = new AnimalDAO();
    }
    
    public void inserir(Animal animal){
        
        this.animalDAO.inserir(animal);
        
    }
    
    public void alterar(Animal animal){
        
        this.animalDAO.alterar(animal);
    }
    
    public List<Animal> listar(int idDono) {
        
      List<Animal> lista = this.animalDAO.listar(idDono);
       
      return lista;
    }

    
    public Animal buscarUm(int id){
        Animal animal = animalDAO.buscarUm(id);
        return animal;
    }
    
    public boolean deletar(int id){
        
       return this.animalDAO.deletar(id);
        
    }
    public boolean deletarTodos(int idDono){
                
        return this.animalDAO.detelarTodos(idDono);
    }
    
    public List<Animal> listarTodos(){
        
       return this.animalDAO.listarTodos();
    }
    
    public Cliente buscarODono(int idAnimal){
        
       return this.animalDAO.buscarODono(idAnimal);
    }
    
}
