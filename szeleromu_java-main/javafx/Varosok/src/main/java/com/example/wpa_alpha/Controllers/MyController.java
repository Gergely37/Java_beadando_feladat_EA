package com.example.wpa_alpha.Controllers;

import com.example.wpa_alpha.Modells.*;
import com.example.wpa_alpha.RestClient.RESTc;
import com.example.wpa_alpha.Views.MainLayoutView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.hibernate.id.enhanced.InitialValueAwareOptimizer;

import java.io.IOException;

public class MyController{
    @FXML
    private AnchorPane MainPane;
    public void gotoAdatb(ActionEvent e) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/views/MainPane.fxml"));
        Parent AdatbView = loader.load();
        Scene ReportManagerScene = new Scene(AdatbView);
        Stage window = (Stage)MainPane.getScene().getWindow();
        window.setScene(ReportManagerScene);
        window.show();
    }
    public MyController(MainLayoutView view) {
        setView(view);
    }
    public void setView(MainLayoutView view) {
        String lelekszamURL = "src/main/java/com.example.wpa_alpha/models/lelekszam.txt";
        String megyeURL = "src/main/java/com.example.wpa_alpha/models/megye.txt";
        String varosURL = "src/main/java/com.example.wpa_alpha/models/varos.txt";
        RESTc fakeRestClient = new RESTc();

        for (int i = 0; i < view.getMenuBar().getMenus().size(); i++) {
            int finalI = i;
            for (int j = 0; j < view.getMenuBar().getMenus().get(i).getItems().size(); j++) {
                int finalJ = j;
                view.getMenuBar().getMenus().get(finalI).getItems().get(finalJ).setOnAction(actionEvent ->
                {
                    switch (view.getMenuBar().getMenus().get(finalI).getItems().get(finalJ).getId()){


                        case "rest1_read":
                            String fakeRestReadTitle = view.getMenuBar().getMenus().get(finalI).getText() + " - " + view.getMenuBar().getMenus().get(finalI).getItems().get(finalJ).getText() + " almenü";
                            String fakeRestReadTaskDescription = "Készítsen egy Restful klienst az eladáson bemutatott https://gorest.co.in Rest szerverhez, amely megvalósítja a Read műveletet(GET metódus)";
                            RestRead fakeRestReadModell = new RestRead(fakeRestReadTitle, fakeRestReadTaskDescription);
                            view.getMainFrameBP().setCenter(fakeRestReadModell.getContainer());
                            break;

                        case "rest1_write":
                            String fakeRestWriteTitle = view.getMenuBar().getMenus().get(finalI).getText() + " - " + view.getMenuBar().getMenus().get(finalI).getItems().get(finalJ).getText() + " almenü";
                            String fakeRestWriteTaskDescription = "Készítsen egy Restful klienst az eladáson bemutatott https://gorest.co.in Rest szerverhez, amely megvalósítja a Write műveletet(POST metódus)";
                            RestWrite fakeRestWriteModell = new RestWrite(fakeRestWriteTitle, fakeRestWriteTaskDescription);
                            view.getMainFrameBP().setCenter(fakeRestWriteModell.getContainer());
                            break;

                        case "rest1_modify":
                            String fakeRestModifyTitle = view.getMenuBar().getMenus().get(finalI).getText() + " - " + view.getMenuBar().getMenus().get(finalI).getItems().get(finalJ).getText() + " almenü";
                            String fakeRestModifyTaskDescription = "Készítsen egy Restful klienst az eladáson bemutatott https://gorest.co.in Rest szerverhez, amely megvalósítja a Modify műveletet(PUT metódus)";
                            RestMod fakeRestModifyModell = new RestMod(fakeRestModifyTitle, fakeRestModifyTaskDescription);
                            view.getMainFrameBP().setCenter(fakeRestModifyModell.getContainer());
                            break;

                        case "rest1_delete":
                            String fakeRestDeleteTitle = view.getMenuBar().getMenus().get(finalI).getText() + " - " + view.getMenuBar().getMenus().get(finalI).getItems().get(finalJ).getText() + " almenü";
                            String fakeRestDeleteTaskDescription = "Készítsen egy Restful klienst az eladáson bemutatott https://gorest.co.in Rest szerverhez, amely megvalósítja a Delete műveletet(DELETE metódus)";
                            RestDel fakeRestDeleteModell = new RestDel(fakeRestDeleteTitle, fakeRestDeleteTaskDescription);
                            view.getMainFrameBP().setCenter(fakeRestDeleteModell.getContainer());
                            break;
                    }
                    /*switch (view.getMenuBar().getMenus().get(finalI).getItems().get(finalJ).getId()) {
                        case "adatbazis":
                            String AdatbTaskTitle = view.getMenuBar().getMenus().get(finalI).getText()+" - "+ view.getMenuBar().getMenus().get(finalI).getItems().get(finalI).getText()+"adatbázis";
                            String AdatbTaskDesc = "Készítsen egy Restful klienst az eladáson bemutatott https://gorest.co.in Rest szerverhez, amely megvalósítja a Delete műveletet(DELETE metódus)";
                            Adatb AdatbTaskModell = new Adatb(AdatbTaskTitle, AdatbTaskDesc);
                            view.getMainFrameBP().setCenter(AdatbTaskModell.getContainer());
                            break;
                    }*/

                });
            }
        }
    }
}
