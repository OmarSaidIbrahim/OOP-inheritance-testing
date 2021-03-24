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
public class Client extends Person {
    //the External class has only the constructor
    private String address;

    public Client(String email, String password, String name, int id,String address){
        super(email, password, name, id, "Client");
        this.address=address;
    }
    //and a method to retrieve the user's details.
    @Override
    public String getInfoUser(){
        return super.getUserInfo()+"-"+this.address;
    }
}
