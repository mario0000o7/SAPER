package com.example.saper;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Random;

public class HelloApplication extends Application {
    public static Pole[][] buttons =new Pole[8][8];
    public static boolean firstMove = true;


    @Override
    public void start(Stage stage) throws IOException {
        GridPane grid=new GridPane();

        for (int i=0;i<8;i++)
        {
            for (int j=0;j<8;j++){
                buttons[i][j]=new Pole();
                buttons[i][j].button.setMinSize(32,32);
                buttons[i][j].button.setMaxSize(32,32);
                //buttons[i][j].bomba = false;
                int x = i;
                int y = j;
                buttons[i][j].button.setOnMouseClicked(mouseEvent -> sprawdz(x, y));//buttons[finalI][finalJ].setText("" + finalI + "," + finalJ));
                grid.add(buttons[i][j].button,i,j,1,1);
            }
        }
        generateBombs();

        Scene scene=new Scene(grid);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    private void generateBombs(int... bombsPlaced) {
        int bombs = 0;
        if(bombsPlaced.length > 0){
            bombs = bombsPlaced[0];
        }
        int MAX_BOMBS = 10;
        Random random = new Random();
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                if(bombs == MAX_BOMBS)
                    return;
                if(random.nextBoolean() && random.nextBoolean() && random.nextBoolean()){
                    buttons[i][j].bomba = true;
                    bombs++;
                }
            }
        }
        if(bombs < MAX_BOMBS){
            generateBombs(bombs);
        }
    }

    private void sprawdz(int x, int y) {
        Pole aktualnePole = buttons[x][y];
        if(aktualnePole.bomba && firstMove){
            clearBombs();
            firstMove = false;
        }

        aktualnePole.policzBomby(x, y);

        if(aktualnePole.bomba){
            aktualnePole.button.setText("X");
        }

    }

    private void clearBombs() {
        for(int i = 0; i < 8; i++){
            for(int l = 0; l < 8; l++){
                buttons[i][l].bomba = false;
            }
        }
        generateBombs();
    }

    public static void main(String[] args) {
        launch();
    }
}