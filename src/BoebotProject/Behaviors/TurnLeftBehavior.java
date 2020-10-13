package BoebotProject.Behaviors;

public class TurnLeftBehavior extends Behavior{

    private double time;

    @Override
    public void OnStart() {
        time = 0;
        robot.SetTurnspeed(-20);
    }

    @Override
    public void Update(double deltaTime) {
        time += deltaTime;
        if(time > 1.894){
            //robot.AddBehavior(new ForwardBehavior());
            robot.NextBehavior();
        }
    }

    @Override
    public void OnEnd() {

    }
}
