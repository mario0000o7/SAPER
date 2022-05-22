package com.example.saper;

import java.util.TimerTask;

public class SegmentDisplayTimer {
    private boolean restart=false;
    private boolean wait = false;
    SegmentDisplayTimer() {
        java.util.Timer myRepeatingTimer = new java.util.Timer();
        myRepeatingTimer.scheduleAtFixedRate(new TimerTask(){
            int i = 0;
            @Override
            public void run(){
                if(restart)
                {
                    i=0;
                    restart=false;
                    wait = false;
                    Board.alive = true;
                    Board.firstMove = true;
                    Board.flagCount = 0;
                    Navbar.setHBoxGraphicBackground(Navbar.boxes[5], 0);
                    Navbar.setHBoxGraphicBackground(Navbar.boxes[4], 0);
                    Navbar.setHBoxGraphicBackground(Navbar.boxes[3],0);
                    Board.resetFlags();
                }

                if (i < 1000) {
                    Navbar.setHBoxGraphicBackground(Navbar.boxes[5], i % 10);
                    Navbar.setHBoxGraphicBackground(Navbar.boxes[4], (i / 10) % 10);
                    Navbar.setHBoxGraphicBackground(Navbar.boxes[3], (i / 100) % 10);
                } else {
                    wait = true;
                }
                if (!Board.firstMove && !wait)
                    i++;

            }
        }, 0, 1000);
    }

    public void setRestart(boolean restart) {
        this.restart = restart;
    }
    public void setWait(boolean wait) {this.wait = true;}
}
