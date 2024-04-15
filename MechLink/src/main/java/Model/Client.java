package Model;

import Model.Controller.Authenticator;

import java.util.Map;
import java.util.Scanner;

public class Client extends User implements Authenticator {
    private Car[] cars;
    private String address;
    private Map servicesNeeded;

    //Default Constructor
    public Client(){

    }
    //Constructor with parameters
    public Client(String address, String fName, String lName, int zipcode, int idNum, String emailAddress, String username, String password){
        super(fName, lName, zipcode, idNum, emailAddress, username, password);
        this.address = address;
    }

    public String getAddress(){
        return address;
    }

    public Car[] getCars() {
        return cars;
    }

    public void setCars(Car[] cars) {
        this.cars = cars;
    }
    public void postWork(){
        Scanner input = new Scanner(System.in);
        System.out.println("Post any work you need help with your car.");

        String postWork = input.nextLine();

    }
    public void removeWork(){
        System.out.println("Remove any work off your list.");

    }
    public void modifyWork(){
        System.out.println("Modify your list.");

    }
    public void confirmWork(){
        System.out.println("Confirm if work has been completed.");

    }

    @Override
    public void updateInformation(String updateInformation) {
        this.address = address;
    }

    @Override
    public void login() {

    }
}
