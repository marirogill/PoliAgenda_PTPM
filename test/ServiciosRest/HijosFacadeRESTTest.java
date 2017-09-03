/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServiciosRest;

import PersistenceHijos.Hijos;
import java.util.List;
import javax.persistence.EntityManager;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author pablo
 */
public class HijosFacadeRESTTest {
    
    public HijosFacadeRESTTest() {
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
     * Test of create method, of class HijosFacadeREST.
     */
    @Test
    public void testCreate() {
        System.out.println("create");
        Hijos entity = null;
        HijosFacadeREST instance = new HijosFacadeREST();
        instance.create(entity);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of edit method, of class HijosFacadeREST.
     */
    @Test
    public void testEdit() {
        System.out.println("edit");
        Integer id = null;
        Hijos entity = null;
        HijosFacadeREST instance = new HijosFacadeREST();
        instance.edit(id, entity);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of remove method, of class HijosFacadeREST.
     */
    @Test
    public void testRemove() {
        System.out.println("remove");
        Integer id = null;
        HijosFacadeREST instance = new HijosFacadeREST();
        instance.remove(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of find method, of class HijosFacadeREST.
     */
    @Test
    public void testFind() {
        System.out.println("find");
        Integer id = null;
        HijosFacadeREST instance = new HijosFacadeREST();
        Hijos expResult = null;
        Hijos result = instance.find(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findAll method, of class HijosFacadeREST.
     */
    @Test
    public void testFindAll() {
        System.out.println("findAll");
        HijosFacadeREST instance = new HijosFacadeREST();
        List<Hijos> expResult = null;
        List<Hijos> result = instance.findAll();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findRange method, of class HijosFacadeREST.
     */
    @Test
    public void testFindRange() {
        System.out.println("findRange");
        Integer from = null;
        Integer to = null;
        HijosFacadeREST instance = new HijosFacadeREST();
        List<Hijos> expResult = null;
        List<Hijos> result = instance.findRange(from, to);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of countREST method, of class HijosFacadeREST.
     */
    @Test
    public void testCountREST() {
        System.out.println("countREST");
        HijosFacadeREST instance = new HijosFacadeREST();
        String expResult = "";
        String result = instance.countREST();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEntityManager method, of class HijosFacadeREST.
     */
    @Test
    public void testGetEntityManager() {
        System.out.println("getEntityManager");
        HijosFacadeREST instance = new HijosFacadeREST();
        EntityManager expResult = null;
        EntityManager result = instance.getEntityManager();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
