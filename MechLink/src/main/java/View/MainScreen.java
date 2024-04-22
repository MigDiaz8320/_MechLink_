package View;

import Controlls.MainScrenController;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;



public class MainScreen extends Application {
    private MainScrenController controller ;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setMaximized(true);
        Scene sn = new Scene(createRootNode(), 500, 700);
        loadStylesheetIntoScene(sn);
        primaryStage.setScene(sn);
        primaryStage.setTitle("Welcome page");
        primaryStage.show();
    }

    public static void createNewDatabase(String fileName) {

        String url = "jdbc:sqlite:" + fileName;

        try (Connection conn = DriverManager.getConnection(url)) {
            if (conn != null) {
                DatabaseMetaData meta = conn.getMetaData();
                //System.out.println("The driver name is " + meta.getDriverName());
                System.out.println("A new database has been created.");
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        createNewDatabase("MechlinkData.db");
        // Set the controller instance
        launch(args);
    }

    private void loadStylesheetIntoScene(Scene scene) {
        URL stylesheetURL = getClass().getResource("/mainStyle.css");
        if (stylesheetURL == null) {
            System.out.println("the style sheet was null!!!!");
            return;
        }
        scene.getStylesheets().add(stylesheetURL.toExternalForm());
    }

    public Parent createRootNode() {
        Image logo = new Image("images/icon.png");
        ImageView imageView = new ImageView(logo);
        imageView.setFitWidth(110);
        imageView.setPreserveRatio(true);
        HBox hb = new HBox(imageView);
        hb.setAlignment(Pos.CENTER);

        VBox vb = new VBox(10);
        vb.getStyleClass().add("root");
        vb.setSpacing(30);
        vb.getChildren().addAll(hb, createLabelsForTheLogo(), createButtons());
        return vb;
    }

    static VBox createLabelsForTheLogo() {
        Label brandLogo = new Label("MechLink");
        brandLogo.getStyleClass().add("brandName");
        Label slogan = new Label("MechLink: Drive. Connect. Thrive");
        slogan.getStyleClass().add("slogan");
        VBox logoBox = new VBox(4, brandLogo, slogan);
        logoBox.setAlignment(Pos.CENTER);
        return logoBox;
    }

    /**
     * This method will serve as button constructor or creator. Sometime in the future we may add event handlers to the buttons.
     *
     * @return VBox that holds two buttons.
     */
    public VBox createButtons() {

        Button signUpBtn = new Button("Sign up");
        Button loginBtn = new Button("Log in");
        controller = new MainScrenController(signUpBtn, loginBtn);
        signUpBtn.setOnAction(event -> {
            System.out.println("sign up btn pressed");
           controller.signUpBtnHandler();
        });

        loginBtn.setOnAction(event -> {

         controller.loginHandler();
        });



        VBox box = new VBox(30, signUpBtn, loginBtn);
        signUpBtn.getStyleClass().add("mainBtns");
        loginBtn.getStyleClass().addAll("mainBtns");
        box.getStyleClass().add("buttonBox");
        return box;
    }

//
//    @Override
//    public void start(Stage stage) throws Exception {
//        Parent root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
//    Scene sn = new Scene(root,700, 670);
//stage.setScene(sn );
//stage.setTitle("Welcome To MechLink!");
//stage.show();
//    }

}
