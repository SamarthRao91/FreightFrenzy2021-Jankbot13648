package org.firstinspires.ftc.teamcode.Commands.ElevatorCommands;

import com.acmerobotics.dashboard.FtcDashboard;
import com.arcrobotics.ftclib.command.CommandBase;
import com.arcrobotics.ftclib.hardware.motors.Motor;

import org.firstinspires.ftc.teamcode.Systems.Elevator;

public class ElevatorToPosition extends CommandBase {
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
        elevator.setControllerBounds(speed);
        elevator.setTargetPosition(target);
    }

    @Override
    public void execute()
    {
        elevator.setSpeed(elevator.update());
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