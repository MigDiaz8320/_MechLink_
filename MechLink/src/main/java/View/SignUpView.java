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

public class SignUpView {
    private static SignUpView instance;

    private final Stage stage;
    private final Scene scene;
    private TextField firstName, lastName, address, phoneNumber, zipCode;
    private TextField emailTextField;
    private PasswordField passwordField;
    private Button loginButton;

    private SignUpView() {
        // Create layout and add components
        GridPane gridPane = new GridPane();
        gridPane.getStyleClass().add("signUpView");

        // Create UI components
        // First & last name labels and text fields
        Label firstLabel = new Label("First name");
        firstName = new TextField();
        gridPane.add(firstLabel, 0, 0);
        gridPane.add(firstName, 1, 0);

        Label lastLabel = new Label("Last Name ");
        lastName = new TextField();
        gridPane.add(lastLabel, 0, 1);
        gridPane.add(lastName, 1, 1);

        // Email, password, and login components
        Label emailLabel = new Label("Email:");
        emailTextField = new TextField();

        Label passwordLabel = new Label("Password:");
        passwordField = new PasswordField();

        loginButton = new Button("Login");
        loginButton.getStyleClass().add("loginBtn");

        gridPane.setVgap(10);
        gridPane.setHgap(10);

        // Add email, password, and login components to the grid pane
        gridPane.add(emailLabel, 0, 2);
        gridPane.add(emailTextField, 1, 2);
        gridPane.add(passwordLabel, 0, 3);
        gridPane.add(passwordField, 1, 3);
        gridPane.add(loginButton, 1, 4);

        // Create scene
        scene = new Scene(gridPane, 500, 700);
        loadStylesheetIntoScene(scene);

        // Create stage
        stage = new Stage();
        stage.setMaximized(true);
        stage.setScene(scene);
        stage.setTitle("Create an acount ");
    }

    public static SignUpView getInstance() {
        if (instance == null) {
            instance = new SignUpView();
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

    public TextField getFirstName() {
        return firstName;
    }

    public TextField getLastName() {
        return lastName;
    }

    public TextField getAddress() {
        return address;
    }

    public TextField getPhoneNumber() {
        return phoneNumber;
    }

    public TextField getZipCode() {
        return zipCode;
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
