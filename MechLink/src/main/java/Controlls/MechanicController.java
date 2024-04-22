package Controlls;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MechanicController implements Initializable {

    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    protected void onLogoutButtonClick(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("SignUpView"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    protected void onBrowseButtonClick(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("mechanic-browse.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    protected void onAcceptedJobsButtonClick(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("mechanic-acceptedJobs.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
