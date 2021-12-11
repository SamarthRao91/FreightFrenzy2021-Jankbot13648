package org.firstinspires.ftc.teamcode.Commands.ManipulatorCommands;

import com.arcrobotics.ftclib.command.CommandBase;

import org.firstinspires.ftc.teamcode.Systems.Manipulator;

import java.util.function.BooleanSupplier;
import java.util.function.DoubleSupplier;

public class ManipulatorDefault extends CommandBase {

    private final Manipulator manipulator;

    private final BooleanSupplier dsStatus;
    private final DoubleSupplier leftStickX;
    private final DoubleSupplier leftStickY;

    public ManipulatorDefault(Manipulator manipulator, BooleanSupplier dsStatus, DoubleSupplier leftStickX, DoubleSupplier leftStickY) {
        this.manipulator = manipulator;

        this.dsStatus = dsStatus;
        this.leftStickX = leftStickX;
        this.leftStickY = leftStickY;

        addRequirements(manipulator);
    }

    @Override
    public void execute() {
        if (Math.abs(leftStickX.getAsDouble()) > 0.25) {
            manipulator.moveTurretPosition(leftStickX.getAsDouble() / 250);
        }
        manipulator.moveExtenderPosition(-leftStickY.getAsDouble() / 200);
    }
}
