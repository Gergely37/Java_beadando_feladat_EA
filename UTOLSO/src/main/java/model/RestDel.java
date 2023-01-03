package model;

import RC.RestClient;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import java.io.IOException;

public class RestDel {
    private VBox filterBox;
    public RestDel(String title, String taskDescription){
        createFilterBox();
    }

    public void createFilterBox(){
        Label mainTitle = new Label("Delete kérés küldése:");
        Label description = new Label("A kérés elküdéséhez egy azonosító számot kell megadni! Ha nem megfelelő azonosítót adunk meg, hiba keletkezik, mivel egy olyan erőforrást akarunk elérni, ami nem létezik!");
        Label description2 = new Label("A könnyebb tesztelhetőség érdekében itt van néhány azonosító, amin lehet tesztelni: 100, 300, 3369, 6139");
        Label description3 = new Label("Nem létező azonosítót is meg lehet adni, de akkor hibaüzenetet kapunk, az erőforrás adatai helyett!");
        Label mainTitle2 = new Label("Válasz a kérésre:");
        Label mainTitle3 = new Label("A adat tartalma:");

        Label userIdLabel = new Label("Adjon meg egy azonosítót");
        Label alertIdError = new Label();
        Label response = new Label();
        Label getResponse = new Label();
        alertIdError.setTextFill(Color.RED);

        VBox getRequestBox = new VBox();
        this.filterBox = new VBox();
        TextField userIdTextfield = new TextField();
        userIdTextfield.setMaxWidth(200);
        Button sendRequestButton = new Button("Kérés küldése");
        sendRequestButton.setOnAction(actionEvent -> {
            alertIdError.setText("");
            if(isNumeric(userIdTextfield.getText())){
                try {
                    RestClient.GET(userIdTextfield.getText());
                    getResponse.setText(RestClient.getGetResponseValue());

                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

                try {
                    RestClient.DELETE(userIdTextfield.getText());
                    response.setText(RestClient.getGetResponseValue() + "method: Delete");
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
