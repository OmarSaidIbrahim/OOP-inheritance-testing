package coursework3_omar;

import java.util.ArrayList;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author omar
 */
public class Person implements User{
    
    //user details
    private String email;
    private String password;
    private String name;
    private int id;
    private String role;
    private String accessibility;
    //array of users
    ArrayList<Person> users = null;
    
    //first constructor to initiate the array of users
    public Person(){
        users = new ArrayList<>();
    }
    //second user to create a Person object
    public Person(String email, String password, String name, int id, String role){
        this.email = email;
        this.password = password;
        this.name=name;
        this.id=id;
        this.role=role;
        switch(role){//the role of the user will determine his permitted actions
            case "Client"://if the user is a client, he will only be able to share and print the data
                this.accessibility = "Share data\nPrint data";
                break;
            case "External"://if the user is external, he can only print the data
                this.accessibility = "Print data";
                break;
            case "HnKEmployee"://if the user is an hnk employee, he will be able to share, print, edit, insert and delete data
                this.accessibility = "Share data\nPrint data\nEdit data by ID\nInsert new data\nDelete data by ID.";
                break;
        }
    }
    
    //the below method returns the whole array of users
    @Override
    public ArrayList<Person> getArrayUsers(){
        return this.users;
    }
    
    //the below method returns the id of a Person
    @Override
    public int getId(){
        return this.id;
    }
    //the below method returns the role of a Person
    @Override
    public String getRole(){
        return this.role;
    }
    //the below method returns the MOST IMPORTANT details of a Person
    @Override
    public String getInfo(){
        return "ID: "+this.id+"\nName: "+this.name+"\nEmail: "+this.email;
    }
    //the below method returns the GENERAL details of a Person
    @Override
    public String getUserInfo(){
        return this.email+"-"+this.password+"-"+this.name+"-"+this.id+"-"+this.role+"-"+this.accessibility.replace("\n", ".");
    }
    
    //Not to be overrided and included in UserInterface because this is a method from the subclasses.
    //the method returns the details of the Person plus other variables from other types of User such as External
    public String getInfoUser(){return null;}
    
    //the below method returns the action permitted of a Person
    @Override
    public String getAccessibilities(){
        return this.accessibility;
    }
    //the below method add a new user to the array of users
    @Override
    public void addUser(Person a){
        if(this.checkId(a.id) == true)//if the user id DOES NOT exists in the array
        {
            this.users.add(a);//add to the array
        }
    }
    
    //the below method returns false if the id in the parameter exists in the array, true if it does not exist
    @Override
    //OCL
    public boolean checkId(int id){ //false if id exists, true if it not exists
        boolean found = false;
        
        if(this.users.isEmpty()) 
            found = true;
        else 
        {
            for(int i=0;i<this.users.size();i++)
            {
                if(this.users.get(i).id == id)
                {
                    found = false;
                    break;
                }
                else
                    found = true;
            }
        }
        return found;
    }
    
    //the below method prints the details of all the users in the arraylist
    @Override
    public void printUsers(){
        this.users.forEach(a -> {
            System.out.println(a.getInfo());
        });
    }
    //the below method searches and returns the Person with the same id as the one in the parameter
    @Override
    public Person getUser(int id){
        Person a = null;
        for(int i=0;i<this.users.size();i++)
        {
            if(this.users.get(i).id == id)
            {
                a = this.users.get(i);
                break;
            }
        }
        return a;
    }
    //the below method checks if the action inserted by the user in the main class is permitted
    @Override
    //Refactoring
    public boolean actionPermission(String action) {
        boolean actionFound = false;
        //the actions permitted are splitted into an array and then checked one by one with the action inserted by the user.
        String[] actions = this.accessibility.split("\n");
        for(String a:actions)
            if(a.contains(action))
            {
                actionFound = true;// if it has been found, it will return true
                break;
            }
        
        return actionFound;//else false, mening it is not permitted or does not exist.
        
    }
    
}
