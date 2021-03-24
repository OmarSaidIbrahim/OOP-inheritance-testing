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
public class HnKEmployee extends Person {
    //HnKEmployee class has only the constructor

    private String skills;
    private String department;
    
    public HnKEmployee(String email, String password, String name, int id, String skills, String department){
        super(email, password, name, id, "HnKEmployee");
        this.skills = skills;
        this.department = department;
    }
    //and a method to retrieve the details of the user
    @Override
    public String getInfoUser(){
        return super.getUserInfo()+"-"+this.skills+"-"+this.department;
    }
}
