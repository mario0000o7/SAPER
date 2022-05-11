package com.example.saper;


import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

import java.util.Random;

public class Plansza {
    static Pole[][] buttons =new Pole[HelloApplication.Size][HelloApplication.Size];
    static GridPane gridpane = new GridPane();
    public static boolean firstMove = true;
    public Plansza() {
        for (int i=0;i<HelloApplication.Size;i++) {
            for (int j=0;j<HelloApplication.Size;j++){
                buttons[i][j]=new Pole();
                buttons[i][j].button.setMinSize(32,32);
                buttons[i][j].button.setMaxSize(32,32);
                //buttons[i][j].bomba = false;
                int x = i;
                int y = j;
                buttons[i][j].button.setOnMouseClicked(mouseEvent -> sprawdz(x, y));//buttons[finalI][finalJ].setText("" + finalI + "," + finalJ));
                gridpane.add(buttons[i][j].button,i,j,1,1);
            }
        }
    }
    void generateBombs(int... bombsPlaced) {
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



    private void clearBombs() {
        for(int i = 0; i < 8; i++){
            for(int l = 0; l < 8; l++){
                buttons[i][l].bomba = false;
            }
        }
        generateBombs();
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
}
