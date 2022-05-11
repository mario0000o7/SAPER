package com.example.saper;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        GridPane grid=new GridPane();
        Button[][] buttons =new Button[8][8];
        for (int i=0;i<8;i++)
        {
            for (int j=0;j<8;j++){
                buttons[i][j]=new Button();
                grid.add(buttons[i][j],i,j,1,1);
            }
        }


        Scene scene=new Scene(grid);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}