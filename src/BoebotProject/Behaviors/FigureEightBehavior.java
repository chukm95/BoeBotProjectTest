package BoebotProject.Behaviors;

public class FigureEightBehavior extends Behavior {
    @Override
    public void OnStart() {
        robot.AddBehavior(new ForwardBehavior());
        robot.AddBehavior(new TurnRightBehavior());
        robot.AddBehavior(new ForwardBehavior());
        robot.AddBehavior(new TurnRightBehavior());
        robot.AddBehavior(new ForwardBehavior());
        robot.AddBehavior(new TurnRightBehavior());
        robot.AddBehavior(new ForwardBehavior());
        robot.AddBehavior(new TurnLeftBehavior());
        robot.AddBehavior(new ForwardBehavior());
        robot.AddBehavior(new TurnLeftBehavior());
        robot.AddBehavior(new ForwardBehavior());
        robot.AddBehavior(new TurnLeftBehavior());
        robot.AddBehavior(new ForwardBehavior());
        robot.AddBehavior(new IdleBehavior());
        System.out.println("behavior queued");
    }

    @Override
    public void Update(double deltaTime) {
        robot.NextBehavior();
        System.out.println("behavior switched");
    }

    @Override
    public void OnEnd() {

    }
}
