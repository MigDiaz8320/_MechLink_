package Model;

public class Mechanic extends User{
    //Mechanic Default Constructor
    public Mechanic(){

    }
    // Mechanic Constructor with parameters
    public Mechanic(String fName, String lName, int zipCode, int idNum, String emailAddress, String username, String password){
        super(fName, lName, zipCode, idNum, emailAddress, username, password);
    }
    public void cancelWork(int jobID){
        System.out.println("Cancel job.");

    }
    public boolean acceptWork(int jobID){
        return true;
    }
    public void browseJobs(){
        System.out.println("Browse jobs that are available.");

    }
    public void viewJobHistory(){
        System.out.println("View your job history.");

    }
}
