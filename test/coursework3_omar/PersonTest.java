/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coursework3_omar;

import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author omar
 */
public class PersonTest {
    
    /**
     * Test of getArrayUsers method, of class Person.
     */
    @Test
    public void testGetArrayUsers() {
        System.out.println("getArrayUsers");
        Person instance = new Person();
        ArrayList<Person> expResult = new ArrayList<>();
        ArrayList<Person> result = instance.getArrayUsers();
        assertEquals(expResult, result);
    }

    /**
     * Test of getId method, of class Person.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        Person instance = new Person();
        int expResult = 0;
        int result = instance.getId();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of getRole method, of class Person.
     */
    @Test
    public void testGetRole() {
        System.out.println("getRole");
        Person instance = new Person("a","a","a",3,"External");
        String expResult = "External";
        String result = instance.getRole();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of getInfo method, of class Person.
     */
    @Test
    public void testGetInfo() {
        System.out.println("getInfo");
        Person instance = new Person("a","a","a",3,"External");
        String expResult = "ID: "+3+"\nName: "+"a"+"\nEmail: "+"a";
        String result = instance.getInfo();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of getUserInfo method, of class Person.
     */
    @Test
    public void testGetUserInfo() {
        System.out.println("getUserInfo");
        Person instance = new Person("a","a","a",3,"External");
        String expResult = "a"+"-"+"a"+"-"+"a"+"-"+3+"-"+"External"+"-"+"Print data";
        String result = instance.getUserInfo();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of getInfoUser method, of class Person.
     */
    @Test
    public void testGetInfoUser() {
        System.out.println("getInfoUser");
        Person instance = new Person();
        String expResult = null;
        String result = instance.getInfoUser();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of getAccessibilities method, of class Person.
     */
    @Test
    public void testGetAccessibilities() {
        System.out.println("getAccessibilities");
        Person instance = new Person("a","a","a",3,"External");
        String expResult = "Print data";
        String result = instance.getAccessibilities();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of addUser method, of class Person.
     */
    @Test
    public void testAddUser() {
        System.out.println("addUser");
        Person a = new Person();
        Person instance = new Person("a","a","a",3,"External");
        a.addUser(instance);
    }

    /**
     * Test of checkId method, of class Person.
     */
    @Test
    public void testCheckId() {
        System.out.println("checkId");
        int id = 0;
        Person instance = new Person();
        boolean expResult = true;//true if not found, false if found the same id (array is empty)
        boolean result = instance.checkId(id);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of printUsers method, of class Person.
     */
    @Test
    public void testPrintUsers() {
        System.out.println("printUsers");
        Person instance = new Person();
        instance.printUsers();
        
    }

    /**
     * Test of getUser method, of class Person.
     */
    @Test
    public void testGetUser() {
        System.out.println("getUser");
        int id = 0;
        Person instance = new Person();
        Person expResult = null;
        Person result = instance.getUser(id);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of actionPermission method, of class Person.
     */
    @Test
    public void testActionPermission() {
        System.out.println("actionPermission");
        String action = "";
        Person instance = new External("a","a","a",3,"a");
        //Person instance = new Client();
        //Person instance = new HnKEmployee();
        boolean expResult = false;
        boolean result = instance.actionPermission("Insert"); //Insert is not an action permitted by External
        assertEquals(expResult, result);
    }
    
}
