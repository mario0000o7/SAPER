package com.example.saper;

import javafx.application.Application;
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
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    static int Size =10;
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
        for (int i=0;i<Size;i++)
        {
            for (int j=0;j<Size;j++){
                buttons[i][j]=new Button();
                buttons[i][j].setMinHeight(32);
                buttons[i][j].setMinWidth(32);
                grid.add(buttons[i][j],i,j,1,1);
            }
        }
        border.setTop(navbar);
        border.setCenter(grid);


        Scene scene=new Scene(border,320,400);
        stage.setTitle("SAPER");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}