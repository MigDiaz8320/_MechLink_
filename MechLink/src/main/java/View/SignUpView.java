package View;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import javafx.scene.control.RadioButton;
import java.net.URL;
import java.util.concurrent.Callable;

public class SignUpView {
    private static SignUpView instance;

    private final Stage stage;
    private final Scene scene;
    private TextField firstName, lastName, address, phoneNumber, zipCode, userName ;
    private TextField emailTextField;
    private PasswordField passwordField;
    private Button createBTN;

    private SignUpView() {

        // Create layout and add components
        GridPane gridPane = new GridPane();
        gridPane.getStyleClass().add("signUpView");
        gridPane.getStyleClass().add("text");

        gridPane.setPadding(new Insets(10, 9, 0, 20));
        gridPane.setVgap(20);
        gridPane.setHgap(10);
        // Create UI components
        // First & last name labels and text fields
        Label firstLabel = new Label("First name");
        firstName = new TextField();


        Label lastLabel = new Label("Last Name ");
        lastName = new TextField();

        // Contact label
        Label contact = new Label("Contact");
        contact.setUnderline(true);
        contact.getStyleClass().add("title");
        // Email,  ,
        Label emailLabel = new Label("Email:");
        emailTextField = new TextField();
        //password
        Label passwordLabel = new Label("Password:");
        passwordField = new PasswordField();
        // Phone label and text field
        Label phoneLabel = new Label("Phone:");
        phoneNumber = new TextField();

        // Address label and text field
        Label addressLabel = new Label("Address:");
        address = new TextField();


Label zipCodeLabel = new Label("Zip-Code");
TextField zipCode = new TextField();
Label userNameLabel = new Label("User name ");
TextField userNameTextField = new TextField();


Label secondTitle  = new Label("Finish signing up)");
secondTitle.getStyleClass().add("title");


        createBTN = new Button("create ");
        createBTN.getStyleClass().add("loginBtn");
        //ad nodes to the grid
        gridPane.add(firstLabel, 0,0);
        gridPane.add(firstName, 1,0);

RadioButton rb1 = new RadioButton("Mechanic ");
        RadioButton rb2 = new RadioButton("Client ");
        gridPane.add(lastLabel, 0,1);
        gridPane.add(lastName, 1, 1);

        gridPane.add(contact,0, 4);

        gridPane.add(emailLabel,1, 5);
        gridPane.add(emailTextField, 2,5);

        gridPane.add(phoneLabel, 3,5);
        gridPane.add(phoneNumber, 4,5);
        gridPane.add(userNameLabel, 1, 6);
        gridPane.add(userNameTextField, 2, 6);

        gridPane.add(passwordLabel, 3,6);
        gridPane.add(passwordField, 4, 6);
        gridPane.add(addressLabel, 1, 7);
        gridPane.add(address, 2, 7);
        gridPane.add(zipCodeLabel, 1, 8);
        gridPane.add(zipCode, 2, 8);
        gridPane.add(secondTitle, 0, 10);
        gridPane.add(rb1, 1, 11);
        gridPane.add(rb2, 1, 12);
gridPane.add(createBTN, 4, 16);


        // Create scene
        scene = new Scene(gridPane, 500, 700);
        loadStylesheetIntoScene(scene);

        // Create stage
        stage = new Stage();
        stage.setMaximized(true);
        stage.setScene(scene);
        stage.setTitle("Create an account");
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

    public Button getcreateBTN() {
        return createBTN;
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
