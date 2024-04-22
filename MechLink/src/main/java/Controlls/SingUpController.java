package Controlls;

import Model.UserCreation;
import View.SignUpView;

public class SingUpController {
    private SignUpView signUpView;

    public void showView() {
        signUpView = SignUpView.getInstance();
        signUpView.getStage().show();
    }

    public void createUser() {
        signUpView = SignUpView.getInstance();
        String firstName = signUpView.getFirstName().getText();
        String lastName = signUpView.getLastName().getText();
        String address = signUpView.getAddress().getText();
        String phoneNumber = signUpView.getPhoneNumber().getText();
        String zipCode = signUpView.getZipCode().getText();
        String userName = signUpView.getUserName().getText();
        String email = signUpView.getEmailTextField().getText();
        String password = signUpView.getPasswordField().getText();
        String selectedType = signUpView.getSelectedUser();
        boolean isMechanic = selectedType.equals("Mechanic"); // Using .equals() for string comparison

        UserCreation userCreation = new UserCreation();

        userCreation.createUser(userName, password, firstName, lastName, zipCode, isMechanic);

        String confirmPassword = signUpView.getPasswordConfirmation().getText();

        if (!validateInput(firstName, lastName, address, phoneNumber, zipCode, userName, email, password, confirmPassword)) {
            signUpView.showError("Invalid input. Please check your input fields.");
        } else {
            System.out.println("User created: " + firstName + " " + lastName);
            System.out.println("User type: " + selectedType);
            if (selectedType.equals("Client") && password.equals(confirmPassword)) { // Moved password comparison to validation logic
                // Assuming showClientDashboard() is a method in ClientDashboardController
                System.out.println("Showing the client view");

                ClientDashboardController controller = new ClientDashboardController();
                controller.showView();
            } else {
                System.out.println("Showing the Mechanic view");
            }
        }
    }

    private boolean validateInput(String firstName, String lastName, String address, String phoneNumber, String zipCode, String userName, String email, String password, String confirmPassword) {
        // Add validation logic here
        // Example: Check if all fields are non-empty and if password matches confirmation
        return !firstName.isEmpty() && !lastName.isEmpty() && !address.isEmpty() && !phoneNumber.isEmpty() && !zipCode.isEmpty() && !userName.isEmpty() && !email.isEmpty() && !password.isEmpty() && password.equals(confirmPassword);
    }
}