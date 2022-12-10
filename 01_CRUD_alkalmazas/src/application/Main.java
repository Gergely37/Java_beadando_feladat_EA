package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Parent parent = (Parent) FXMLLoader.load(getClass().getResource(
                "/view/MainPane.fxml"));
        Scene scene = new Scene(parent);
        stage.setScene(scene);
        stage.setTitle("Varosok");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

class Launcher {
    public static void main(String[] args) {
        // Replace "Main" with the name of the class that extends Application
        // See https://stackoverflow.com/a/52654791/3956070 for explanation
        Main.main(args);
    }
}
