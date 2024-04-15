package Controlls;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class JobFilledController {

    @FXML
    private Label myName;

    @FXML
    private Label myLocation;

    @FXML
    private Label myCarModel;

    @FXML
    private Label myDate;

    @FXML
    private Label myJobDescription;

    public void setNewJobData(String fullName, String date, String location, String carModel, String jobDescription) {
        myName.setText(fullName);
        myDate.setText(date);
        myLocation.setText(location);
        myCarModel.setText(carModel);
        myJobDescription.setText(jobDescription);
    }

}
