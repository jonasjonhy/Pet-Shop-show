/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Bean.Cliente;
import java.sql.ResultSet;
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
public class ClienteDAOTest {
    
    public ClienteDAOTest() {
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
     * Test of inserir method, of class ClienteDAO.
     */
    @Test
    public void testInserir() {
        System.out.println("inserir");
        Cliente cliente = new Cliente();
        cliente.setBairro("Jatobá");
        cliente.setCep("58.107-380");
        cliente.setNome("Fulano");
        cliente.setNumero(45);
        cliente.setRua("Rua da mata");
        cliente.setTelefone("9996-5584");
        ClienteDAO instance = new ClienteDAO();
        boolean expResult = true;
        boolean result = instance.inserir(cliente);
        assertEquals(expResult, result);
       
    }

    /**
     * Test of buscarUltimoId method, of class ClienteDAO.
     */
    @Test
    public void testBuscarUltimoId() {
        System.out.println("buscarUltimoId");
        ClienteDAO instance = new ClienteDAO();
        int expResult = 10;
        int result = instance.buscarUltimoId();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of alterar method, of class ClienteDAO.
     */
    @Test
    public void testAlterar() {
        System.out.println("alterar");
        Cliente cliente = new Cliente();
        cliente.setBairro("Jatobá");
        cliente.setCep("58.107-380");
        cliente.setNome("Fulano");
        cliente.setNumero(45);
        cliente.setRua("Boa vista");
        cliente.setTelefone("9996-5584");
        ClienteDAO instance = new ClienteDAO();
        boolean expResult = true;
        boolean result = instance.alterar(cliente);
        assertEquals(expResult, result);
    }

    /**
     * Test of listar method, of class ClienteDAO.
     */
    @Test
    public void testListar() {
        System.out.println("listar");
        ClienteDAO instance = new ClienteDAO();
        List<Cliente> expResult = null;
        List<Cliente> result = instance.listar();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of deletar method, of class ClienteDAO.
     */
    @Test
    public void testDeletar() {
        System.out.println("deletar");
        int id = 9;
        ClienteDAO instance = new ClienteDAO();
        boolean expResult = true;
        boolean result = instance.deletar(id);
        assertEquals(expResult, result);
       
    }

    /**
     * Test of buscarCliente method, of class ClienteDAO.
     */
    @Test
    public void testBuscarCliente() {
        System.out.println("buscarCliente");
        int id = 2;
        ClienteDAO instance = new ClienteDAO();
        Cliente expResult = null;
        Cliente result = instance.buscarCliente(id);
        assertEquals(expResult, result);
        
    }
    
}
