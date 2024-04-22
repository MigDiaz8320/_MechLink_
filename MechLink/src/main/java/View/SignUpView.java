package View;

import Controlls.SingUpController;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.net.URL;

public class SignUpView {

    private static SignUpView instance;
    private String selectedUser;
    private final Stage stage;
    private final Scene scene;
    private final TextField firstName, lastName, address, phoneNumber, zipCode, userName;
    private final TextField emailTextField;
    private final PasswordField passwordField, passwordConfirmation;
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

        SingUpController controller = new SingUpController();

        // ToggleGroup for radio buttons
        ToggleGroup toggleGroup = new ToggleGroup();
        RadioButton mechanicRadioBtn = new RadioButton("Mechanic");
        RadioButton clientRadioBtn = new RadioButton("Client");
        mechanicRadioBtn.setToggleGroup(toggleGroup);
        clientRadioBtn.setToggleGroup(toggleGroup);

        toggleGroup.selectedToggleProperty().addListener((observable, oldValue, newValue) -> {
            RadioButton selectedRadioButton = (RadioButton) newValue;
            selectedUser = selectedRadioButton.getText();
        });

        createBTN.setOnAction(event -> {
            System.out.println("create btn pressed");
            controller.createUser();
        });

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

    public TextField getUserName() {
        return userName;
    }

    public TextField getEmailTextField() {
        return emailTextField;
    }

    public PasswordField getPasswordField() {
        return passwordField;
    }

    public PasswordField getPasswordConfirmation() {
        return passwordConfirmation;
    }

    public Button getCreateBTN() {
        return createBTN;
    }

    public String getSelectedUser() {
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
    public void showError(String errorMessage) {
        // You can display the error message in a dialog box, label, or any other appropriate way
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(errorMessage);
        alert.showAndWait();
    }

}
