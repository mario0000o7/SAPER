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
    public static Pole[][] buttons =new Pole[8][8];
    public static boolean firstMove = true;
    @Override
    public void start(Stage stage) throws IOException {
        GridPane navbar=new GridPane();
        HBox[] boxes=new HBox[3];
        boxes[0]=new HBox();
        boxes[0].setMinHeight(26);
        boxes[0].setMinWidth(100);
        boxes[0].setBackground(new Background(new BackgroundFill(Color.BLACK,CornerRadii.EMPTY, Insets.EMPTY)));
        Button navbarbutton=new Button();
        navbarbutton.setMinWidth(10);
        navbarbutton.setMinHeight(10);
        navbar.add(boxes[0],0,0);
        navbar.add(navbarbutton,1,0);
        boxes[2]=new HBox();
        boxes[2].setMinHeight(26);
        boxes[2].setMinWidth(100);
        boxes[2].setBackground(new Background(new BackgroundFill(Color.BLACK,CornerRadii.EMPTY, Insets.EMPTY)));

        navbar.add(boxes[2],2,0);
        navbar.setMinWidth(320);
        navbar.setHgap(50);
        navbar.setAlignment(Pos.CENTER);
        GridPane grid=new GridPane();

        navbar.setBackground(new Background(new BackgroundFill(Color.YELLOW,CornerRadii.EMPTY,Insets.EMPTY)));
        Button[][] buttons =new Button[Size][Size];
        BorderPane border =new BorderPane();
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
        border.setTop(navbar);
        border.setCenter(grid);
        generateBombs();

        Scene scene=new Scene(border,320,400);
        stage.setTitle("SAPER");
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