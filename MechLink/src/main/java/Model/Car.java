package Model;

public class Car {
    private String make;
    private String model;
    private int year;
    public String getMake(){
        return make;
    }

    public int getYear() {
        return year;
    }

    public String getModel() {
        return model;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
