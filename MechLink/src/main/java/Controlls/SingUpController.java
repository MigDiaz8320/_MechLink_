package Controlls;

import View.SignUpView;

public class SingUpController {
    public void showSigUpView(){
  SignUpView signUpView =  SignUpView.getInstance();

        signUpView.getStage().show();



    }
}
