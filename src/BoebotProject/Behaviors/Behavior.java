package BoebotProject.Behaviors;

import BoebotProject.Robot;

public abstract class Behavior {

    protected final Robot robot;

    protected Behavior(){
        robot = Robot.GetInstance();
    }

    public abstract void OnStart();

    public abstract void Update(double deltaTime);

    public abstract void OnEnd();
}
