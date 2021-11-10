package org.firstinspires.ftc.teamcode.Commands.MultiSubsytemCommands;

import com.arcrobotics.ftclib.command.CommandBase;
import com.arcrobotics.ftclib.hardware.motors.Motor;

import org.firstinspires.ftc.teamcode.Constants;
import org.firstinspires.ftc.teamcode.Systems.Elevator;
import org.firstinspires.ftc.teamcode.Systems.Manipulator;

public class SuperStructureToPosition extends CommandBase {

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
        elevator.setTargetPosition(elevatorTarget);

        manipulator.setClawPosition(Constants.Manipulator.Claw.CLOSE_POSITION);
    }

    @Override
    public void execute()
    {
        elevator.setSpeed(elevatorSpeed);

        if(elevator.getPosition() > Constants.Elevator.SAFE_EXTENDER_POSITION)
        {
            manipulator.setTurretPosition(turretTarget);
            manipulator.setExtenderPosition(extenderTarget);
        }
    }

    @Override
    public void end(boolean isInterrupted)
    {
        elevator.setSpeed(0);
        elevator.setRunMode(Motor.RunMode.RawPower);

        if(manipulator.getTurretPosition() != turretTarget)
        {
            manipulator.setTurretPosition(turretTarget);
        }

        if(manipulator.getExtenderPosition() != extenderTarget)
        {
            manipulator.setTurretPosition(extenderTarget);
        }
    }

    @Override
    public boolean isFinished()
    {
        return elevator.atTargetPosition();
    }

}
