package com.example.saper;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Cell;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Random;

public class HelloApplication extends Application {
    static int Size =10;
    //public static Pole[][] buttons =new Pole[8][8];

    @Override
    public void start(Stage stage) throws IOException {


        Navbar navbar = new Navbar();
        BorderPane border =new BorderPane();
        Plansza plansza = new Plansza();
        border.setTop(navbar.gridpane);
        border.setCenter(plansza.gridpane);
        plansza.generateBombs();
        Scene scene=new Scene(border,320,500);
        stage.setTitle("SAPER");
        stage.setScene(scene);
        stage.show();
    }



    public static void main(String[] args) {
        launch();
    }
}