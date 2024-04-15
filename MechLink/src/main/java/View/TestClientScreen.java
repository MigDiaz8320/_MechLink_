package View;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;


public class TestClientScreen extends Application {

    @Override
    public void start(Stage stage) throws IOException {
<<<<<<< HEAD:MechLink/src/main/java/Main/TestClientScreen.java
        FXMLLoader fxmlLoader = new FXMLLoader(TestClientScreen.class.getResource("/Main/client-dashboard.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 665, 665);
        stage.setTitle("");
=======
        FXMLLoader fxmlLoader = new FXMLLoader(TestClientScreen.class.getResource("/View/client-dashboard.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 605, 665);
        stage.setTitle("Hello!");
>>>>>>> 0e5c89e058422698c9b433572fa281777522130e:MechLink/src/main/java/View/TestClientScreen.java
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}