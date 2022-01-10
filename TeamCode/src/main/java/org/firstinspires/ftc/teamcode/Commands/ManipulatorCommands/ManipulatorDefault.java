package org.firstinspires.ftc.teamcode.Commands.ManipulatorCommands;

import com.arcrobotics.ftclib.command.CommandBase;
import com.arcrobotics.ftclib.command.InstantCommand;
import com.arcrobotics.ftclib.command.WaitCommand;

import org.firstinspires.ftc.teamcode.Constants;
import org.firstinspires.ftc.teamcode.Systems.Elevator;
import org.firstinspires.ftc.teamcode.Systems.Manipulator;

import java.util.function.BooleanSupplier;
import java.util.function.DoubleSupplier;

public class ManipulatorDefault extends CommandBase {

    private final Manipulator manipulator;

    private final DoubleSupplier leftStickY;

    private final DoubleSupplier speed;

    public ManipulatorDefault(Manipulator manipulator, DoubleSupplier leftStickY, DoubleSupplier speed)
    {
        this.manipulator = manipulator;
        this.speed = speed;

        this.leftStickY = leftStickY;

        addRequirements(manipulator);
    }


    @Override
    public void execute() {
        manipulator.moveArm(-leftStickY.getAsDouble()/100);
        manipulator.setSpeed(speed.getAsDouble());
        if (manipulator.readColorSensor() > 3000)
        {
            manipulator.closeClaw();
            new WaitCommand(250);
            manipulator.setArm(Constants.Manipulator.Arm.ARM1_LOWER_BOUND - 0.4);
        }
    }


}
