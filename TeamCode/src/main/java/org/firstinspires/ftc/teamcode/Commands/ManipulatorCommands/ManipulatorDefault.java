package org.firstinspires.ftc.teamcode.Commands.ManipulatorCommands;

import com.arcrobotics.ftclib.command.CommandBase;

import org.firstinspires.ftc.teamcode.Systems.Manipulator;

import java.util.function.BooleanSupplier;
import java.util.function.DoubleSupplier;

public class ManipulatorDefault extends CommandBase {

    private final Manipulator manipulator;

    private final DoubleSupplier leftStickY;

    public ManipulatorDefault(Manipulator manipulator, DoubleSupplier leftStickY)
    {
        this.manipulator = manipulator;

        this.leftStickY = leftStickY;
    }

    @Override
    public void execute() {
        manipulator.moveArm(leftStickY.getAsDouble());
    }
}
