package com.example.saper;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public class Navbar {
    static final int BUTTON_SIZE = 32;
    public static HBox[] boxes = new HBox[8];
    public static Button navbarbutton = new Button();
    final int HBOX_HEIGHT = 52;
    final int HBOX_WIDTH = 30;
    final int NAVBAR_BUTTON = 52;
    GridPane gridpane = new GridPane();

    Navbar() {
        for (int i = 0, j = 0; i < 6; i++) {
            boxes[i] = new HBox();
            boxes[i].setMinHeight(HBOX_HEIGHT);
            boxes[i].setMinWidth(HBOX_WIDTH);
            boxes[i].setMaxWidth(HBOX_WIDTH);
            gridpane.add(boxes[i], j, 0);
            setHBoxGraphicBackground(boxes[i], 0);
            if (j == 2) {
                j += 4;
            } else {
                j++;
            }
        }
        setFlagDisplay(GameView.MAX_FLAGS);
        for (int i = 6, j = 3; i < 8; i++, j += 2) {
            boxes[i] = new HBox();
            boxes[i].setMinHeight(HBOX_HEIGHT);
            int a = GameView.SIZE * BUTTON_SIZE - 6 * HBOX_WIDTH - NAVBAR_BUTTON;
            boxes[i].setMinWidth((float) a / 2);
            gridpane.add(boxes[i], j, 0);
            boxes[i].setBackground(new Background(new BackgroundFill(Color.web("#c0c0c0"),
                    CornerRadii.EMPTY,
                    Insets.EMPTY)));
        }
        navbarbutton.setMinWidth(NAVBAR_BUTTON);
        navbarbutton.setMaxWidth(NAVBAR_BUTTON);
        navbarbutton.setMinHeight(NAVBAR_BUTTON);
        navbarbutton.setMaxHeight(NAVBAR_BUTTON);
        navbarbutton.setGraphic(new ImageView(String.valueOf(getClass().getResource("img/reset_button/smile.gif"))));
        navbarbutton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                GameView.getSegmentDisplayTimer().setRestart(true);
                Board.firstMove = true;
                GameView.setBoard(new Board());
                setFlagDisplay(GameView.MAX_FLAGS);
                navbarbutton.setGraphic(new ImageView(String.valueOf(getClass().getResource("img/reset_button/smile.gif"))));
                Board.generateBombs();
            }
        });
        gridpane.add(navbarbutton, 4, 0);
        gridpane.setAlignment(Pos.BASELINE_LEFT);
    }

    public static void setHBoxGraphicBackground(HBox box, int whichSegmentDigit) {
        BackgroundImage image = new BackgroundImage(new Image(String.valueOf(Navbar.class.getResource("img/digits/" + whichSegmentDigit + ".gif"))),
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);
        box.setBackground(new Background(image));
    }

    public static void setFlagDisplay(int number) {
        if (number < 1000) {
            setHBoxGraphicBackground(boxes[2], number % 10);
            setHBoxGraphicBackground(boxes[1], (number / 10) % 10);
            setHBoxGraphicBackground(boxes[0], (number / 100) % 10);
        }
    }
}
