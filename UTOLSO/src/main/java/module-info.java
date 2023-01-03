module com.example.utolso {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires org.hibernate.orm.core;


    opens application to javafx.fxml;
    exports application;
    exports controller;
    opens controller to javafx.fxml;
}