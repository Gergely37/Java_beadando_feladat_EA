package com.example.wpa_alpha.Views;

import com.example.wpa_alpha.Modells.MenuBlueprint;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

import java.util.HashMap;

public class MainLayoutView {
    private BorderPane mainFrameBP;
    private final MenuBar menuBar;
    private final Parent view;

    public MenuBar getMenuBar() {
        return menuBar;
    }

    //Getters
    public BorderPane getMainFrameBP() {
        return mainFrameBP;
    }

    public Parent getView() {
        return view;
    }

    //Constructor
    public MainLayoutView(){
        this.menuBar = createMenuBar();
        this.view = createBorderPane();
    }
    public BorderPane createBorderPane(){
        String firstPageTitle = "Java alkalmazások előadás beadandó!";
        this.mainFrameBP = new BorderPane();
        this.mainFrameBP.setTop(this.menuBar);
        this.mainFrameBP.setMinWidth(300);
        return this.mainFrameBP;
    }
    public MenuBar createMenuBar(){
        HashMap<String,HashMap<String,String>> menu = new HashMap<>();
        HashMap<String,String> dbMenuItem = new HashMap<>();
        HashMap<String,String> rest1MenuItem = new HashMap<>();
        HashMap<String,String> adatbazis = new HashMap<>();

        //Menu - Rest1
        //Rest1 - Almenük létrehozása
        rest1MenuItem.put("Olvas","rest1_read");
        rest1MenuItem.put("Ír","rest1_write");
        rest1MenuItem.put("Módosít","rest1_modify");
        rest1MenuItem.put("Töröl","rest1_delete");
        //Rest1 - Menupont létrehozása
        menu.put("Rest1", rest1MenuItem);

        adatbazis.put("Adatbázis", "adatbazis");
        menu.put("Adatbázis", dbMenuItem);

        MenuBlueprint menuBlueprint = new MenuBlueprint(menu);
        return menuBlueprint.getMenuBar();
    }

}
