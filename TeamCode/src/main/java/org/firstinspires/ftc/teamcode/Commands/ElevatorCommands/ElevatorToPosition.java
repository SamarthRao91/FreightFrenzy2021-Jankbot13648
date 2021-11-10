package org.firstinspires.ftc.teamcode.Commands.ElevatorCommands;

import com.arcrobotics.ftclib.command.CommandBase;

import org.firstinspires.ftc.teamcode.Systems.Elevator;

public class ElevatorToPosition extends CommandBase {
    private final Elevator elevator;

    private final int target;
    private final int speed;

    public ElevatorToPosition(Elevator elevator, int target, int speed) {
        this.elevator = elevator;
        this.target = target;
        this.speed = speed;

        addRequirements(elevator);
    }

    @Override
    public void initialize()
    {
        elevator.setTargetPosition(target);
    }

    @Override
    public void execute()
    {
        elevator.setSpeed(speed);
    }

    @Override
    public void end(boolean isInterrupted)
    {
        elevator.setSpeed(0);
    }

    @Override
    public boolean isFinished()
    {
        return elevator.atTargetPosition();
    }
}
