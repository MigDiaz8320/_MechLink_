package Model;

public abstract class User {
    private String fName;
    private String lName;
    private int zipcode;
    private int idNum;
    private boolean isMechanic;
    private String emailAddress;
    private String userName;
    private String password;
    private Job[] jobs;

    public User(){

    }

    public User(String fName, String lName, int zipcode, int idNum, String emailAddress, String username, String password) {

    }

    public User(String fName, String lName, int zipcode, int idNum, boolean isMechanic, String emailAddress, String userName, String password, Job[] jobs) {
        this.fName = fName;
        this.lName = lName;
        this.zipcode = zipcode;
        this.idNum = idNum;
        this.isMechanic = isMechanic;
        this.emailAddress = emailAddress;
        this.userName = userName;
        this.password = password;
        this.jobs = jobs;
    }

    public String getFName() {
        return fName;
    }

    public void setFName(String fName) {
        this.fName = fName;
    }

    public String getLName() {
        return lName;
    }

    public void setLName(String lName) {
        this.lName = lName;
    }

    public int getZipcode() {
        return zipcode;
    }

    public void setZipcode(int zipcode) {
        this.zipcode = zipcode;
    }

    public int getIdNum() {
        return idNum;
    }

    public void setIdNum(int idNum) {
        this.idNum = idNum;
    }

    public boolean isMechanic() {
        return isMechanic;
    }

    public void setMechanic(boolean mechanic) {
        isMechanic = mechanic;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Job[] getJobs() {
        return jobs;
    }

    public void setJobs(Job[] jobs) {
        this.jobs = jobs;
    }
}
