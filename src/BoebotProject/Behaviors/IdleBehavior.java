package BoebotProject.Behaviors;

import BoebotProject.Robot;

public class IdleBehavior extends Behavior {

    public IdleBehavior() {

    }

    @Override
    public void OnStart() {
        robot.SetSpeed(0);
    }

    @Override
    public void Update(double delta) {

    }

    @Override
    public void OnEnd() {

    }
}
