module com.ahmed.mechlink {
    requires javafx.controls;
    requires javafx.fxml;


    opens View to javafx.fxml;
    opens Controlls to javafx.fxml;
    exports View;
}