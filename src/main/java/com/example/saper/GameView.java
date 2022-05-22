package com.example.saper;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Control;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ResourceBundle;

public class GameView extends Application {
    static int Size = 20;
    static int MAX_BOMBS = 45;

    @Override
    public void start(Stage stage) throws IOException {
        Navbar navbar = new Navbar();
        BorderPane border = new BorderPane();
        Board board = new Board();
        border.setTop(navbar.gridpane);
        border.setCenter(Board.gridpane);
        board.generateBombs();
        Scene scene = new Scene(border, Control.USE_COMPUTED_SIZE, Control.USE_COMPUTED_SIZE);
        stage.setTitle("SAPER");
        stage.setScene(scene);
        stage.show();
    }


    public static void main(String[] args) {
        launch();
    }
}