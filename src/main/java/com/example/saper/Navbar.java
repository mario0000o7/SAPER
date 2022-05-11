package com.example.saper;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public class Navbar  {
    GridPane gridpane = new GridPane();
    HBox[] boxes = new HBox[2];
    Navbar() {
        for (int i = 0,j=0; i < 2; i++,j+=2) {
            boxes[i] = new HBox();
            boxes[i].setMinHeight(26);
            boxes[i].setMinWidth(100);
            boxes[i].setBackground(new Background(new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY)));
            gridpane.add(boxes[i], j, 0);
        }
        Button navbarbutton = new Button();
        navbarbutton.setMinWidth(10);
        navbarbutton.setMinHeight(10);
        gridpane.add(navbarbutton, 1, 0);
        gridpane.setMinWidth(320);
        gridpane.setHgap(50);
        gridpane.setAlignment(Pos.CENTER);
        gridpane.setBackground(new Background(new BackgroundFill(Color.YELLOW, CornerRadii.EMPTY, Insets.EMPTY)));
    }
}
