package Controlls;
import View.TestClientScreen;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class ClientDashboardController implements Initializable {
    @FXML
    private Button postJobBtn;

    @FXML
    private VBox jobPostedVBox;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        postJobBtn.setOnMouseEntered(event -> mouseHoverBtn());
    }

    @FXML
    public void postJobButtonClicked() {
        try {
            FXMLLoader loader = new FXMLLoader(TestClientScreen.class.getResource("/View/job-posting-form.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setTitle("Job Posting Form");
            JobPostingController jobPostingController = loader.getController();
            jobPostingController.setClientDashboardController(this);
            Scene scene = new Scene(root, 278, 495);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addNewJob(String fullName, LocalDate datePosted, String location, String carModel, String jobDescription) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/job-filled.fxml"));
            AnchorPane jobEntry = loader.load();

            JobFilledController controller = loader.getController();
            controller.setNewJobData(fullName, datePosted.toString(), location, carModel, jobDescription);
            jobPostedVBox.getChildren().add(jobEntry);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showView() {
        try {
            FXMLLoader loader = new FXMLLoader(TestClientScreen.class.getResource("/View/client-dashboard.fxml"));
            Scene scene = new Scene(loader.load(), 665, 665);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void mouseHoverBtn() {
        postJobBtn.setCursor(Cursor.HAND);
    }
}