package com.example.saper;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Control;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class GameView extends Application {
    final static int SIZE = 8;
    final static int MAX_BOMBS = 25;
    final static int MAX_FLAGS = MAX_BOMBS;
    final String TITLE = "SAPER";
    private static Board board;
    private static Navbar navbar;
    private static Scene scene;
    private static BorderPane border;
    private static SegmentDisplayTimer segmentDisplayTimer;

    @Override
    public void start(Stage stage) throws IOException {
        navbar = new Navbar();
        border = new BorderPane();
        board = new Board();
        border.setTop(navbar.gridpane);
        border.setCenter(Board.gridpane);
        Board.generateBombs();
        segmentDisplayTimer = new SegmentDisplayTimer();
        scene = new Scene(border, Control.USE_COMPUTED_SIZE, Control.USE_COMPUTED_SIZE);
        stage.setTitle(TITLE);
        stage.setScene(scene);
        stage.show();
    }

    public void stop(){
        segmentDisplayTimer.getMyRepeatingTimer().cancel();
    }


    public static void setBoard(Board board) {
        GameView.board = board;
    }

    public static SegmentDisplayTimer getSegmentDisplayTimer() {
        return segmentDisplayTimer;
    }

    public static void setSegmentDisplayTimer(SegmentDisplayTimer segmentDisplayTimer) {
        GameView.segmentDisplayTimer = segmentDisplayTimer;
    }
}



