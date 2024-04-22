package View;

import Controlls.SingUpController;
import Model.UserCreation;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.*;

public class SignUpView {
    private static SignUpView instance;
private String selectedUser ;
    private final Stage stage;
    private final Scene scene;
    private static  TextField firstName;
    private static  TextField lastName;
    private final TextField address;
    private final TextField phoneNumber;
    private static  TextField zipCode;
    private static  TextField userName;
    private static  TextField emailTextField;
    private static  PasswordField passwordField;
    private static  PasswordField passwordConfirmation;
    private final Button createBTN;

    private SignUpView() {
        // Create layout and add components
        GridPane gridPane = new GridPane();
        gridPane.getStyleClass().addAll("signUpView", "text");
        gridPane.setPadding(new Insets(10, 9, 0, 20));
        gridPane.setVgap(20);
        gridPane.setHgap(10);

        // Create UI components
        Label firstLabel = new Label("First name");
        firstName = new TextField();

        Label lastLabel = new Label("Last Name ");
        lastName = new TextField();

        Label contact = new Label("Contact");
        contact.setUnderline(true);
        contact.getStyleClass().add("title");

        Label emailLabel = new Label("Email:");
        emailTextField = new TextField();

        Label passwordLabel = new Label("Password:");
        passwordField = new PasswordField();

        Label phoneLabel = new Label("Phone:");
        phoneNumber = new TextField();

        Label addressLabel = new Label("Address:");
        address = new TextField();

        Label passConfirmationLabel = new Label("Password Confirmation");

        Label zipCodeLabel = new Label("Zip-Code");
        zipCode = new TextField();

        Label userNameLabel = new Label("User name ");
        userName = new TextField();

        passwordConfirmation = new PasswordField();
        passwordConfirmation.setPromptText("Re-enter your password!");

        Label secondTitle = new Label("Finish signing up");
        secondTitle.getStyleClass().add("title");

        createBTN = new Button("Create");
        createBTN.getStyleClass().add("loginBtn");

        // ToggleGroup for radio buttons
        ToggleGroup toggleGroup = new ToggleGroup();
        RadioButton mechanicRadioBtn = new RadioButton("Mechanic");
        RadioButton clientRadioBtn = new RadioButton("Client");

       mechanicRadioBtn.setToggleGroup(toggleGroup);
        clientRadioBtn.setToggleGroup(toggleGroup);

        // Add nodes to the grid
        gridPane.add(firstLabel, 0, 0);
        gridPane.add(firstName, 1, 0);
        gridPane.add(lastLabel, 0, 1);
        gridPane.add(lastName, 1, 1);
        gridPane.add(contact, 0, 4);
        gridPane.add(emailLabel, 1, 5);
        gridPane.add(emailTextField, 2, 5);
        gridPane.add(phoneLabel, 3, 5);
        gridPane.add(phoneNumber, 4, 5);
        gridPane.add(userNameLabel, 1, 6);
        gridPane.add(userName, 2, 6);
        gridPane.add(passwordLabel, 3, 6);
        gridPane.add(passwordField, 4, 6);
        gridPane.add(passConfirmationLabel, 3, 7);
        gridPane.add(passwordConfirmation, 4, 7);
        gridPane.add(addressLabel, 1, 8);
        gridPane.add(address, 2, 8);
        gridPane.add(zipCodeLabel, 3, 8);
        gridPane.add(zipCode, 4, 8);
        gridPane.add(secondTitle, 0, 10);
        gridPane.add(mechanicRadioBtn, 1, 11);
        gridPane.add(clientRadioBtn, 1, 12);
        gridPane.add(createBTN, 4, 16);

        // Create scene
        scene = new Scene(gridPane, 500, 700);
        loadStylesheetIntoScene(scene);
//add event to the createBTN
        createBTN.setOnAction(event -> {
            SingUpController controller = new SingUpController();
            //Testing user creation
            boolean selectedType = true;
            //String firstName, String lastName, String address, String phoneNumber, String zipCode,String userName, String password, boolean selectedUser
            //UserCreation.createUser(firstName.getText(),lastName.getText(),address.getText(), phoneNumber.getText(), zipCode.getText(), userName.getText(), passwordField.getText(), selectedType);
            //CALLS USER CREATION TO CREATE NEW USER + ENTER INTO DB
            UserCreation.createUser();
            System.out.println("New Login. Username: " + userName.getText() + " Password: " + passwordField.getText());
//            controller.createUser();
        });
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

    public static TextField getFirstName() {
        return firstName;
    }

    public static TextField getLastName() {
        return lastName;
    }

    public TextField getAddress() {
        return address;
    }

    public TextField getPhoneNumber() {
        return phoneNumber;
    }

    public static TextField getZipCode() {
        return zipCode;
    }

    public static TextField getUserName() {
        return userName;
    }

    public static TextField getEmailTextField() {
        return emailTextField;
    }

    public static PasswordField getPasswordField() {
        return passwordField;
    }

    public static PasswordField getPasswordConfirmation() {
        return passwordConfirmation;
    }

    public Button getCreateBTN() {
        return createBTN;
    }
public String getSelectedUser(){
        return selectedUser;
}



    private void loadStylesheetIntoScene(Scene scene) {
        URL stylesheetURL = getClass().getResource("/mainStyle.css");
        if (stylesheetURL == null) {
            System.out.println("The style sheet was null!");
            return;
        }
        scene.getStylesheets().add(stylesheetURL.toExternalForm());
    }
}


