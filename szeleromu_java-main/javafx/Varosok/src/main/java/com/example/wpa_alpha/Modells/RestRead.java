package com.example.wpa_alpha.Modells;

import com.example.wpa_alpha.RestClient.RESTc;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import java.io.IOException;

public class RestRead {
    private VBox tableHolder;
    private VBox container;
    private Label title;
    private Label taskDescription;

    private VBox filterBox;

    public VBox getContainer() {return container;}

    public RestRead(String title, String taskDescription){
        createFilterBox();

        Label taskTitle = new Label("Feladat:");
        taskTitle.setFont(Font.font("Helvetica", FontWeight.EXTRA_BOLD, 14));
        taskTitle.setPadding(new Insets(0,0,5,20));

        this.tableHolder = new VBox();
        this.tableHolder.setAlignment(Pos.CENTER);
        this.container = new VBox();
        this.container.getChildren().addAll(this.title, taskTitle , this.taskDescription, this.filterBox);
    }

    public void createFilterBox(){
        Label mainTitle = new Label("Get kérés küldése:");
        Label description = new Label("A kérés elküdéséhez egy azonosító számot kell megadni! Ha nem megfelelő azonosítót adunk meg, hiba keletkezik, mivel egy olyan erőforrást akarunk elérni, ami nem létezik!");
        Label description2 = new Label("A könnyebb tesztelhetőség érdekében itt van néhány azonosító, amin lehet tesztelni: 100, 300, 3369, 6139");
        Label description3 = new Label("Nem létező azonosítót is meg lehet adni, de akkor hibaüzenetet kapunk, az erőforrás adatai helyett!");
        Label userIdLabel = new Label("Adjon meg egy azonosítót");
        Label alertIdError = new Label();
        Label response = new Label();
        alertIdError.setTextFill(Color.RED);
        alertIdError.setPadding(new Insets(5,0,5,0));
        description3.setPadding(new Insets(0,0,10,0));

        VBox getRequestBox = new VBox();
        TextField userIdTextfield = new TextField();
        userIdTextfield.setMaxWidth(200);
        this.filterBox = new VBox();
        Button sendRequestButton = new Button("Kérés küldése");
        sendRequestButton.setOnAction(actionEvent -> {
            alertIdError.setText("");
            if(isNumeric(userIdTextfield.getText())){
                try {
                    RESTc.GET(userIdTextfield.getText());
                    response.setText(RESTc.getGetResponseValue());

                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

            }else{
                alertIdError.setText("Számot kell megadni!");
            }
        });
    }

    public boolean isNumeric(String value){
        try {
            int number = Integer.parseInt(value);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
