package com.example.saper;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public class Navbar {
    GridPane gridpane = new GridPane();
    public static HBox[] boxes = new HBox[8];
    public static void setHBoxGraphicBackground(HBox box, int whichDigit) {
        BackgroundImage image = new BackgroundImage(new Image(String.valueOf(Navbar.class.getResource("img/digits/" + whichDigit + ".gif"))),
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);
        box.setBackground(new Background(image));
    }
    Navbar() {
        for (int i = 0, j = 0; i < 6; i++) {
            boxes[i] = new HBox();
            boxes[i].setMinHeight(52);
            boxes[i].setMinWidth(30);
            boxes[i].setMaxWidth(30);
            gridpane.add(boxes[i], j, 0);
            setHBoxGraphicBackground(boxes[i], 0);
            if(j == 2) {
                j += 4;
            } else {
                j++;
            }
        }
        for (int i = 6, j = 3; i < 8; i++, j += 2) {
            boxes[i] = new HBox();
            boxes[i].setMinHeight(52);
            int a=GameView.Size*32-6*30-52;
            boxes[i].setMinWidth((float) a /2);
            boxes[i].setMaxWidth(12);
            gridpane.add(boxes[i], j, 0);
            boxes[i].setBackground(new Background(new BackgroundFill(Color.web("#c0c0c0"),
                    CornerRadii.EMPTY,
                    Insets.EMPTY)));
        }
        Button navbarbutton = new Button();
        navbarbutton.setMinWidth(52);
        navbarbutton.setMaxWidth(52);
        navbarbutton.setMinHeight(52);
        navbarbutton.setMaxHeight(52);
        navbarbutton.setGraphic(new ImageView(String.valueOf(getClass().getResource("img/reset_button/smile.gif"))));
        gridpane.add(navbarbutton, 4, 0);
        gridpane.setMinWidth(320);
        //gridpane.setHgap(12);
        gridpane.setAlignment(Pos.BASELINE_LEFT);
        gridpane.setBackground(new Background(new BackgroundFill(Color.YELLOW, CornerRadii.EMPTY, Insets.EMPTY)));
    }
}
