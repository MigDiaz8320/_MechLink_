package Controlls;
import View.TestClientScreen;
import Model.Job;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;

public class JobPostingController {
    private ClientDashboardController clientDashboardController;

    @FXML
    public TextField firstNameField;
    public TextField lastNameField;
    public DatePicker datePicked;
    public TextField locationField;
    public TextField carModelField;
    public TextField jobDescriptionField;

    @FXML
    public Button submitBtn;
    public Button cancelBtn;

    @FXML
    public Button okBtn;


    @FXML
    public void submitBtnClicked() {
        if (userFilledForm()) {
            Job newUserJob = new Job();
            String firstName = firstNameField.getText();
            String lastName = lastNameField.getText();
            String carModel = carModelField.getText();
            LocalDate datePosted = datePicked.getValue();
            newUserJob.setLocation(locationField.getText());
            newUserJob.setJobDescription(jobDescriptionField.getText());
            String fullName = firstName + " "+lastName;


            System.out.println("First Name: "+firstName);
            System.out.println("Last Name: "+lastName);
            System.out.println("Date Posted: "+datePosted);
            System.out.println("Location: "+newUserJob.getLocation());
            System.out.println("Job Description: "+newUserJob.getJobDescription());
            System.out.println();
            clientDashboardController.addNewJob(fullName, datePosted, newUserJob.getLocation(), carModel, newUserJob.getJobDescription());
            Stage stage = (Stage) submitBtn.getScene().getWindow();
            stage.close();
            System.out.println("FILLED");
        } else {
            formNotFilledAlert();
            System.out.println("NOT FILLED!");
        }
    }

    private boolean userFilledForm() {
        if (!firstNameField.getText().isEmpty() && !lastNameField.getText().isEmpty() && datePicked.getValue() != null
                && !locationField.getText().isEmpty() && !carModelField.getText().isEmpty() && !jobDescriptionField.getText().isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    private void formNotFilledAlert() {
        try {
            FXMLLoader loader = new FXMLLoader(TestClientScreen.class.getResource("/View/job-form-not-filled-alert.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void okBtnClicked() {
        Stage stage = (Stage) okBtn.getScene().getWindow();
        stage.close();
    }

    @FXML
    public void cancelBtnClicked() {
        Stage stage = (Stage) cancelBtn.getScene().getWindow();
        stage.close();
    }

    public void setClientDashboardController(ClientDashboardController clientDashboardController) {
        this.clientDashboardController = clientDashboardController;
    }
}