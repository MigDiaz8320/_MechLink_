package Controlls;

import View.LoginView;

public class LoginViewController {
    public void showLoginView(){
        LoginView loginView = LoginView.getInstance();

       loginView.getStage().show();
    }
    private void navigateToClientPage(){

    }
}
