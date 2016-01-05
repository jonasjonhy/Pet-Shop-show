/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Bean.Servico;
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
public class ServicoDAOTest {
    
    public ServicoDAOTest() {
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
     * Test of inserir method, of class ServicoDAO.
     */
    @Test
    public void testInserir() {
        System.out.println("inserir");
        Servico servico = new Servico();
        servico.setCusto(100);
        servico.setData("25/06/2015");
        servico.setFinalizado(true);
        servico.setHorario("12 horas");
        servico.setId_animal(6);
        servico.setId_tipoServico(2);
        ServicoDAO instance = new ServicoDAO();
        boolean expResult = true;
        boolean result = instance.inserir(servico);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of alterar method, of class ServicoDAO.
     */
    @Test
    public void testAlterar() {
        System.out.println("alterar");
        Servico servico = new Servico();
        servico.setCusto(100);
        servico.setData("25/06/2015");
        servico.setFinalizado(true);
        servico.setHorario("12 horas");
        servico.setId_animal(6);
        servico.setId_tipoServico(2);
        ServicoDAO instance = new ServicoDAO();
        boolean expResult = true;
        boolean result = instance.alterar(servico);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of listar method, of class ServicoDAO.
     */
    @Test
    public void testListar() {
        System.out.println("listar");
        ServicoDAO instance = new ServicoDAO();
        List<Servico> expResult = null;
        List<Servico> result = instance.listar();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of listarUm method, of class ServicoDAO.
     */
    @Test
    public void testListarUm() {
        System.out.println("listarUm");
        int idServico = 0;
        ServicoDAO instance = new ServicoDAO();
        Servico expResult = null;
        Servico result = instance.listarUm(idServico);
        assertEquals(expResult, result);
    }

    /**
     * Test of deletar method, of class ServicoDAO.
     */
    @Test
    public void testDeletar() {
        System.out.println("deletar");
        int id = 0;
        ServicoDAO instance = new ServicoDAO();
        boolean expResult = true;
        boolean result = instance.deletar(id);
        assertEquals(expResult, result);
    }
    
}
