package Controlls;

import View.SignUpView;

public class SingUpController {
    SignUpView signUpView;
    public void showSigUpView(){
       signUpView=  SignUpView.getInstance();

        signUpView.getStage().show();



    }
    public  void createUser(){
//        signUpView.get
    }
}
