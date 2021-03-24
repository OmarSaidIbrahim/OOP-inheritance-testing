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
public interface User {
    //Interface of the class Person
    
    public boolean checkId(int id);
    
    public void addUser(Person a);
    
    public void printUsers();
    
    public Person getUser(int id);
    
    public boolean actionPermission(String action);
    
    public int getId();
    
    public String getRole();
    
    public String getInfo();
    
    public String getAccessibilities();
    
    public String getUserInfo();
    
    public ArrayList<Person> getArrayUsers();
}
