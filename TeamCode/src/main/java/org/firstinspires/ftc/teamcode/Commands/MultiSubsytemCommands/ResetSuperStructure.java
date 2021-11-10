package org.firstinspires.ftc.teamcode.Commands.MultiSubsytemCommands;

import com.arcrobotics.ftclib.command.CommandBase;

import org.firstinspires.ftc.teamcode.Constants;
import org.firstinspires.ftc.teamcode.Systems.Elevator;
import org.firstinspires.ftc.teamcode.Systems.Manipulator;
import org.firstinspires.ftc.teamcode.Util.StopWatch;

public class ResetSuperStructure extends CommandBase {

    private final Elevator elevator;
    private final Manipulator manipulator;

    public ResetSuperStructure(Elevator elevator, Manipulator manipulator)
    {
        this.elevator = elevator;
        this.manipulator = manipulator;

        addRequirements(elevator, manipulator);
    }

    @Override
    public void initialize()
    {
        StopWatch timer = new StopWatch(750);

        while(!timer.isExpired());

        manipulator.setClawPosition(Constants.Manipulator.Claw.CLOSE_POSITION);
        manipulator.setExtenderPosition(Constants.Manipulator.Extender.MIN_POS);
        elevator.setTargetPosition(Constants.Elevator.SAFE_EXTENDER_POSITION + 100);
        manipulator.setTurretPosition(Constants.Manipulator.Turret.ZERO_POSITION);

        timer.setTime(750);
        while (!timer.isExpired());

        elevator.setTargetPosition(Constants.Elevator.MINIMUM_POSITION);
    }

    @Override
    public void execute()
    {
        elevator.setSpeed(-1);
    }

    @Override
    public void end(boolean isInterrupted)
    {
        manipulator.setClawPosition(Constants.Manipulator.Claw.OPEN_POSITION);

        StopWatch timer = new StopWatch(250);
        while (!timer.isExpired());
    }

    @Override
    public boolean isFinished()
    {
        return elevator.atTargetPosition();
    }
}
