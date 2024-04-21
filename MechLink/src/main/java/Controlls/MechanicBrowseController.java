package Controlls;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MechanicBrowseController implements Initializable {

    @FXML
    private ListView<String> browseListView;
    @FXML
    private Label browseLabel;

    private Stage stage;
    private Scene scene;
    private Parent root;

    String[] jobs = {"Brakes", "Engine", "Tail-lights"};

    String currentJob;

    @FXML
    protected void onReturnButtonClick(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("mechanic.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        browseListView.getItems().addAll(jobs);
        browseListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {

                currentJob = browseListView.getSelectionModel().getSelectedItem();

                browseLabel.setText(currentJob);
            }
        });

    }
}
