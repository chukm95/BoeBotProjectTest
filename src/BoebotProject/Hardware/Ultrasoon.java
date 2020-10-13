package BoebotProject.Hardware;

import TI.BoeBot;

public class Ultrasoon {
    // Ultrasoon HC-SR04

    private int triggerPin;
    private int echoPin;
    private int distance;

    public Ultrasoon(int triggerPin, int echoPin) {
        this.triggerPin = triggerPin;
        this.echoPin = echoPin;
    }


    public void updateUltrasoon() {
        BoeBot.digitalWrite(triggerPin, true);
        BoeBot.wait(1);

        BoeBot.digitalWrite(triggerPin, false);

        this.distance = BoeBot.pulseIn(echoPin, true, 10000);
    }

    public int getDistance() {
        return distance;
    }
}
