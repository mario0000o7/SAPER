package com.example.saper;


import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.GridPane;

import java.util.Random;

public class Board {
    public static boolean firstMove = true;
    public static boolean alive = true;
    public static int flagCount = 0;
    static Field[][] buttons = new Field[GameView.SIZE][GameView.SIZE];
    static GridPane gridpane = new GridPane();

    public Board() {
        for (int i = 0; i < GameView.SIZE; i++) {
            for (int j = 0; j < GameView.SIZE; j++) {
                buttons[i][j] = new Field();
                buttons[i][j].button.setMinSize(Navbar.BUTTON_SIZE, Navbar.BUTTON_SIZE);
                buttons[i][j].button.setMaxSize(Navbar.BUTTON_SIZE, Navbar.BUTTON_SIZE);
                int x = i;
                int y = j;
                buttons[i][j].button.setOnMouseClicked(mouseEvent -> {
                    if (mouseEvent.getButton() == MouseButton.PRIMARY) {
                        if (alive)
                            check(x, y);
                    } else if (mouseEvent.getButton() == MouseButton.SECONDARY) {
                        if (alive)
                            flag(x, y);
                    }
                    if (checkForWin()) {
                        Navbar.navbarbutton.setGraphic(new ImageView(String.valueOf(getClass().getResource("img/reset_button/wow.gif"))));
                        GameView.getSegmentDisplayTimer().setWait(true);
                        alive = false;
                    }
                });
                buttons[i][j].button.setGraphic(new ImageView(String.valueOf(getClass().getResource("img/background/before_click.gif"))));
                gridpane.add(buttons[i][j].button, i, j, 1, 1);
            }
        }
    }

    public static void resetFlags() {
        for (int i = 0; i < GameView.SIZE; i++) {
            for (int l = 0; l < GameView.SIZE; l++) {
                buttons[i][l].setFlag(false);
            }
        }
    }

    static void generateBombs(int... bombsPlaced) {
        int bombs = 0;
        if (bombsPlaced.length > 0) {
            bombs = bombsPlaced[0];
        }

        Random random = new Random();
        for (int i = 0; i < GameView.SIZE; i++) {
            for (int j = 0; j < GameView.SIZE; j++) {
                if (random.nextBoolean() && random.nextBoolean() && random.nextBoolean() && random.nextBoolean() && !buttons[i][j].isBomb()) {
                    buttons[i][j].setBomb(true);
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


    private static void clearBombs() {
        for (int i = 0; i < GameView.SIZE; i++) {
            for (int l = 0; l < GameView.SIZE; l++) {
                buttons[i][l].setBomb(false);
            }
        }
        generateBombs();
    }

    public static void resetGame() {
        resetFlags();
        clearBombs();
        alive = true;
        firstMove = true;
    }

    private void check(int x, int y) {
        Field currentField = buttons[x][y];
        while (currentField.isBomb() && firstMove) {
            clearBombs();
        }
        firstMove = false;
        if (currentField.isBomb()) {
            endGame(x, y);
        } else
            currentField.countBombs(x, y);
    }

    public boolean checkForWin() {
        boolean win = true;
        for (int i = 0; i < GameView.SIZE; i++) {
            for (int l = 0; l < GameView.SIZE; l++) {
                if (!buttons[i][l].isChecked() && !buttons[i][l].isBomb()) {
                    win = false;
                    System.out.println(i + ", " + l + ", 1");
                }
                if (buttons[i][l].isBomb() && !buttons[i][l].isFlag()) {
                    win = false;
                    System.out.println(i + ", " + l + ", 2");
                }
            }
        }
        System.out.println(win);
        return win;
    }

    private void endGame(int x, int y) {
        Navbar.navbarbutton.setGraphic(new ImageView(String.valueOf(getClass().getResource("img/reset_button/game_over.gif"))));
        for (int i = 0; i < GameView.SIZE; i++) {
            for (int l = 0; l < GameView.SIZE; l++) {
                if (i == x && l == y) {
                    buttons[i][l].button.setGraphic(new ImageView(String.valueOf(getClass().getResource("img/flags/this_bomb.gif"))));
                    continue;
                }
                if (buttons[i][l].isBomb()) {
                    buttons[i][l].button.setGraphic(new ImageView(String.valueOf(getClass().getResource("img/flags/other_bomb.gif"))));
                }
            }
        }
        alive = false;
        GameView.getSegmentDisplayTimer().setWait(true);
    }

    private void flag(int x, int y) {
        if (flagCount >= GameView.MAX_FLAGS && !buttons[x][y].isFlag())
            return;
        buttons[x][y].setFlag(!buttons[x][y].isFlag());
        if (buttons[x][y].isFlag()) {
            buttons[x][y].button.setGraphic(new ImageView(String.valueOf(getClass().getResource("img/flags/flag.gif"))));
            flagCount++;
            Navbar.setFlagDisplay(GameView.MAX_FLAGS - flagCount);
        } else {
            buttons[x][y].button.setGraphic(new ImageView(String.valueOf(getClass().getResource("img/background/before_click.gif"))));
            flagCount--;
            Navbar.setFlagDisplay(GameView.MAX_FLAGS - flagCount);
        }
        if (buttons[x][y].isFlag())
            buttons[x][y].button.setGraphic(new ImageView(String.valueOf(getClass().getResource("img/flags/flag.gif"))));
    }

}
