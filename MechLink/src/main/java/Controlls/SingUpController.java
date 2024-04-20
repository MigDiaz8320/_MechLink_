package Controlls;

import View.SignUpView;

public class SingUpController {
    SignUpView signUpView;

    public void showSigUpView() {
        signUpView = SignUpView.getInstance();
        signUpView.getStage().show();
    }

    public void createUser() {
        String firstName = signUpView.getFirstName().getText();
        String lastName = signUpView.getLastName().getText();
        String address = signUpView.getAddress().getText();
        String phoneNumber = signUpView.getPhoneNumber().getText();
        String zipCode = signUpView.getZipCode().getText();
        String userName = signUpView.getUserName().getText();
        String email = signUpView.getEmailTextField().getText();
        String password = signUpView.getPasswordField().getText();
        String selectedType = signUpView.getSelectedUser();
        String confirmPassword = signUpView.getPasswordConfirmation().getText();

        if (validateInput(firstName, lastName, address, phoneNumber, zipCode, userName, email, password, confirmPassword)) {
            // Perform user creation logic
            System.out.println("User created: " + firstName + " " + lastName);
            System.out.println("User type: " + selectedType);
        } else {
            System.out.println("Invalid input. Please check your input fields.");
        }
    }

    private boolean validateInput(String firstName, String lastName, String address, String phoneNumber, String zipCode, String userName, String email, String password, String confirmPassword) {
        // Add validation logic here
        // Example: Check if all fields are non-empty and if password matches confirmation
        return !firstName.isEmpty() && !lastName.isEmpty() && !address.isEmpty() && !phoneNumber.isEmpty() && !zipCode.isEmpty() && !userName.isEmpty() && !email.isEmpty() && !password.isEmpty() && password.equals(confirmPassword);
    }
}