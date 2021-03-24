/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coursework3_omar;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.in;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author omar
 */
public class Coursework3_Omar {
    //VARIABLES
    static Person users = new Person(); //ARRAY OF USERS
    static Person activeUser = null; //ACTIVE USER IN CURRENT SESSION
    static Person newUser; //CREATION OF NEW USER (SO EVERYTIME WE AVOID TO CREATE A NEW PERSON OBJECT) (REDUNDANT CODE)
    static Info database = new Info(); // ARRAY OF DATA
    static Info newData; //CREATION OF NEW DATA (SO EVERYTIME WE AVOID TO CREATE A NEW INFO OBJECT) (REDUNDANT CODE)
    //FEATURES
    static Scanner input = new Scanner(in); //INPUT
    static Random rd = new Random();

    public static void main(String[] args) throws IOException {
        //FILES TO RETRIEVE THE DATA
        //-----------------------------------
        File f1=new File("users.txt");
        FileWriter fw = new FileWriter("users.txt", true);
        BufferedWriter bw = new BufferedWriter(fw);
        
        File f2=new File("database.txt");
        FileWriter fw2 = new FileWriter("database.txt", true);
        BufferedWriter bw2 = new BufferedWriter(fw2);
        
        File f3=new File("sharedata.txt");
        FileWriter fw3 = new FileWriter("sharedata.txt", true);
        BufferedWriter bw3 = new BufferedWriter(fw3);
        //-----------------------------------
        //GET USERS FROM FILE
        //-----------------------------------
        Scanner myReader = new Scanner(f1); //scanner to read f1 which is the file of users
        System.out.println("\nUsers registered:");
        String line; //variable that will contain each line from the file and it will be analyzed
        if(myReader.hasNextLine())
        {
            while (myReader.hasNextLine()) { //until the file has got lines to read...
                line = myReader.nextLine();//every line is stored into this variable
                System.out.println(line);//test to see if the line has been stored and printed out
                String[] data = line.split("-");//the line will be splitted into an array of strings for every dash sign '-' 
                //ANALYSATION
                //if data2[4] which is the index of the array of strings that contains the type of the user
                switch(data[4]){
                    case "Client"://if the array at the position '4' contains the string "Client"
                        newUser = new Client(data[0],data[1],data[2],Integer.parseInt(data[3]),data[6]); //then create a new Client user
                        break;
                    case "External"://if the array at the position '4' contains the string "External"
                        newUser = new External(data[0],data[1],data[2],Integer.parseInt(data[3]),data[6]);//then create a new External user
                        break;
                    case "HnKEmployee"://if the array at the position '4' contains the string "Client"
                        newUser = new HnKEmployee(data[0],data[1],data[2],Integer.parseInt(data[3]), data[6],data[7]);//then create a new H&K user
                        break;
                }
                users.addUser(newUser);//after creating the right user, it will be inserted into the arraylist of users
                }
        }
        else
            System.out.println("\nNo user registred.\n");
        //-----------------------------------
        //GET DATA FROM FILE
        //-----------------------------------
        myReader = new Scanner(f2);
        System.out.println("\nData registered:");
        if(myReader.hasNextLine())
        {
            while (myReader.hasNextLine()) { //until the file has got lines to read...
                line = myReader.nextLine();//every line is stored into this variable
                System.out.println(line);//test to see if the line has been stored and printed out
                String[] data = line.split("-");//the line will be splitted into an array of strings for every dash sign '-' 
                //ANALYSATION
                //if data[4] which is the index of the array of strings that contains the type of the user
                newData = new Info(Integer.parseInt(data[0]),data[1],Integer.parseInt(data[2])); //create a new Data object with the parameters
                database.addData(newData);
            }
        }
        else
            System.out.println("\nNo data registred.\n");
        //-----------------------------------
        //READ SHARED DATA
        //-----------------------------------
        myReader = new Scanner(f3);
        System.out.println("\nData shared:");
        if(myReader.hasNextLine())
        {
            while (myReader.hasNextLine()) { //until the file has got lines to read...
                line = myReader.nextLine();//every line is stored into this variable
                System.out.println(line);//test to see if the line has been stored and printed out
            }
        }
        else
            System.out.println("\nNo data shared.\n");
        myReader.close();
        //-----------------------------------
        //START OF THE EXECUTION
        //-----------------------------------
        while(true)
        {
            //-----------------------------------
            //LOGIN AND REGISTRATION
            //-----------------------------------
            while(true)//The loop is needed in case the user enters the wrong input
            {
                System.out.print("\nType 'L' to Log in or 'R' to Register as a new user: ");
                String firstAction = input.nextLine();
                if(firstAction.equals("L"))
                {
                    if((activeUser=loginUser()) != null)
                        //if the user decides to login, the method at the bottom of this file will be launched
                        break;
                }
                else if(firstAction.equals("R")){
                    activeUser = registerNewUser();//if the user decides to register, the method at the bottom of this file will be launched
                    users.addUser(activeUser);//also the new user will be stored into the database of users
                    break;
                }
                else//input error
                    System.out.print("Error. Try again.");
            }
            //-----------------------------------
            //HOMEPAGE
            //-----------------------------------
            System.out.println("\nHello!\n\nThese are your details.\n\n"+activeUser.getInfo()+"\n\nYou are a: "+activeUser.getRole()+"\n\nHere your possible actions:\n"+activeUser.getAccessibilities());
            //-----------------------------------
            while(true)
            {
                System.out.println("\nChoose an option or type 'E' to exit:");
                String action = input.nextLine();//the user will be asked to chose an action to be performed
                if(action.equals("E"))//if he decides to exit, the program will ask to login or register again
                    break;//exit from the loop
                else
                {
                    if(activeUser.actionPermission(action))//IF THE ACTION INSERTED BY THE USER IS PERMITTED...
                    {
                        if(action.contains("Share"))
                        {
                            //if the user decides to share a data with another user
                            //first he will be asked to input the id of the data
                            System.out.println("Enter ID of the data to be shared:");
                            String dataId = input.nextLine();
                            //the id will be checked to see if it exists or not
                            while(database.checkDataId(Integer.parseInt(dataId)))
                            {
                                //if it does not exist it will enter into a loop where he can decide to input again a new data id 
                                System.out.println("Error id does not exist. Try again or type 'B' to go back:");
                                dataId = input.nextLine();
                                //or just go back to the menu
                                if(dataId.equals("B"))
                                    break;
                            }
                            //the user will be asked to enter the user ID
                            System.out.println("Enter ID of the User receiver:");
                            String userId = input.nextLine();
                            //if it does not exist, the user will be asked to input again
                            while(users.checkId(Integer.parseInt(userId)))
                            {
                                System.out.println("Error id does not exist. Try again or type 'B' to go back:");
                                userId = input.nextLine();
                                //or just go back to the menu
                                if(dataId.equals("B"))
                                    break;
                            }
                            if(!userId.equals("B"))
                            {
                                bw3.write("Data ID: "+database.getData(database.dataIndexInArray(Integer.parseInt(dataId))).getId()+" from: "+activeUser.getId()+" to: "+userId);
                                bw3.newLine();
                                System.out.println("Data shared successfully");
                            }
                            
                        }
                        else if(action.contains("Print"))
                            //the user can decide to print all the data in the database
                            database.printData();
                        else if(action.contains("Edit"))
                        {
                            //the user can decide to edit a particular identified data
                            System.out.println("Enter ID of the data to be edited:");
                            int dataId = Integer.parseInt(input.nextLine());
                            System.out.println("Enter new content of the data:");
                            String newContent = input.nextLine();
                            //the id will be checked. if it is found (if the function return false), the software will proceed to the editing
                            database.editDataById(dataId,newContent);
                            
                        }
                        else if(action.contains("Insert"))//critical evaluation: date format could be included into the INFO class
                        {
                            //the user is able to insert a new data into the array, starting by asking the content
                            System.out.println("Enter content of the data:");
                            String content = input.nextLine();
                            //then the software will insert it into the array called database
                            newData = new Info(generateIdData(),content,activeUser.getId());//create a new Info object 
                            database.addData(newData);
                            System.out.println("New data inserted.");
                        }
                        else if(action.contains("Delete"))
                        {
                            //same as editing, the user will be asked to insert the id of the data to be deleted.
                            System.out.println("Enter ID of the data to be edited:");
                            int dataId = Integer.parseInt(input.nextLine());
                            //the id will be checked and deleted if found.
                            database.deleteDataById(dataId);
                        }
                    }
                    else //IF THE ACTION IS NOT PERMITTED...
                        System.out.println("\nAccess denied to this action or action does not exist.");
                }
            }

            //everything will be written on the files I have initiated
            new PrintWriter("users.txt").close();//empty the file because the software will write on it at the end of the execution
            for(Person a:users.getArrayUsers())//users file
            {
                bw.write(a.getInfoUser());
                bw.newLine();
            }
            new PrintWriter("database.txt").close();//empty the file because the software will write on it at the end of the execution
            for(Info a:database.getDataArray())//data file
            {
                bw2.write(a.getDataInfo());
                bw2.newLine();
            }
            //the user is able to terminate the program by typing 'T' or press the enter button to continue with the login or registration
            System.out.println("\nSaving everything...\n\nPress any button to continue or type 'T' to terminate the program.");
            if(input.nextLine().equals("T"))
            {
                //closing the file buffers
                bw.close();
                bw2.close();
                bw3.close();
                break;
            }
        }
    }
    
    //the functions below generates a random ID and checks if it exists in the arrays users and data so he can generate a new one
    public static int generateIdUser(){
        int userId = rd.nextInt(999);
        while(!users.checkId(userId))
            userId = rd.nextInt(999);
        return userId;
    }
    
    public static int generateIdData(){
        int dataId = rd.nextInt(999);
        while(!database.checkDataId(dataId))
            dataId = rd.nextInt(999);
        return dataId;
    }
    
    //the function below displays the form of the registration of a new user. it returns a new Person object
    public static Person registerNewUser(){
        //details input
        System.out.println("\nREGISTER\nEnter email: ");
        String userEmail = input.nextLine();  

        System.out.println("Enter password: ");
        String userPassword = input.nextLine();  

        System.out.println("Enter name: ");
        String userName = input.nextLine();  

        int userId = generateIdUser();
        String userRole;
        do{
            System.out.println("Enter user role: E = 'External user', H = 'H&K Employee', C = 'Client'");
            userRole = input.nextLine();
        }while((!userRole.equals("E") && !userRole.equals("H")) && !userRole.equals("C"));
        //--------------------------------
        //depending on the role choosen by the user, the system will display a different input interface.
        switch(userRole) 
        { 
            case "E"://if the user is External ('E')
                System.out.println("Enter your organisation: ");
                String userOrg = input.nextLine();
                newUser = new External(userEmail, userPassword, userName, userId, userOrg);
                break; 
            case "H": //if the user is an HnK Employee ('H')
                System.out.println("Enter your skills (enter 'F' when you finished): ");
                String userSkills = "";
                while(true){//the user will input skills until he presses 'F' to finish the list
                    String userSkill = input.nextLine()+",";
                    if("F,".equals(userSkill))
                        break;
                    else
                        userSkills = userSkills+userSkills; //skills will be append to the list of skills
                }
                System.out.println("Enter your department: ");
                String userDepartment = input.nextLine();
                newUser = new HnKEmployee(userEmail, userPassword, userName, userId,userSkills,userDepartment);
                break; 
            case "C": //if the user is a Client ('C')
                System.out.println("Enter your address: ");
                String userAddress = input.nextLine();
                newUser = new Client(userEmail, userPassword, userName, userId, userAddress);
                break;  
        }
        
        return newUser;
    }
    
    //the function below checks if the user is present into the array
    public static Person loginUser(){
        String userid;
        
        do{
            System.out.print("\nLOGIN\n\nInsert ID: ");
            userid = input.nextLine();
            try 
            {
                System.out.println("User ID "+(users.checkId(Integer.parseInt(userid)) ? "does not exist. Try again or press 'B' to go back to register" : "do exist"));
            } 
            catch (NumberFormatException e) 
            {
                break;
            }
        }while(users.checkId(Integer.parseInt(userid)));
        
        if("B".equals(userid))
            return null;
        else
            return users.getUser(Integer.parseInt(userid));
    }
    
}
