module com.ahmed.mechlink {
    requires javafx.controls;
    requires javafx.fxml;


    opens Main to javafx.fxml;
    opens Controlls to javafx.fxml;
    exports Main;
}