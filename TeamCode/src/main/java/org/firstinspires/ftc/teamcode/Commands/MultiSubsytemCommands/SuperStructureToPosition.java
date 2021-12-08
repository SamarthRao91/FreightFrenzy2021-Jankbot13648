package org.firstinspires.ftc.teamcode.Commands.MultiSubsytemCommands;

import com.technototes.library.command.Command;

import org.firstinspires.ftc.teamcode.Constants;
import org.firstinspires.ftc.teamcode.Systems.Elevator;
import org.firstinspires.ftc.teamcode.Systems.Manipulator;

public class SuperStructureToPosition implements Command {

    private final Elevator elevator;
    private final Manipulator manipulator;

    private final int elevatorTarget;
    private final int elevatorSpeed;

    private final double turretTarget;
    private final double extenderTarget;
    private final double clawTarget;

    public SuperStructureToPosition(Elevator elevator, Manipulator manipulator, int elevatorTarget, int elevatorSpeed, double turretTarget, double extenderTarget, double clawTarget)
    {
        this.elevator = elevator;
        this.manipulator = manipulator;

        this.elevatorTarget = elevatorTarget;
        this.elevatorSpeed = elevatorSpeed;

        this.turretTarget = turretTarget;
        this.extenderTarget = extenderTarget;
        this.clawTarget = clawTarget;

        addRequirements(elevator, manipulator);
    }

    @Override
    public void initialize()
    {
        manipulator.setExtenderPosition(Constants.Manipulator.Extender.MIN_POS);
        manipulator.setClawPosition(clawTarget);
        elevator.setTargetPosition(elevatorTarget);

        manipulator.setClawPosition(Constants.Manipulator.Claw.CLOSE_POSITION);
    }

    @Override
    public void execute()
    {
        elevator.setSpeed(elevatorSpeed);

        if(elevator.getPosition() > Constants.Elevator.SAFE_TURRET_POSITION)
        {
            manipulator.setTurretPosition(turretTarget);
        }

        if(elevator.getPosition() > Constants.Elevator.SAFE_EXTENDER_POSITION)
        {
            manipulator.setExtenderPosition(extenderTarget);
        }
    }

    @Override
    public void end(boolean isInterrupted)
    {
        elevator.setSpeed(0);
        elevator.setRunMode(Motor.RunMode.RawPower);

        manipulator.setTurretPosition(turretTarget);
        manipulator.setExtenderPosition(extenderTarget);
    }

    @Override
    public boolean isFinished()
    {
        return elevator.atTargetPosition();
    }

}
