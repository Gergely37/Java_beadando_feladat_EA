module com.example.f01 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.f01 to javafx.fxml;
    exports com.example.f01;
}