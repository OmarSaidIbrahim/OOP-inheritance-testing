/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coursework3_omar;

import java.util.ArrayList;

/**
 *
 * @author omar
 */
public interface Data {
    //interface of the class Info

    public void addData(Info a);
    
    public boolean checkDataId(int id);
    
    public void printData();
    
    public int dataIndexInArray(int id);
    
    public void editDataById(int dataid, String newcontent);
    
    public void deleteDataById(int dataid);
    
    public ArrayList<Info> getDataArray();
    
    public String getDataInfo();
    
    public int getId();
    
    public Info getData(int id);
}
