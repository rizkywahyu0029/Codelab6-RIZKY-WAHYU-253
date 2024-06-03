module com.main.percobaan1 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.main.percobaan1 to javafx.fxml;
    exports com.main.percobaan1;
}