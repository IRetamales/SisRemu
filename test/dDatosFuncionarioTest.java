/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Sylar
 */
public class dDatosFuncionarioTest {
    
    public dDatosFuncionarioTest() {
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
     * Test of getAccion method, of class dDatosFuncionario.
     */
    @Test
    public void testGetAccion() {
        System.out.println("getAccion");
        dDatosFuncionario instance = null;
        Integer expResult = null;
        Integer result = instance.getAccion();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setAccion method, of class dDatosFuncionario.
     */
    @Test
    public void testSetAccion() {
        System.out.println("setAccion");
        Integer Accion = null;
        dDatosFuncionario instance = null;
        instance.setAccion(Accion);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setRut method, of class dDatosFuncionario.
     */
    @Test
    public void testSetRut() {
        System.out.println("setRut");
        String Rut = "";
        dDatosFuncionario instance = null;
        instance.setRut(Rut);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of main method, of class dDatosFuncionario.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        dDatosFuncionario.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
