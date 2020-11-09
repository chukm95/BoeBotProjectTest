package BoebotProject.Hardware;

import TI.BoeBot;

public class Ultrasoon {
    // Ultrasoon klasse HC-SR04

    private int triggerPin; //output triggerpin van hc-sr04 op pin 0
    private int echoPin; //input echopin van hc-sr04 op pin 1
    private int distance; //variabele voor de afstand tot de sensor
    private int duration; //variabale voor de duur

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

    //calculating the distance from sensor to object
    public void calculateDistance() {
        BoeBot.digitalWrite(triggerPin, true);
        BoeBot.wait(1);
        BoeBot.digitalWrite(triggerPin, false);

        this.duration = BoeBot.pulseIn(echoPin, true, 100000);
        this.distance = (int) ((duration * 0.0343) / 2);

        System.out.println("Distance: ");
        System.out.println(distance);

        BoeBot.wait(0, 500); // wacht 500 micro seconden
    }


}
