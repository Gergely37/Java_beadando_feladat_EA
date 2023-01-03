
package application;

import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.Objects;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    public Main() {
    }

    public void start(Stage stage) throws Exception {
        Parent parent = (Parent)FXMLLoader.load((URL)Objects.requireNonNull(this.getClass().getResource("/view/MainPane.fxml")));
        Scene scene = new Scene(parent);
        stage.setScene(scene);
        stage.setTitle("Varosok");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
