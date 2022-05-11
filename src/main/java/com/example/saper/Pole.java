package com.example.saper;

import javafx.scene.control.Button;

public class Pole {
    boolean bomba;
    public Button button = new Button();

    public void policzBomby(int x, int y){
        Pole pole = HelloApplication.buttons[x][y];
        int bombCount = 0;
        if(x > 0 && y > 0 && x < 7 && y < 7){
            if(HelloApplication.buttons[x + 1][y].bomba)
                bombCount++;
            if(HelloApplication.buttons[x + 1][y + 1].bomba)
                bombCount++;
            if(HelloApplication.buttons[x + 1][y - 1].bomba)
                bombCount++;
            if(HelloApplication.buttons[x][y - 1].bomba)
                bombCount++;
            if(HelloApplication.buttons[x][y + 1].bomba)
                bombCount++;
            if(HelloApplication.buttons[x - 1][y].bomba)
                bombCount++;
            if(HelloApplication.buttons[x - 1][y + 1].bomba)
                bombCount++;
            if(HelloApplication.buttons[x - 1][y - 1].bomba)
                bombCount++;

            pole.button.setText("" + bombCount);
            return;
        }
        else if(x == 0 && y == 0){
            if(HelloApplication.buttons[x + 1][y].bomba)
                bombCount++;
            if(HelloApplication.buttons[x + 1][y + 1].bomba)
                bombCount++;
            if(HelloApplication.buttons[x][y + 1].bomba)
                bombCount++;

            pole.button.setText("" + bombCount);
            return;
        }
        else if(x == 7 && y == 0){
            if(HelloApplication.buttons[x - 1][y].bomba)
                bombCount++;
            if(HelloApplication.buttons[x - 1][y + 1].bomba)
                bombCount++;
            if(HelloApplication.buttons[x][y + 1].bomba)
                bombCount++;

            pole.button.setText("" + bombCount);
            return;
        }
        else if(x == 0 && y == 7){
            if(HelloApplication.buttons[x + 1][y].bomba)
                bombCount++;
            if(HelloApplication.buttons[x + 1][y - 1].bomba)
                bombCount++;
            if(HelloApplication.buttons[x][y - 1].bomba)
                bombCount++;

            pole.button.setText("" + bombCount);
            return;
        }
    }
}
