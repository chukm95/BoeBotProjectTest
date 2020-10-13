package BoebotProject.Behaviors;

public class ForwardBehavior extends Behavior {

    private double time;

    @Override
    public void OnStart() {
        time = 0;
        robot.SetSpeed(10);
        //robot.SetSpeed(50);

    }

    @Override
    public void Update(double deltaTime) {
        //tell verstreken tijd op
        time += deltaTime;

        //als er 2 seconden is verstreken
        if(time > 1.0){
            //voeg nieuw gedrag toe
            robot.AddBehavior(new TurnRightBehavior());
            //switch to next behavior in line
            robot.NextBehavior();
        }
    }

    @Override
    public void OnEnd() {

    }
}
