package BoebotProject.Hardware;

import TI.Servo;

public class Motor {
    private int pin;
    private Servo servo;
    private boolean inversed;

    public Motor(int pin, boolean inversed) {
        this.inversed = inversed;
        this.pin = pin;
        servo = new Servo(pin);
    }

    public void setSpeed(int speed) {
        // constraint
        // als speed kleiner dan -200
        // zet de var naar -200
        // als de speed groter dan 200
        // zet speed naar 200
        if(speed < -200) {
            speed = -200;
        }else if(speed > 200) {
            speed = 200;
        }

        // 0 = 1500
        // als servo inversed
        // speed * -1
        //
        //update servo 1500 + speed
        if(inversed) {
            speed *= -1;
        }

        servo.update(1500 + speed);
    }


}
