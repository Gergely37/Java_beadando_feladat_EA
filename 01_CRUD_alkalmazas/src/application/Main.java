package application;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Parent parent = (Parent) FXMLLoader.load(Objects.requireNonNull(getClass().getResource(
                "/view/MainPane.fxml")));
        Scene scene = new Scene(parent);
        stage.setScene(scene);
        stage.setTitle("Varosok");
        stage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
