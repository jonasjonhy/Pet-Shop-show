/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Bean.TipoServico;
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
public class TipoServicoDAOTest {
    
    public TipoServicoDAOTest() {
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
     * Test of inserir method, of class TipoServicoDAO.
     */
    @Test
    public void testInserir() {
        System.out.println("inserir");
        TipoServico servico = new TipoServico();
        servico.setNome("Cirurgia");
        servico.setValor(200);
        TipoServicoDAO instance = new TipoServicoDAO();
        boolean expResult = true;
        boolean result = instance.inserir(servico);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of alterar method, of class TipoServicoDAO.
     */
    @Test
    public void testAlterar() {
        System.out.println("alterar");
        TipoServico servico = new TipoServico();
        servico.setNome("Cirurgia");
        servico.setValor(200);
        TipoServicoDAO instance = new TipoServicoDAO();
        boolean expResult = true;
        boolean result = instance.alterar(servico);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of listar method, of class TipoServicoDAO.
     */
    @Test
    public void testListar() {
        System.out.println("listar");
        TipoServicoDAO instance = new TipoServicoDAO();
        List<TipoServico> expResult = null;
        List<TipoServico> result = instance.listar();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deletar method, of class TipoServicoDAO.
     */
    @Test
    public void testDeletar() {
        System.out.println("deletar");
        int id = 2;
        TipoServicoDAO instance = new TipoServicoDAO();
        boolean expResult = true;
        boolean result = instance.deletar(id);
        assertEquals(expResult, result);
       
    }
    
}
