package com.example.saper;

import javafx.scene.control.Button;
import javafx.scene.image.ImageView;

public class Field {
    boolean bomb;
    boolean checked = false;
    public Button button = new Button();
    boolean flag;

    public void countBombs(int x, int y) {
        Field field = Board.buttons[x][y];
        int bombCount = 0;
        if (field.checked)
            return;
        if (x > 0 && y > 0 && x < GameView.Size - 1 && y < GameView.Size - 1) {   //Inner buttons
            field.checked = true;
            if (Board.buttons[x + 1][y].bomb)
                bombCount++;
            if (Board.buttons[x + 1][y + 1].bomb)
                bombCount++;
            if (Board.buttons[x + 1][y - 1].bomb)
                bombCount++;
            if (Board.buttons[x][y - 1].bomb)
                bombCount++;
            if (Board.buttons[x][y + 1].bomb)
                bombCount++;
            if (Board.buttons[x - 1][y].bomb)
                bombCount++;
            if (Board.buttons[x - 1][y + 1].bomb)
                bombCount++;
            if (Board.buttons[x - 1][y - 1].bomb)
                bombCount++;

            if (bombCount == 0 && !Board.buttons[x][y].bomb) {
                Board.buttons[x - 1][y - 1].countBombs(x - 1, y - 1);
                Board.buttons[x - 1][y].countBombs(x - 1, y);
                Board.buttons[x - 1][y + 1].countBombs(x - 1, y + 1);
                Board.buttons[x][y - 1].countBombs(x, y - 1);
                Board.buttons[x][y + 1].countBombs(x, y + 1);
                Board.buttons[x + 1][y - 1].countBombs(x + 1, y - 1);
                Board.buttons[x + 1][y].countBombs(x + 1, y);
                Board.buttons[x + 1][y + 1].countBombs(x + 1, y + 1);
            }
        } else if (x == 0 && y == 0) {                                  // Upper Left Corner
            field.checked = true;
            if (Board.buttons[x + 1][y].bomb)
                bombCount++;
            if (Board.buttons[x + 1][y + 1].bomb)
                bombCount++;
            if (Board.buttons[x][y + 1].bomb)
                bombCount++;

            if (bombCount == 0 && !Board.buttons[x][y].bomb) {
                Board.buttons[x][y + 1].countBombs(x, y + 1);
                Board.buttons[x + 1][y].countBombs(x + 1, y);
                Board.buttons[x + 1][y + 1].countBombs(x + 1, y + 1);
            }
        } else if (x == GameView.Size - 1 && y == 0) {      //Upper Right Corner
            field.checked = true;
            if (Board.buttons[x - 1][y].bomb)
                bombCount++;
            if (Board.buttons[x - 1][y + 1].bomb)
                bombCount++;
            if (Board.buttons[x][y + 1].bomb)
                bombCount++;

            if (bombCount == 0 && !Board.buttons[x][y].bomb) {
                Board.buttons[x - 1][y].countBombs(x - 1, y);
                Board.buttons[x - 1][y + 1].countBombs(x - 1, y + 1);
                Board.buttons[x][y + 1].countBombs(x, y + 1);
            }
        } else if (x == 0 && y == GameView.Size - 1) {      //Lower Left Corner
            field.checked = true;
            if (Board.buttons[x + 1][y].bomb)
                bombCount++;
            if (Board.buttons[x + 1][y - 1].bomb)
                bombCount++;
            if (Board.buttons[x][y - 1].bomb)
                bombCount++;

            if (bombCount == 0 && !Board.buttons[x][y].bomb) {
                Board.buttons[x][y - 1].countBombs(x, y - 1);
                Board.buttons[x + 1][y - 1].countBombs(x + 1, y - 1);
                Board.buttons[x + 1][y].countBombs(x + 1, y);
            }
        } else if (x == GameView.Size - 1 && y == GameView.Size - 1) {      //Lower Right Corner
            field.checked = true;
            if (Board.buttons[x - 1][y].bomb)
                bombCount++;
            if (Board.buttons[x - 1][y - 1].bomb)
                bombCount++;
            if (Board.buttons[x][y - 1].bomb)
                bombCount++;

            if (bombCount == 0 && !Board.buttons[x][y].bomb) {
                Board.buttons[x - 1][y - 1].countBombs(x - 1, y - 1);
                Board.buttons[x - 1][y].countBombs(x - 1, y);
                Board.buttons[x][y - 1].countBombs(x, y - 1);
            }
        } else if (x == 0 && y > 0 && y < GameView.Size - 1) {      //Left Wall
            field.checked = true;
            if (Board.buttons[x][y + 1].bomb)
                bombCount++;
            if (Board.buttons[x][y - 1].bomb)
                bombCount++;
            if (Board.buttons[x + 1][y - 1].bomb)
                bombCount++;
            if (Board.buttons[x + 1][y].bomb)
                bombCount++;
            if (Board.buttons[x + 1][y + 1].bomb)
                bombCount++;

            if (bombCount == 0 && !Board.buttons[x][y].bomb) {
                Board.buttons[x][y - 1].countBombs(x, y - 1);
                Board.buttons[x][y + 1].countBombs(x, y + 1);
                Board.buttons[x + 1][y - 1].countBombs(x + 1, y - 1);
                Board.buttons[x + 1][y].countBombs(x + 1, y);
                Board.buttons[x + 1][y + 1].countBombs(x + 1, y + 1);
            }
        } else if (x == GameView.Size - 1 && y > 0 && y < GameView.Size - 1) {  //Right wall
            field.checked = true;
            if (Board.buttons[x][y + 1].bomb)
                bombCount++;
            if (Board.buttons[x][y - 1].bomb)
                bombCount++;
            if (Board.buttons[x - 1][y - 1].bomb)
                bombCount++;
            if (Board.buttons[x - 1][y].bomb)
                bombCount++;
            if (Board.buttons[x - 1][y + 1].bomb)
                bombCount++;

            if (bombCount == 0 && !Board.buttons[x][y].bomb) {
                Board.buttons[x - 1][y - 1].countBombs(x - 1, y - 1);
                Board.buttons[x - 1][y].countBombs(x - 1, y);
                Board.buttons[x - 1][y + 1].countBombs(x - 1, y + 1);
                Board.buttons[x][y - 1].countBombs(x, y - 1);
                Board.buttons[x][y + 1].countBombs(x, y + 1);
            }
        } else if (x > 0 && x < GameView.Size - 1 && y == 0) {      //Top Wall
            field.checked = true;
            if (Board.buttons[x - 1][y].bomb)
                bombCount++;
            if (Board.buttons[x + 1][y].bomb)
                bombCount++;
            if (Board.buttons[x - 1][y + 1].bomb)
                bombCount++;
            if (Board.buttons[x][y + 1].bomb)
                bombCount++;
            if (Board.buttons[x + 1][y + 1].bomb)
                bombCount++;

            if (bombCount == 0 && !Board.buttons[x][y].bomb) {
                Board.buttons[x - 1][y].countBombs(x - 1, y);
                Board.buttons[x - 1][y + 1].countBombs(x - 1, y + 1);
                Board.buttons[x][y + 1].countBombs(x, y + 1);
                Board.buttons[x + 1][y].countBombs(x + 1, y);
                Board.buttons[x + 1][y + 1].countBombs(x + 1, y + 1);
            }
        } else if (x > 0 && x < GameView.Size - 1 && y == GameView.Size - 1) {  //Bottom Wall
            field.checked = true;
            if (Board.buttons[x - 1][y].bomb)
                bombCount++;
            if (Board.buttons[x + 1][y].bomb)
                bombCount++;
            if (Board.buttons[x - 1][y - 1].bomb)
                bombCount++;
            if (Board.buttons[x][y - 1].bomb)
                bombCount++;
            if (Board.buttons[x + 1][y - 1].bomb)
                bombCount++;

            if (bombCount == 0 && !Board.buttons[x][y].bomb) {
                Board.buttons[x - 1][y - 1].countBombs(x - 1, y - 1);
                Board.buttons[x - 1][y].countBombs(x - 1, y);
                Board.buttons[x][y - 1].countBombs(x, y - 1);
                Board.buttons[x + 1][y - 1].countBombs(x + 1, y - 1);
                Board.buttons[x + 1][y].countBombs(x + 1, y);
            }
        }
        if (field.bomb) {
            field.button.setGraphic(new ImageView(String.valueOf(getClass().getResource("img/flags/this_bomb.gif"))));
        } else {
            field.button.setGraphic(new ImageView(String.valueOf(getClass().getResource("img/bombs_around/" + bombCount + ".gif"))));
        }
        field.button.setDisable(true);
        field.button.setOpacity(1.0);
    }
}
