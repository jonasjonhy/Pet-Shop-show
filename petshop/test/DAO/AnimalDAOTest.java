/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Bean.Animal;
import Bean.Cliente;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author kely
 */
public class AnimalDAOTest {
    
    public AnimalDAOTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of inserir method, of class AnimalDAO.
     */
    @Test
    public void testInserir() {
        System.out.println("inserir");
        Animal animal = new Animal();
        animal.setIdDono(7);
        animal.setEspecie("Gato");
        animal.setIdade(8);
        animal.setNome("Maria do bairro");
        animal.setRaca("Angorá");
        animal.setSexo("F");
        AnimalDAO instance = new AnimalDAO();
        boolean expResult = true;
        boolean result = instance.inserir(animal);
        assertEquals(expResult, result);
    }


    /**
     * Test of alterar method, of class AnimalDAO.
     */
   @Test
    public void testAlterar() {
        System.out.println("alterar");
        Animal animal = new Animal();
        animal.setIdDono(6);
        animal.setEspecie("Gato");
        animal.setIdade(8);
        animal.setNome("Maria do bairro");
        animal.setRaca("Angorá");
        animal.setSexo("F");
        AnimalDAO instance = new AnimalDAO();
        boolean expResult = true;
        boolean result = instance.alterar(animal);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of listar method, of class AnimalDAO.
     */
    @Test
    public void testListar() {
        System.out.println("listar");
        int idDono = 0;
        AnimalDAO instance = new AnimalDAO();
        List<Animal> expResult = null;
        List<Animal> result = instance.listar(idDono);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of buscarODono method, of class AnimalDAO.
     */
    @Test
    public void testBuscarODono() {
        System.out.println("buscarODono");
        int idAnimal = 6;
        AnimalDAO instance = new AnimalDAO();
        Cliente expResult = null;
        Cliente result = instance.buscarODono(idAnimal);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of buscarUm animal method, of class AnimalDAO.
     */
    @Test
    public void testBuscarUm() {
        System.out.println("buscarUm");
        int id = 13;
        AnimalDAO instance = new AnimalDAO();
        Animal expResult = null;
        Animal result = instance.buscarUm(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deletar method, of class AnimalDAO.
     */
    @Test
    public void testDeletar() {
        System.out.println("deletar");
        int id = 12;
        AnimalDAO instance = new AnimalDAO();
        boolean expResult = true;
        boolean result = instance.deletar(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of detelarTodos os animais de um unico dono method, of class AnimalDAO.
     */
    @Test
    public void testDetelarTodos() {
        System.out.println("detelarTodos");
        int idDono = 6;
        AnimalDAO instance = new AnimalDAO();
        boolean expResult = true;
        boolean result = instance.detelarTodos(idDono);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of listarTodos method, of class AnimalDAO.
     */
    @Test
    public void testListarTodos() {
        System.out.println("listarTodos");
        AnimalDAO instance = new AnimalDAO();
        List<Animal> expResult = null;
        List<Animal> result = instance.listarTodos();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
