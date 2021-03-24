/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coursework3_omar;

/**
 *
 * @author omar
 */
public class External extends Person {
    //the External class has only the constructor
    
    private String organisation;
    
    public External(String email, String password, String name, int id, String organisation){
        super(email, password, name, id, "External");
        this.organisation = organisation;
    }
    //and a method to retrieve the user's details.
    @Override
    public String getInfoUser(){
        return super.getUserInfo()+"-"+this.organisation;
    }

}
