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
public class Info implements Data{
    
    //the Info class represents the data management
    
    private int id;//every data is identified with an id
    private String content;//a content
    private int userId;//and the user that insert the data
    //the class also contains an array of data
    ArrayList<Info> database = null;
    
    public Info(){
        database = new ArrayList<>();
    }
    
    public Info(int id,String content,int user){
        this.id=id;
        this.content=content;
        this.userId=user;
    }
    //the info class is very similar to the Person class.
    //the id will be checked to be sure there is no id equal to the one to be inserted in the array
    @Override
    public void addData(Info a){
        if(this.checkDataId(a.id))
            this.database.add(a);
        else
            System.out.println("Error. Id exists already.\n");
    }
    
    @Override
    //OCL
    //the fucntion below return false if the id is present in the array already, true otherwise
    public boolean checkDataId(int id){
        boolean found = false;
        if(this.database.isEmpty()) 
            found = true;
        else 
        {
            for(int i=0;i<this.database.size();i++)
            {
                if(this.database.get(i).id == id)
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
    //returns the id
    @Override
    public int getId(){return this.id;}
    //returns a particular info object from the array of data
    @Override
    public Info getData(int id){
        return this.database.get(id);
    }
    
    //the method below displays all the data present in the array (database)
    @Override
    public void printData(){
        if(!this.database.isEmpty())
        {
            this.database.forEach(a -> {
                System.out.println("\nData ID: "+a.id+"\nData content: "+a.content+"\nUser ID: "+a.userId);
            });
        }
        else
            System.out.println("\nNo data to be displayed.");
    }
    
    // the function below returns the position of a data in the array
    @Override
    public int dataIndexInArray(int id){
        int index = 0;
        for(Info a:this.database){
            if(a.id == id)
                break;
            index++;
        }
        return index;
    }
    //the method below edits the content of the data with the id selected.
    @Override
    public void editDataById(int dataid, String newcontent){
        if(checkDataId(dataid))
        {
            this.database.get(dataIndexInArray(id)).content = newcontent;
            System.out.println("Changes have been made");
        }
        else
            System.out.println("Id does not exist. Try again.");
    }
    //the same method below first looks for the data to be deleted with the id, then invoke the method 'remove'
    @Override
    public void deleteDataById(int dataid){
        if(checkDataId(dataid))
        {
            this.database.remove(dataIndexInArray(id));
            System.out.println("Data deleted.");
        }
        else
            System.out.println("Id does not exist.");
    }
    //the function below returns the whole array of data
    @Override
    public ArrayList<Info> getDataArray(){
        return this.database;
    }
    //the function below returns the info of the data
    @Override
    public String getDataInfo(){
        return this.id+"-"+this.content+"-"+this.userId;
    }
    
}
