package com.example.saper;


import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.GridPane;

import java.util.Random;

public class Board {
    static Field[][] buttons = new Field[GameView.Size][GameView.Size];
    static GridPane gridpane = new GridPane();
    public static boolean firstMove = true;
    public static boolean alive = true;
    public static int flagCount = 0;

    public Board() {
        for (int i = 0; i < GameView.Size; i++) {
            for (int j = 0; j < GameView.Size; j++) {
                buttons[i][j] = new Field();
                buttons[i][j].button.setMinSize(32, 32);
                buttons[i][j].button.setMaxSize(32, 32);
                //buttons[i][j].bomb = false;
                int x = i;
                int y = j;
                buttons[i][j].button.setOnMouseClicked(mouseEvent -> {
                    if(mouseEvent.getButton() == MouseButton.PRIMARY) {
                        if(firstMove) {
                            //segmentDisplayTimer=new SegmentDisplayTimer();
                            firstMove = false;
                        }
                        if(alive)
                            check(x, y);
                    }
                    else if(mouseEvent.getButton() == MouseButton.SECONDARY){
                        if(alive)
                            flag(x, y);
                    }
                    if(checkForWin()){
                        alive = false;
                    }
                });//buttons[finalI][finalJ].setText("" + finalI + "," + finalJ));
                buttons[i][j].button.setGraphic(new ImageView(String.valueOf(getClass().getResource("img/background/before_click.gif"))));
                gridpane.add(buttons[i][j].button, i, j, 1, 1);
            }
        }
    }

    public static void resetFlags() {
        for(int i = 0; i < GameView.Size; i++){
            for(int l = 0; l < GameView.Size; l++){
                buttons[i][l].flag = false;
            }
        }
    }

    void generateBombs(int... bombsPlaced) {
        int bombs = 0;
        if (bombsPlaced.length > 0) {
            bombs = bombsPlaced[0];
        }

        Random random = new Random();
        for (int i = 0; i < GameView.Size; i++) {
            for (int j = 0; j < GameView.Size; j++) {
                if (random.nextBoolean() && random.nextBoolean() && random.nextBoolean() && random.nextBoolean() && !buttons[i][j].bomb) {
                    buttons[i][j].bomb = true;
                    //buttons[i][j].button.setText("X");
                    bombs++;
                }
                if (bombs == GameView.MAX_BOMBS)
                    return;
            }
        }
        if (bombs < GameView.MAX_BOMBS) {
            generateBombs(bombs);
        }
    }


    private void clearBombs() {
        for (int i = 0; i < GameView.Size; i++) {
            for (int l = 0; l < GameView.Size; l++) {
                buttons[i][l].bomb = false;
                //if(buttons[i][l].button.getText().equals("X")){
                //buttons[i][l].button.setText("");
                //}
            }
        }
        generateBombs();
    }

    private void check(int x, int y) {
        Field currentField = buttons[x][y];
        //System.out.println("FirstMove? " + firstMove);
        if (currentField.bomb && firstMove) {
            clearBombs();
        }
        firstMove = false;

        if(currentField.bomb){
            endGame(currentField);
        }
        else
            currentField.countBombs(x, y);


        /*if(currentField.bomb){
            currentField.button.setText("X");
        }*/

    }

    public boolean checkForWin() {
        boolean win = true;
        for(int i = 0; i < GameView.Size; i++){
            for(int l = 0; l < GameView.Size; l++){
                if (!buttons[i][l].checked && !buttons[i][l].bomb) {
                    win = false;
                    System.out.println(i + ", " + l + ", 1");
                }
                if(buttons[i][l].bomb && !buttons[i][l].flag){
                    win = false;
                    System.out.println(i + ", " + l + ", 2");
                }
            }
        }
        System.out.println(win);
        return win;
    }

    private void endGame(Field currentField) {
        for(int i = 0; i < GameView.Size; i++){
            for(int l = 0; l < GameView.Size; l++){
                if(buttons[i][l].bomb) {
                    buttons[i][l].button.setGraphic(new ImageView(String.valueOf(getClass().getResource("img/flags/this_bomb.gif"))));
                }
            }
        }
        alive = false;
    }

    private void flag(int x, int y){
        if(flagCount >= GameView.MAX_FLAGS && !buttons[x][y].flag)
            return;
        buttons[x][y].flag = !buttons[x][y].flag;
        if(buttons[x][y].flag) {
            buttons[x][y].button.setGraphic(new ImageView(String.valueOf(getClass().getResource("img/flags/flag.gif"))));
            flagCount++;
        }
        else {
            buttons[x][y].button.setGraphic(new ImageView(String.valueOf(getClass().getResource("img/background/before_click.gif"))));
            flagCount--;
        }
        if(buttons[x][y].flag) buttons[x][y].button.setGraphic(new ImageView(String.valueOf(getClass().getResource("img/flags/flag.gif"))));
    }

}
