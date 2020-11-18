package BoebotProject.Behaviors;

import BoebotProject.Hardware.LineFollower;
import BoebotProject.Robot;
import TI.BoeBot;

// todo maak de LineFollowBehavior, die een lijn volgt tot aan een kruispunt

public class LineFollowBehavior extends Behavior {

    private final double rollOutTime = 10; //after detecting an intersection keep driving for 10 seconds, 10 seconds is to much. change it.
    
    private boolean hasDetectedIntersection;
    private double time;
    
    public LineFollowBehavior() {
        hasDetectedIntersection = false;
        time = 0;
    }

    @Override
    public void OnStart() {
        robot.SetSpeed(10);

    }

    @Override
    public void Update(double deltaTime) {

            // get IR sensor readings
            boolean left = robot.GetLineFollower(Robot.LEFT_S);
            boolean mid = robot.GetLineFollower(Robot.MID_S);
            boolean right = robot.GetLineFollower(Robot.RIGHT_S);
        
            //so we have detected an intersection now we need to drive X seconds forward
            if(hasDetectedIntersection)
            {
                //only after we have detected the intersection we start counting time
                time += deltaTime;
                //check how much time has passed 
                if(time >= rollOutTime)
                {
                    //we have rolled out so lets go to the next behavior
                    robot.SetSpeed(0);
                    //switch to??
                }
            }

            // if left sensor and right sensor do detect black line
            if (left && right) {
                System.out.println("left en right do detect black line");
                System.out.println("move forward....");
                robot.SetSpeed(10);
                hasDetectedIntersection = true;
            }
            // if mid sensor detects black line
            else if (mid) {
                System.out.println("mid line detected....");
                System.out.println("keep moving forward....");
                robot.SetSpeed(10);

            } // if left sensor detects black line
            else if (left && !mid) {
                robot.SetTurnspeed(-20); // left
                System.out.println("left line detected");
                System.out.println("adjusting to left....");

            }// if right sensor detects black line
            else if (right && !mid) {
                robot.SetTurnspeed(20); // right
                System.out.println("right line detected");
                System.out.println("adjusting to right....");
            }
        // unreachable else 
        /*        
        else {
                System.out.println("stop motor.....");
                robot.SetSpeed(0);

        }
        */
    }

    @Override
    public void OnEnd() {

    }

}

