package Controlls;

import Main.LoginView;
import Main.SignUpView;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Button;

public class MainScrenController {
    //SignUpController
        //ask the controller to show the view
    //singin controller
        //ask the controller to show the view
//    SingUpController singUpController ;
//    SignUpView signUpView;
    @FXML
    private Button signUpBtn;

    @FXML
    private Button loginBtn;
//   public MainScrenController(SignUpView signUpView){
////       this.signUpView  = signUpView;
//   }
    private void showSignUpView(){
//       signUpView.
    }
 public void signUpBtnHandler(){

     System.out.println(" Message Fromm the Controller : sign up button clicked!");
 }
public  void loginHandler(){
    System.out.println("login clicked");
    LoginViewController controller =  new  LoginViewController();
    controller.showLoginView();

}
    public MainScrenController(Button signUpBtn, Button loginBtn) {
        this.signUpBtn = signUpBtn;
        this.loginBtn = loginBtn;

    }
}