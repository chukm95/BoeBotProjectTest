package BoebotProject.Hardware;

import TI.BoeBot;

public class LineFollower {
    private int pin;
    private boolean lineDetected;



    public LineFollower(int pin) {
        this.pin = pin;
    }

    public boolean detectLine() {
        if (BoeBot.analogRead(pin) > 50) {
            //System.out.println(BoeBot.analogRead(pin));
            return true;
        }
        return false;
    }



}
