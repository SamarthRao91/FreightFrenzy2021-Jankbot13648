package org.firstinspires.ftc.teamcode.Commands.ManipulatorCommands;

import com.arcrobotics.ftclib.command.CommandBase;
import com.arcrobotics.ftclib.command.InstantCommand;
import com.arcrobotics.ftclib.command.WaitCommand;

import org.firstinspires.ftc.teamcode.Constants;
import org.firstinspires.ftc.teamcode.Systems.Elevator;
import org.firstinspires.ftc.teamcode.Systems.Manipulator;
import org.firstinspires.ftc.teamcode.Systems.Intake;


import java.util.function.BooleanSupplier;
import java.util.function.DoubleSupplier;

public class ManipulatorDefault extends CommandBase {

    private final Manipulator manipulator;

    private final DoubleSupplier leftStickY;

    private final DoubleSupplier speed;

    private final Intake intake;


    public ManipulatorDefault(Manipulator manipulator, DoubleSupplier leftStickY, DoubleSupplier speed, Intake intake) {
        this.manipulator = manipulator;
        this.speed = speed;
        this.intake = intake;
        this.leftStickY = leftStickY;

        addRequirements(manipulator);
    }


    @Override
    public void execute() {
        manipulator.moveArm(-leftStickY.getAsDouble() / 100);
        manipulator.setSpeed(speed.getAsDouble());
        if (manipulator.readColorSensor() > 600) {
            manipulator.closeClaw();
            new WaitCommand(250);
            manipulator.setArm(Constants.Manipulator.Arm.ARM1_LOWER_BOUND - 0.4);
            intake.setIntake(-0.8);
            new WaitCommand(100);
            intake.setIntake(0);
        }


    }


}
