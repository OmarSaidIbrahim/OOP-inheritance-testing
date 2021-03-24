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
public class InfoTest {
    
    /**
     * Test of addData method, of class Info.
     */
    @Test
    public void testAddData() {
        System.out.println("addData");
        Info a = new Info(3,"a",3);
        Info instance = new Info();
        instance.addData(a);
    }

    /**
     * Test of checkDataId method, of class Info.
     */
    @Test
    public void testCheckDataId() {
        System.out.println("checkDataId");
        int id = 0;
        Info instance = new Info();
        boolean expResult = false;
        boolean result = instance.checkDataId(id);
        assertEquals(expResult, result);
    }

    /**
     * Test of getId method, of class Info.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        Info instance = new Info();
        int expResult = 0;
        int result = instance.getId();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of getData method, of class Info.
     */
    @Test
    public void testGetData() {
        System.out.println("getData");
        int id = 0;
        Info instance = new Info();
        instance.addData(new Info(1,"a",1));
        Info expResult = instance.database.get(id);
        Info result = instance.getData(id);
        assertEquals(expResult, result);
    }

    /**
     * Test of printData method, of class Info.
     */
    @Test
    public void testPrintData() {
        System.out.println("printData");
        Info instance = new Info();
        instance.printData();
        
    }

    /**
     * Test of dataIndexInArray method, of class Info.
     */
    @Test
    public void testDataIndexInArray() {
        System.out.println("dataIndexInArray");
        int id = 0;
        Info instance = new Info();
        int expResult = 0;
        int result = instance.dataIndexInArray(id);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of editDataById method, of class Info.
     */
    @Test
    public void testEditDataById() {
        System.out.println("editDataById");
        int dataid = 1;
        String newcontent = "test";
        Info instance = new Info();
        instance.addData(new Info(1,"a",1));
        instance.editDataById(dataid, newcontent);
        
    }

    /**
     * Test of deleteDataById method, of class Info.
     */
    @Test
    public void testDeleteDataById() {
        System.out.println("deleteDataById");
        int dataid = 3;
        Info instance = new Info();
        Info test = new Info(3,"a",3);
        instance.addData(test);
        instance.deleteDataById(dataid);
    }

    /**
     * Test of getDataArray method, of class Info.
     */
    @Test
    public void testGetDataArray() {
        System.out.println("getDataArray");
        Info instance = new Info();
        ArrayList<Info> expResult = new ArrayList<>();
        ArrayList<Info> result = instance.getDataArray();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDataInfo method, of class Info.
     */
    @Test
    public void testGetDataInfo() {
        System.out.println("getDataInfo");
        Info instance = new Info(1,"a",1);
        String expResult = "1-a-1";
        String result = instance.getDataInfo();
        assertEquals(expResult, result);
    }
    
}
