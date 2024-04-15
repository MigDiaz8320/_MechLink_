module com.ahmed.mechlink {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens Main to javafx.fxml;
    opens Controlls to javafx.fxml;
    exports Main;
}