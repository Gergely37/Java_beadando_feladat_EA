module com.example.beadando_ea {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.beadando_ea to javafx.fxml;
    exports com.example.beadando_ea;
}