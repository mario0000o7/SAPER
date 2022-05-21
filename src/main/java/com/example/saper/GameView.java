package com.example.saper;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.io.IOException;

public class GameView extends Application {
    static int Size = 8;

    @Override
    public void start(Stage stage) throws IOException {


        Navbar navbar = new Navbar();
        BorderPane border = new BorderPane();
        Board board = new Board();
        border.setTop(navbar.gridpane);
        border.setCenter(Board.gridpane);
        board.generateBombs();
        Scene scene = new Scene(border, 256, 310);
        stage.setTitle("SAPER");
        stage.setScene(scene);
        stage.show();
    }


    public static void main(String[] args) {
        launch();
    }
}