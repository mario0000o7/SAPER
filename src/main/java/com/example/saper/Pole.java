package com.example.saper;

import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.image.ImageView;

public class Pole {
    boolean bomba;
    boolean checked = false;
    public Button button = new Button();

    public void policzBomby(int x, int y) {
        Pole pole = Plansza.buttons[x][y];
        int bombCount = 0;
        if (pole.checked)
            return;

        if (x > 0 && y > 0 && x < HelloApplication.Size - 1 && y < HelloApplication.Size - 1) {   //Inner buttons
            pole.checked = true;
            if (Plansza.buttons[x + 1][y].bomba)
                bombCount++;
            if (Plansza.buttons[x + 1][y + 1].bomba)
                bombCount++;
            if (Plansza.buttons[x + 1][y - 1].bomba)
                bombCount++;
            if (Plansza.buttons[x][y - 1].bomba)
                bombCount++;
            if (Plansza.buttons[x][y + 1].bomba)
                bombCount++;
            if (Plansza.buttons[x - 1][y].bomba)
                bombCount++;
            if (Plansza.buttons[x - 1][y + 1].bomba)
                bombCount++;
            if (Plansza.buttons[x - 1][y - 1].bomba)
                bombCount++;

            if (bombCount == 0 && !Plansza.buttons[x][y].bomba) {
                Plansza.buttons[x - 1][y - 1].policzBomby(x - 1, y - 1);
                Plansza.buttons[x - 1][y].policzBomby(x - 1, y);
                Plansza.buttons[x - 1][y + 1].policzBomby(x - 1, y + 1);
                Plansza.buttons[x][y - 1].policzBomby(x, y - 1);
                Plansza.buttons[x][y + 1].policzBomby(x, y + 1);
                Plansza.buttons[x + 1][y - 1].policzBomby(x + 1, y - 1);
                Plansza.buttons[x + 1][y].policzBomby(x + 1, y);
                Plansza.buttons[x + 1][y + 1].policzBomby(x + 1, y + 1);
            }
        } else if (x == 0 && y == 0) {                                  // Upper Left Corner
            pole.checked = true;
            if (Plansza.buttons[x + 1][y].bomba)
                bombCount++;
            if (Plansza.buttons[x + 1][y + 1].bomba)
                bombCount++;
            if (Plansza.buttons[x][y + 1].bomba)
                bombCount++;

            if (bombCount == 0 && !Plansza.buttons[x][y].bomba) {
                Plansza.buttons[x][y + 1].policzBomby(x, y + 1);
                Plansza.buttons[x + 1][y].policzBomby(x + 1, y);
                Plansza.buttons[x + 1][y + 1].policzBomby(x + 1, y + 1);
            }
        } else if (x == HelloApplication.Size - 1 && y == 0) {      //Upper Right Corner
            pole.checked = true;
            if (Plansza.buttons[x - 1][y].bomba)
                bombCount++;
            if (Plansza.buttons[x - 1][y + 1].bomba)
                bombCount++;
            if (Plansza.buttons[x][y + 1].bomba)
                bombCount++;

            if (bombCount == 0 && !Plansza.buttons[x][y].bomba) {
                Plansza.buttons[x - 1][y].policzBomby(x - 1, y);
                Plansza.buttons[x - 1][y + 1].policzBomby(x - 1, y + 1);
                Plansza.buttons[x][y + 1].policzBomby(x, y + 1);
            }
        } else if (x == 0 && y == HelloApplication.Size - 1) {      //Lower Left Corner
            pole.checked = true;
            if (Plansza.buttons[x + 1][y].bomba)
                bombCount++;
            if (Plansza.buttons[x + 1][y - 1].bomba)
                bombCount++;
            if (Plansza.buttons[x][y - 1].bomba)
                bombCount++;

            if (bombCount == 0 && !Plansza.buttons[x][y].bomba) {
                Plansza.buttons[x][y - 1].policzBomby(x, y - 1);
                Plansza.buttons[x + 1][y - 1].policzBomby(x + 1, y - 1);
                Plansza.buttons[x + 1][y].policzBomby(x + 1, y);
            }
        } else if (x == HelloApplication.Size - 1 && y == HelloApplication.Size - 1) {      //Lower Right Corner
            pole.checked = true;
            if (Plansza.buttons[x - 1][y].bomba)
                bombCount++;
            if (Plansza.buttons[x - 1][y - 1].bomba)
                bombCount++;
            if (Plansza.buttons[x][y - 1].bomba)
                bombCount++;

            if (bombCount == 0 && !Plansza.buttons[x][y].bomba) {
                Plansza.buttons[x - 1][y - 1].policzBomby(x - 1, y - 1);
                Plansza.buttons[x - 1][y].policzBomby(x - 1, y);
                Plansza.buttons[x][y - 1].policzBomby(x, y - 1);
            }
        } else if (x == 0 && y > 0 && y < HelloApplication.Size - 1) {      //Left Wall
            pole.checked = true;
            if (Plansza.buttons[x][y + 1].bomba)
                bombCount++;
            if (Plansza.buttons[x][y - 1].bomba)
                bombCount++;
            if (Plansza.buttons[x + 1][y - 1].bomba)
                bombCount++;
            if (Plansza.buttons[x + 1][y].bomba)
                bombCount++;
            if (Plansza.buttons[x + 1][y + 1].bomba)
                bombCount++;

            if (bombCount == 0 && !Plansza.buttons[x][y].bomba) {
                Plansza.buttons[x][y - 1].policzBomby(x, y - 1);
                Plansza.buttons[x][y + 1].policzBomby(x, y + 1);
                Plansza.buttons[x + 1][y - 1].policzBomby(x + 1, y - 1);
                Plansza.buttons[x + 1][y].policzBomby(x + 1, y);
                Plansza.buttons[x + 1][y + 1].policzBomby(x + 1, y + 1);
            }
        } else if (x == HelloApplication.Size - 1 && y > 0 && y < HelloApplication.Size - 1) {  //Right wall
            pole.checked = true;
            if (Plansza.buttons[x][y + 1].bomba)
                bombCount++;
            if (Plansza.buttons[x][y - 1].bomba)
                bombCount++;
            if (Plansza.buttons[x - 1][y - 1].bomba)
                bombCount++;
            if (Plansza.buttons[x - 1][y].bomba)
                bombCount++;
            if (Plansza.buttons[x - 1][y + 1].bomba)
                bombCount++;

            if (bombCount == 0 && !Plansza.buttons[x][y].bomba) {
                Plansza.buttons[x - 1][y - 1].policzBomby(x - 1, y - 1);
                Plansza.buttons[x - 1][y].policzBomby(x - 1, y);
                Plansza.buttons[x - 1][y + 1].policzBomby(x - 1, y + 1);
                Plansza.buttons[x][y - 1].policzBomby(x, y - 1);
                Plansza.buttons[x][y + 1].policzBomby(x, y + 1);
            }
        } else if (x > 0 && x < HelloApplication.Size - 1 && y == 0) {      //Top Wall
            pole.checked = true;
            if (Plansza.buttons[x - 1][y].bomba)
                bombCount++;
            if (Plansza.buttons[x + 1][y].bomba)
                bombCount++;
            if (Plansza.buttons[x - 1][y + 1].bomba)
                bombCount++;
            if (Plansza.buttons[x][y + 1].bomba)
                bombCount++;
            if (Plansza.buttons[x + 1][y + 1].bomba)
                bombCount++;

            if (bombCount == 0 && !Plansza.buttons[x][y].bomba) {
                Plansza.buttons[x - 1][y].policzBomby(x - 1, y);
                Plansza.buttons[x - 1][y + 1].policzBomby(x - 1, y + 1);
                Plansza.buttons[x][y + 1].policzBomby(x, y + 1);
                Plansza.buttons[x + 1][y].policzBomby(x + 1, y);
                Plansza.buttons[x + 1][y + 1].policzBomby(x + 1, y + 1);
            }
        } else if (x > 0 && x < HelloApplication.Size - 1 && y == HelloApplication.Size - 1) {  //Bottom Wall
            pole.checked = true;
            if (Plansza.buttons[x - 1][y].bomba)
                bombCount++;
            if (Plansza.buttons[x + 1][y].bomba)
                bombCount++;
            if (Plansza.buttons[x - 1][y - 1].bomba)
                bombCount++;
            if (Plansza.buttons[x][y - 1].bomba)
                bombCount++;
            if (Plansza.buttons[x + 1][y - 1].bomba)
                bombCount++;

            if (bombCount == 0 && !Plansza.buttons[x][y].bomba) {
                Plansza.buttons[x - 1][y - 1].policzBomby(x - 1, y - 1);
                Plansza.buttons[x - 1][y].policzBomby(x - 1, y);
                Plansza.buttons[x][y - 1].policzBomby(x, y - 1);
                Plansza.buttons[x + 1][y - 1].policzBomby(x + 1, y - 1);
                Plansza.buttons[x + 1][y].policzBomby(x + 1, y);
            }
        }
        if (pole.bomba) {
            pole.button.setGraphic(new ImageView(String.valueOf(getClass().getResource("img/flags/this_bomb.gif"))));
        } else {
            pole.button.setGraphic(new ImageView(String.valueOf(getClass().getResource("img/bombs_around/" + bombCount + ".gif"))));
        }
        pole.button.setDisable(true);
        pole.button.setOpacity(1.0);
    }
}
