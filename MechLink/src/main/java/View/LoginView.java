package View;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.net.URL;

public class LoginView {
    private static LoginView instance;

    private final Stage stage;
    private final Scene scene;

    private TextField emailTextField;
    private PasswordField passwordField;
    private Button loginButton;

    private LoginView() {
        // Create UI components
        Label emailLabel = new Label("Email:");
        emailTextField = new TextField();

        Label passwordLabel = new Label("Password:");
        passwordField = new PasswordField();

        loginButton = new Button("Login");

        // Create layout and add components
        GridPane gridPane = new GridPane();
        gridPane.getStyleClass().addAll("login");
        loginButton.getStyleClass().add("loginBtn");

        gridPane.setVgap(30);
        gridPane.setPadding(new Insets(20));

        gridPane.setHgap(10);
        gridPane.add(emailLabel, 0, 0);
        gridPane.add(emailTextField, 1, 0);
        gridPane.add(passwordLabel, 0, 1);
        gridPane.add(passwordField, 1, 1);
        gridPane.add(loginButton, 1, 2);

        // Create scene
        scene = new Scene(gridPane, 500, 700);
        loadStylesheetIntoScene(scene);

        // Create stage
        stage = new Stage();
        stage.setMaximized(true);
        stage.setScene(scene);
        stage.setTitle("Login");
    }

    public static LoginView getInstance() {
        if (instance == null) {
            instance = new LoginView();
        }
        return instance;
    }

    public Stage getStage() {
        return stage;
    }

    public Scene getScene() {
        return scene;
    }

    public TextField getEmailTextField() {
        return emailTextField;
    }

    public PasswordField getPasswordField() {
        return passwordField;
    }

    public Button getLoginButton() {
        return loginButton;
    }

    private void loadStylesheetIntoScene(Scene scene) {
        URL stylesheetURL = getClass().getResource("/mainStyle.css");
        if (stylesheetURL == null) {
            System.out.println("the style sheet was null!!!!");
            return;
        }
        scene.getStylesheets().add(stylesheetURL.toExternalForm());
    }
}