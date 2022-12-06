package com.example.wpa_alpha;

import com.example.wpa_alpha.Controllers.MyController;

import com.example.wpa_alpha.Views.MainLayoutView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class WindPowerApplicaton extends Application {
    @Override
    public void start(Stage stage){
        MainLayoutView mainLayoutView = new MainLayoutView();
        MyController mainLayoutController = new MyController(mainLayoutView);
        Scene scene = new Scene(mainLayoutView.getView(), 1280, 720);
        stage.setTitle("Varosok");
        stage.setScene(scene);
        stage.setMinWidth(260);
        stage.setMinHeight(400);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}