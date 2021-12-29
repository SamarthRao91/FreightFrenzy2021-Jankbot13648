package org.firstinspires.ftc.teamcode.Commands.ManipulatorCommands;

import com.arcrobotics.ftclib.command.CommandBase;

import org.firstinspires.ftc.teamcode.Constants;
import org.firstinspires.ftc.teamcode.Systems.Manipulator;

public class ManualPickup extends CommandBase {
    private final Manipulator manipulator;

    public ManualPickup(Manipulator manipulator) {
        this.manipulator = manipulator;

        addRequirements(manipulator);
    }

    @Override
    public void initialize() {
        manipulator.closeClaw();
        manipulator.setArm(Constants.Manipulator.Arm.ARM1_LOWER_BOUND - 0.2);
    }

    @Override
    public boolean isFinished() {
        return true;
    }
}
