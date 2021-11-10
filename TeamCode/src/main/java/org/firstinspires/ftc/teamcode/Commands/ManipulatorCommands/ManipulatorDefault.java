package org.firstinspires.ftc.teamcode.Commands.ManipulatorCommands;

import com.arcrobotics.ftclib.command.CommandBase;

import org.firstinspires.ftc.teamcode.Constants;
import org.firstinspires.ftc.teamcode.Systems.Elevator;
import org.firstinspires.ftc.teamcode.Systems.Manipulator;

import java.util.function.BooleanSupplier;
import java.util.function.DoubleSupplier;

public class ManipulatorDefault extends CommandBase {

    private final Manipulator manipulator;
    private final Elevator elevator;

    private final BooleanSupplier dsStatus;
    private final DoubleSupplier leftStickX;
    private final DoubleSupplier leftStickY;

    public ManipulatorDefault(Manipulator manipulator, Elevator elevator, BooleanSupplier dsStatus, DoubleSupplier leftStickX, DoubleSupplier leftStickY)
    {
        this.manipulator = manipulator;
        this.elevator = elevator;

        this.dsStatus = dsStatus;
        this.leftStickX = leftStickX;
        this.leftStickY = leftStickY;

        addRequirements(manipulator, elevator);
    }

    @Override
    public void execute() {
        if(dsStatus.getAsBoolean())
        {
            manipulator.setClawPosition(Constants.Manipulator.Claw.CLOSE_POSITION);
            elevator.setTargetPosition(Constants.Elevator.MINIMUM_POSITION + 200);
            elevator.setSpeed(1);
        }

        if(elevator.atTargetPosition())
        {
            elevator.setSpeed(0);
        }

        manipulator.moveTurretPosition(leftStickX.getAsDouble() / 250);
        manipulator.moveExtenderPosition(-leftStickY.getAsDouble() / 200);
    }
}
