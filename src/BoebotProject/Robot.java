package BoebotProject;

import BoebotProject.Behaviors.*;
import BoebotProject.Hardware.LineFollower;
import BoebotProject.Hardware.Motor;
import TI.BoeBot;

import javax.sound.midi.MidiChannel;
import java.util.ArrayList;

public class Robot {

    private static Robot instance;

    public static Robot GetInstance()
    {
        if(instance == null){
            instance = new Robot();
        }
        return instance;
    }

    private long currentTime, previousTime;

    public static final int LEFT_S = 0;
    public static final int MID_S = 1;
    public static final int RIGHT_S = 2;

    private boolean[] lf_detections;

    private Motor motorLinks;
    private Motor motorRechts;

    private LineFollower lLineFollower;
    private LineFollower cLineFollower;
    private LineFollower rLineFollower;

    private ArrayList<Behavior> behaviorList;
    private Behavior currentBehavior;


    private Robot()
    {
        instance = this;

        //currentBehavior = new IdleBehavior();//<<-- start gedrag
        //currentBehavior = new FigureEightBehavior();
        currentBehavior = new LineFollowBehavior();

        lf_detections = new boolean[3];

        currentTime = System.nanoTime();
        previousTime = currentTime;

        //maak nieuwe gedrag lijst aan
        behaviorList = new ArrayList();

        //initialiseren van sensoren en motoren
        //motoren
        motorRechts = new Motor(12, true);
        motorLinks = new Motor(13, false);

        //sensoren
        lLineFollower = new LineFollower(2);
        cLineFollower = new LineFollower(1);
        rLineFollower = new LineFollower(3);

        //start current behavior
        currentBehavior.OnStart();

        //loop
        while(true)
        {
            lf_detections[LEFT_S] = lLineFollower.detectLine();
            lf_detections[MID_S] = cLineFollower.detectLine();
            lf_detections[RIGHT_S] = rLineFollower.detectLine();

            currentTime = System.nanoTime();
            double delta = ((double)(currentTime - previousTime) / 1000000000.0);
            previousTime = currentTime;

            if(currentBehavior != null) {
                currentBehavior.Update(delta);
            }else {
                NextBehavior();
            }
            //wacht 500 micro seconden
            BoeBot.wait(0, 500);
        }

    }


    public void SetSpeed(int speed)
    {
        motorRechts.setSpeed(speed);
        motorLinks.setSpeed(speed);
    }

    public void SetTurnspeed(int speed){
        motorRechts.setSpeed(speed*-1);
        motorLinks.setSpeed(speed);
    }

    public boolean GetLineFollower(int lineFollower){
        return lf_detections[lineFollower];
    }


    public void AddBehavior(Behavior behavior){
        behaviorList.add(behavior);
    }

    public void NextBehavior(){
        if(behaviorList.size() > 0)
        {
            if(currentBehavior != null)
            {
                currentBehavior.OnEnd();
            }
            currentBehavior = behaviorList.get(0);
            currentBehavior.OnStart();
            behaviorList.remove(0);
        }
    }



}
