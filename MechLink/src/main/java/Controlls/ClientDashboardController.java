package Controlls;
import Main.TestClientScreen;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
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
            FXMLLoader loader = new FXMLLoader(TestClientScreen.class.getResource("/Main/job-posting-form.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setTitle("Job Posting Form");
            Scene scene = new Scene(root, 278, 495);
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