package org.firstinspires.ftc.teamcode.Commands.ElevatorCommands;

import com.technototes.library.command.Command;

import org.firstinspires.ftc.teamcode.Systems.Elevator;

public class ElevatorToPosition implements Command {
    private final Elevator elevator;

    private final int target;
    private final double speed;

    public ElevatorToPosition(Elevator elevator, int target, double speed) {
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
        elevator.setRunMode(Motor.RunMode.RawPower);
    }

    @Override
    public boolean isFinished()
    {
        return elevator.atTargetPosition();
    }
}
